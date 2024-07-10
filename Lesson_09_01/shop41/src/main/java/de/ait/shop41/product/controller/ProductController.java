package de.ait.shop41.product.controller;


import de.ait.shop41.product.entity.Product;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/api/products")
public class ProductController {
    private static List<Product> list = new ArrayList<>(List.of(
            new Product(1L, "Kefir", new BigDecimal("1.29"), true),
            new Product(2L, "Milk", new BigDecimal("0.99"), true),
            new Product(3L, "Butter", new BigDecimal("2.45"), true),
            new Product(4L, "Bread", new BigDecimal("1.89"), true),
            new Product(5L, "Arran", new BigDecimal("1.12"), false),
            new Product(6L, "Kumis", new BigDecimal("1.90"), false)
    ));


    @GetMapping
    public List<Product> getProducts(@RequestParam(name = "active", required = false, defaultValue = "all") String active) {
        if (active.equals("false")) {
            return list.stream().filter(product -> !product.isActive()).toList();

        } else if (active.equals("true")) {
            return list.stream().filter(product -> product.isActive()).toList();

        }
        return list;
    }

    @GetMapping("/{id}")
    public Product getProduct(@PathVariable long id) {
        return list.stream()
                .filter(p -> p.getId().equals(Long.valueOf(id)))
                .findAny()
                .get();
    }


    //    удаление продукта с заданным id
    @DeleteMapping("/{id}")
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

    @PostMapping
    public ResponseEntity<Product> createNewProduct(@RequestBody Product product) {
        product.setId(Long.valueOf(list.size() + 1));
        list.add(product);
        return new ResponseEntity<>(product, HttpStatus.CREATED);
    }

    @PutMapping("/{id}")
    public Product updateProduct(@PathVariable Long id, @RequestBody Product product) {
        Product udateProduct = getProduct(id);
        if (udateProduct!=null){
            udateProduct.setTitle(product.getTitle());
            udateProduct.setPrice(product.getPrice());
            udateProduct.setActive(product.isActive());
        }
        return udateProduct;


    }


}
