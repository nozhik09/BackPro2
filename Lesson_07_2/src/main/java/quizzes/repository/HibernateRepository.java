package quizzes.repository;


import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityTransaction;
import org.hibernate.cfg.Configuration;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import quizzes.configuration.HibernateUtil;
import quizzes.entities.Book;

import java.util.List;

@Repository
public class HibernateRepository implements MyRepository {
    private final EntityManager entitiManager;
    private final HibernateUtil hibernateUtil;


    @Autowired
    public HibernateRepository(HibernateUtil hibernateUtil) {
        this.hibernateUtil = hibernateUtil;
        entitiManager = hibernateUtil
                .getSessionFactory()
                .createEntityManager();
    }


    @Override
    public List<Book> findAll() {
        return entitiManager.createQuery("from Book", Book.class).getResultList();

    }

    @Override
    public Book findById(int findId) {
        return null;
    }

    @Override
    public Book save(Book book) {
        EntityTransaction transaction = entitiManager.getTransaction();
        try {
            transaction.begin();
            entitiManager.persist(book);
            transaction.commit();
            return book;
        } catch (Exception e) {
            if (transaction.isActive()) {
                transaction.rollback();
            }
        }
        throw new RuntimeException("Save" + book + "is cancelled");
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
