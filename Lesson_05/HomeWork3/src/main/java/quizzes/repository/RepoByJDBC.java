package quizzes.repository;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.PropertySource;
import org.springframework.stereotype.Repository;
import quizzes.entities.Book;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;


@Repository
@PropertySource("classpath:applications.properties")
public class RepoByJDBC implements MyRepository {
    private String driver;
    private String url;
    private String dbname;
    private String userName;
    private String password;

    //Constructor
    RepoByJDBC(@Value("${db.driver}") String driver,
               @Value("${db.url}") String url,
               @Value("${db.dbname}") String dbname,
               @Value("${db.username}") String userName,
               @Value("${db.password}") String password) {

        this.dbname = dbname;
        this.url = url;
        this.password = password;
        this.userName = userName;
        this.driver = driver;
        loadDriver();
    }

    private void loadDriver() {
        try {
            Class.forName(driver);
        } catch (ClassNotFoundException e) {
            throw new RuntimeException(String.format("Driver not found:%s", driver), e);
        }
    }

    public Connection getConnection() {
        try {
            Connection connection = DriverManager.getConnection(url + dbname, userName, password);
            return connection;
        } catch (SQLException e) {
            throw new RuntimeException("Create connection fail", e);
        }
    }

    @Override
    public Book updatedBook(Book book) {
        if (book.getId() != null) {
            return updateBook(book);
        } else {
            return null;
        }
    }

    @Override
    public Book save(Book book) {
        if (book.getId() == null) {
            return create(book);
        } else {
            return null;
        }
    }

    @Override
    public Long deletedBook(Long id) {
        if (id != null) {
            return deleteBook(id);
        } else {
            return null;
        }
    }

    @Override
    public List<Book> findAll() {
        String query = "SELECT*FROM books";
        try (Connection connection = getConnection()) {
            if (connection == null) {
                throw new RuntimeException("Failed to create connection");
            }
            Statement statement = connection.createStatement();
            ResultSet resultSet = statement.executeQuery(query);
            List<Book> result = new ArrayList<>();
            while (resultSet.next()) {
                long id = resultSet.getLong("id");
                String title = resultSet.getString("title");
                String author = resultSet.getString("author");
                int year = resultSet.getInt("year");
                Book book = new Book(id, title, author, year);
                result.add(book);
            }
            return result;
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }


    @Override
    public Book findById(int findId) {
        try (Connection connection = getConnection()) {
            String sql = "select * from books";
            Statement statement = connection.createStatement();
            ResultSet resultSet = statement.executeQuery(sql);
            while (resultSet.next()) {
                long id = resultSet.getLong("id");
                String title = resultSet.getString("title");
                String author = resultSet.getString("author");
                int year = resultSet.getInt("year");
                if (findId == id) {
                    Book book = new Book(id, title, author, year);
                    System.out.println(book);
                    return book;
                }
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        return null;
    }

    private Long deleteBook(Long id) {
        String query = "DELETE FROM books WHERE id = ?";
        try (Connection connection = getConnection()) {
            if (connection == null) {
                throw new RuntimeException("Create connection fail");
            }
            PreparedStatement preparedStatement = connection.prepareStatement(query);
            preparedStatement.setLong(1, id);
            int affectedRows = preparedStatement.executeUpdate();
            if (affectedRows != 1) {
                throw new RuntimeException("Not found book id");
            }
            return id;
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }

    }


    private Book create(Book book) {
        String query = "INSERT INTO books (title,author,year) VALUES (?,?,?);";
        try (Connection connection = getConnection()) {
            connection.createStatement();
            if (connection == null) {
                throw new RuntimeException("Create connection fail");
            }
            PreparedStatement preparedStatement = connection.prepareStatement(query, Statement.RETURN_GENERATED_KEYS);
            preparedStatement.setString(1, book.getTitle());
            preparedStatement.setString(2, book.getAuthor());
            preparedStatement.setInt(3, book.getYear());
            int affectedRows = preparedStatement.executeUpdate();
            ResultSet resultSet = preparedStatement.getGeneratedKeys();
            if (!resultSet.next()) {
                throw new RuntimeException("Create book fail");
            } else {
                book.setId(resultSet.getLong("id"));
            }


        } catch (SQLException e) {
            throw new RuntimeException(e);
        }

        return book;
    }


    private Book updateBook(Book book) {
        String query = "UPDATE books SET title = ?,author = ?, year = ? WHERE id = ?";
        try (Connection connection = getConnection()) {
            PreparedStatement preparedStatement = connection.prepareStatement(query);
            preparedStatement.setLong(4, book.getId());
            preparedStatement.setString(1, book.getTitle());
            preparedStatement.setString(2, book.getAuthor());
            preparedStatement.setInt(3, book.getYear());
            int affectedRows = preparedStatement.executeUpdate();
            if (affectedRows == 1) {
                return book;
            } else {
                throw new RuntimeException("Nook not found");
            }

        } catch (SQLException e) {
            throw new RuntimeException(e);
        }


    }

    //TODO подключить hibernate
}
