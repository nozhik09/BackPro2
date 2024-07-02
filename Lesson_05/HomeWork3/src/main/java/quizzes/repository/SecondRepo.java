package quizzes.repository;


import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Repository;
import quizzes.entities.Book;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

@Repository
@RequiredArgsConstructor
public class SecondRepo implements MyRepository {

    private final Map<Long, Book> books = Map.of(
            1L, new Book(1L,"Book 4", "Author4", 1896),
            2L, new Book(2L,"Book 5", "Author5", 1896),
            3L, new Book(3L,"Book 6", "Author6", 1896)


    );

    @Override
    public List<Book> findAll() {
        return new ArrayList<>(books.values());
    }

    @Override
    public Book findById(int findId) {
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

    @Override
    public Book save(Book book) {
        return null;
    }
}
