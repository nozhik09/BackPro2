package quizzes;


import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import quizzes.controller.MyController;
import quizzes.repository.RepoByJDBC;

import java.sql.Connection;

public class Main {
    public static void main(String[] args) {
        String driver = "org.postgresql.Driver";
        String url = "jdbc:postgresql://localhost:5432/";
        String db = "ait41_1";
        String userName = "postgres";
        String password = "Tumagedyb";

        AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext("quizzes");
//        MyController controller = context.getBean(MyController.class);
//        ObjectMapper mapper = new ObjectMapper();
//        controller.printAllBooks();
//
//
//        try {
//            String json = mapper.writeValueAsString(controller.printAllBooks().get(0));
//            System.out.println(json);
//        }catch (JsonProcessingException e){
//            e.printStackTrace();
//        }

        RepoByJDBC repoByJDBC = context.getBean(RepoByJDBC.class);
        Connection connection = repoByJDBC.getConnection(driver, url, db, userName, password);
        repoByJDBC.findAll(connection);
        repoByJDBC.findById(connection,2);


    }


}
