package quizzes.servise;


import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.PropertySource;
import quizzes.entities.Book;
import quizzes.repository.MyRepository;

import java.util.List;

@org.springframework.stereotype.Service
//@RequiredArgsConstructor
@PropertySource("classpath:applications.properties")
public class Service {


    private final MyRepository myRepository;
@Autowired
    public Service(@Value("${repository.type}")String repositoryType,
                   @Qualifier("firstRepository") MyRepository firstRepository,
                   @Qualifier("secondRepo") MyRepository secondRepo){

    if (repositoryType.equals(firstRepository)){

        this.myRepository=firstRepository;
    }else {
        this.myRepository=secondRepo;

    }
}

public List<Book> findAll(){
    return myRepository.findAll();
}



}
