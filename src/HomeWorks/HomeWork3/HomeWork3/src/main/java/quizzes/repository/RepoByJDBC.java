package quizzes.repository;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Repository;
import quizzes.entities.Book;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;


@Repository
@RequiredArgsConstructor
public class RepoByJDBC {



    public Book findById(Connection connection, long findId) {
        try {
            String sql = "select * from books";
            Statement statement = connection.createStatement();
            ResultSet resultSet = statement.executeQuery(sql);

            while (resultSet.next()) {
                long id = resultSet.getLong(1);
                String title = resultSet.getString(2);
                String author = resultSet.getString(3);
                int year = resultSet.getInt(4);
                if (findId == id) {
                    Book book = new Book(title, author, year);
                    System.out.println(book);
                    return book;
                }
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        return null;


    }


    public List<Book> findAll(Connection connection) {
        List<Book> list = new ArrayList<>();
        try {
            String sql = "select * from books";
            Statement statement = connection.createStatement();
            ResultSet resultSet = statement.executeQuery(sql);

            while (resultSet.next()) {
                long id = resultSet.getLong(1);
                String title = resultSet.getString(2);
                String author = resultSet.getString(3);
                int year = resultSet.getInt(4);
                Book book = new Book(title, author, year);
                list.add(book);
                System.out.println(book);
                return list;
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        return list;
    }

    public Connection getConnection(String driver, String url, String db, String userName, String password) {
        try {
            String connectString = String.format("%s%s?user=%s&password=%s", url, db, userName, password);
            Connection connection1 = DriverManager.getConnection(connectString);
            Class.forName(driver);
            return connection1;
        } catch (ClassNotFoundException e) {
            throw new RuntimeException(e);
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }


}
