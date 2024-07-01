package quizzes.controller;


import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;
import quizzes.servise.Service;

@Component
@RequiredArgsConstructor
public class MyController {
    private final Service service;


    public void printAllBooks(){

        service.findAll().forEach(System.out::println);

    }



}
