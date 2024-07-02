package quizzes.repository;


import org.springframework.stereotype.Repository;
import quizzes.entities.Book;

import java.util.List;

@Repository
public class HibernateRepository implements MyRepository {
    @Override
    public List<Book> findAll() {
        System.out.println("Hibernate");
        return List.of();
    }

    @Override
    public Book findById(int findId) {
        return null;
    }

    @Override
    public Book save(Book book) {
        return null;
    }

    @Override
    public Long deletedBook(Long id) {
        return 0L;
    }

    @Override
    public Book updatedBook(Book book) {
        return null;
    }
}
