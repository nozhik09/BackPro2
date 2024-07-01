package Lessons.Lesson_03;

import Lessons.Lesson_03.app.controle.ProductController;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import java.math.BigDecimal;

public class Main {


    public static void main(String[] args) {
        AnnotationConfigApplicationContext context =  new AnnotationConfigApplicationContext("Lessons.Lesson_03.app");

        ProductController controller=context.getBean(ProductController.class);

        System.out.println(controller.getAllProducts());


    }
}
