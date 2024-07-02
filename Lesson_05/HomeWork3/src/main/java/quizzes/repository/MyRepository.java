package quizzes.repository;

import quizzes.entities.Book;

import java.util.List;

public interface MyRepository {
    List<Book> findAll();

    Book findById(int findId);

    Book save(Book book);

    Long deletedBook(Long id);
    Book updatedBook (Book book);
}
