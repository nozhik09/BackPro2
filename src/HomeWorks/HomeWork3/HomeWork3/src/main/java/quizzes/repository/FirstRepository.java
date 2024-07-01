package quizzes.repository;


import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Repository;
import quizzes.entities.Book;

import java.util.List;

@Repository
@RequiredArgsConstructor
public class FirstRepository implements MyRepository {

    private final List<Book> books = List.of(new Book("Garri", "Jhoan", 1998),
            new Book("Book 2", "Author2", 1896)


    );


    @Override
    public List<Book> findAll() {
        return List.copyOf(books);
    }

    @Override
    public Book findById() {
        return null;
    }
}
