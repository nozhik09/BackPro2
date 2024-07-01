package de.ait;


import com.fasterxml.jackson.databind.ObjectMapper;
import org.apache.catalina.mapper.Mapper;
import org.springframework.boot.SpringApplication;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import quizzes.controller.MyController;

import java.util.Objects;

public class Main {
    public static void main(String[] args) {

        AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext("quizzes");
        MyController controller = context.getBean(MyController.class);
        ObjectMapper mapper = new ObjectMapper();

    }
}