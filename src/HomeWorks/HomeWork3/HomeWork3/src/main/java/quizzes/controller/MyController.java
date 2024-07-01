package quizzes.controller;


import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;
import quizzes.entities.Book;
import quizzes.servise.Service;

import java.util.List;

@Component
@RequiredArgsConstructor
public class MyController {
    private final Service service;


    public List<Book> printAllBooks(){
        return service.findAll();
    }

}
