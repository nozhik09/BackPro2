package de.ait.shop41.product.controller;


import de.ait.shop41.product.entity.Product;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

@RestController
public class ProductController {
    private static List<Product> list = new ArrayList<>(List.of(
            new Product(1L, "Kefir", new BigDecimal("1.29"), true),
            new Product(2L, "Milk", new BigDecimal("0.99"), true),
            new Product(3L, "Butter", new BigDecimal("2.45"), true),
            new Product(4L, "Bread", new BigDecimal("1.89"), true)

    ));


    @GetMapping("/products")
    public List<Product> getProducts() {
        return list;
    }

   @GetMapping("/products/{id}")
    public Product getProduct(@PathVariable long id) {
        return list.stream()
                .filter(p -> p.getId().equals(Long.valueOf(id)))
                .findAny()
                .get();
    }

    //    удаление продукта с заданным id
    @DeleteMapping("/products/{id}")
    public Product deliteProduct(@PathVariable Long id) {
        Product product = list.stream()
                .filter(p -> p.getId().equals(Long.valueOf(id)))
                .findAny()
                .get();

        list = list.stream()
                .filter(p -> p.getId().equals(Long.valueOf(id)))
                .collect(Collectors.toList());
        return product;
    }


}
