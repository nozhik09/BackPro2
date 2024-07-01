package Lessons.Lesson_03.app.repository;

import Lessons.Lesson_03.app.model.Product;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Repository;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

@Repository
public class ProductRepositoryListImpl implements ProductRepository {
    private List<Product> db = new ArrayList<>();


    public ProductRepositoryListImpl() {
        init();
    }

    private void init() {
        db.add(new Product(1L, "Orange", new BigDecimal("0.90")));
        db.add(new Product(2L, "Tomato", new BigDecimal("1.90")));
        db.add(new Product(3L, "Apple", new BigDecimal("0.80")));
        db.add(new Product(3L, "Juice", new BigDecimal("1.20")));
    }

    @Override
    public List<Product> findAll() {
        return new ArrayList<>(db);
    }

    @Override
    public Product save(Product product) {
        db.add(product);

        return product;
    }
}
