package Lessons.Lesson_03.app.repository;

import Lessons.Lesson_03.app.model.Product;
import org.springframework.stereotype.Repository;

import java.math.BigDecimal;
import java.util.HashMap;
import java.util.List;
import java.util.Map;




@Repository
public class ProductRepositoryMapImpl implements ProductRepository {


    private final Map<Long , Product> db = new HashMap<>();

    public ProductRepositoryMapImpl() {
        init();


    }


    private void init() {
        db.put(1L,new Product(1L,"Banana",new BigDecimal("0.90")));
        db.put(2L,new Product(2L,"Tomato",new BigDecimal("1.90")));
        db.put(3L,new Product(3L,"Apple",new BigDecimal("0.80")));
        db.put(4L,new Product(3L,"Milk",new BigDecimal("1.20")));
    }

    //CRUD
    public List<Product> findAll(){
        return db.values().stream().toList();
    }

    public Product save(Product product){
        db.put(product.getId(), product);
        return product;
    }


















}
