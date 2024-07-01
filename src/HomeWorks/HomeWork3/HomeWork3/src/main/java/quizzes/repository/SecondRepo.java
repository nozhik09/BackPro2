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
            1L, new Book("Book 4", "Author4", 1896),
            2L, new Book("Book 5", "Author5", 1896),
            3L, new Book("Book 6", "Author6", 1896)


    );

    @Override
    public List<Book> findAll() {
        return new ArrayList<>(books.values());
    }

    @Override
    public Book findById() {
        return null;
    }
}
