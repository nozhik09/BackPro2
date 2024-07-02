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
    public Service(@Value("${repository.type}") String repositoryType,
                   @Qualifier("firstRepository") MyRepository firstRepository,
                   @Qualifier("secondRepo") MyRepository secondRepo,
                   @Qualifier("repoByJDBC") MyRepository thirdRepository,
                   @Qualifier("hibernateRepository") MyRepository hibernateRepository)
    {

        if (repositoryType.equals("firstRepository")) {
            this.myRepository = firstRepository;
        } else if (repositoryType.equals("secondRepo")) {
            this.myRepository = secondRepo;
        } else if(repositoryType.equals("hibernate")) {
            this.myRepository = hibernateRepository;
        }else {
            this.myRepository=thirdRepository;
        }
    }

    public List<Book> findAll() {
        return myRepository.findAll();
    }

    public Book findBookById(int findId){
        return myRepository.findById(findId);
    }

    public Book save(Book book){
       return myRepository.save(book);
    }
    public Long deleteBook(Long id){
        return  myRepository.deletedBook(id);
    }

    public Book updateBook(Book book){
        return myRepository.updatedBook(book);
    }

}
