package quizzes;


import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import quizzes.controller.MyController;
import quizzes.entities.Book;
import quizzes.repository.RepoByJDBC;

import java.sql.Connection;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext("quizzes");
        MyController controller = context.getBean(MyController.class);
//        ObjectMapper mapper = new ObjectMapper();
//        System.out.println(controller.printAllBooks());

//        Book saveBook = controller.save(new Book(null, "Wither", "Sapkovski", 1998));
//        System.out.println(saveBook);
//        System.out.println(controller.deleteBook(3L));

//        Book garriPotter = controller.updateBook(new Book(1L, "Garri Potter", "Дж.К. Роулинг",1996));
//        System.out.println(garriPotter);



//        controller.updateBook(new Book(5L,"Ведьмак","Аджей Сапковский",2007));
//        System.out.println(controller.deleteBook(10L));
        System.out.println(controller.printAllBooks());


//        try {
//            String json = mapper.writeValueAsString(controller.printAllBooks().get(0));
//            System.out.println(json);
//        }catch (JsonProcessingException e){
//            e.printStackTrace();
//        }

//        RepoByJDBC repoByJDBC = context.getBean(RepoByJDBC.class);
//        Connection connection = repoByJDBC.getConnection(driver, url, db, userName, password);
//        repoByJDBC.findAll(connection);
//        repoByJDBC.findById(connection,2);


    }


}
