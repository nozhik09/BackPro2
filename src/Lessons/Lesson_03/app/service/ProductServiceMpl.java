package Lessons.Lesson_03.app.service;

import Lessons.Lesson_03.app.model.Product;
import Lessons.Lesson_03.app.repository.ProductRepository;
import Lessons.Lesson_03.app.repository.ProductRepositoryMapImpl;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

import javax.swing.*;
import java.util.List;



@Service
public class ProductServiceMpl implements ProductService {


    private final ProductRepository repository;

    public ProductServiceMpl(@Qualifier("getProductRepository") ProductRepository repository) {
        this.repository = repository;
    }

    public Product findById(Long id) {
        return repository.findAll()
                .stream()
                .filter(p -> p.getId()==id)
                .findAny()
                .orElse(null);
    }

    public List<Product> getAllProducts(){
        return repository.findAll();
    }






}
