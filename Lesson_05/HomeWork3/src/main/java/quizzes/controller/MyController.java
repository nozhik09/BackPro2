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

    public Book finBookById(int id){
        return service.findBookById(id);
    }

    public Book save(Book book){
        return service.save(book);
    }

    public Long deleteBook(Long id){
        return service.deleteBook(id);
    }

    public Book updateBook(Book book){
        return service.updateBook(book);
    }

}
