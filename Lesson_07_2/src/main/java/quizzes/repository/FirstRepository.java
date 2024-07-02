package quizzes.repository;


import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Repository;
import quizzes.entities.Book;

import java.util.List;

@Repository
@RequiredArgsConstructor
public class FirstRepository implements MyRepository {

    private final List<Book> books = List.of(
            new Book(1L,"Garri", "Jhoan", 1998),
            new Book(2L,"Book 2", "Author2", 1896)


    );

    @Override
    public Long deletedBook(Long id) {
        return 0L;
    }

    @Override
    public Book updatedBook(Book book) {
        return null;
    }

    @Override
    public List<Book> findAll() {
        return List.copyOf(books);
    }

    @Override
    public Book findById(int findId) {
        return null;
    }

    @Override
    public Book save(Book book) {
        return null;
    }
}
