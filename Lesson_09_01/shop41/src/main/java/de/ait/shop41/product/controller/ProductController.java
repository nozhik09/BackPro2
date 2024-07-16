package de.ait.shop41.product.controller;


import de.ait.shop41.product.entity.Product;
import de.ait.shop41.product.productService.ProductService;
import lombok.AllArgsConstructor;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/api/products")
@RequiredArgsConstructor
public class ProductController {
private final ProductService service;



//    private static List<Product> list = new ArrayList<>(List.of(
//            new Product(1L, "Kefir", new BigDecimal("1.29"), true),
//            new Product(2L, "Milk", new BigDecimal("0.99"), true),
//            new Product(3L, "Butter", new BigDecimal("2.45"), true),
//            new Product(4L, "Bread", new BigDecimal("1.89"), true),
//            new Product(5L, "Arran", new BigDecimal("1.12"), false),
//            new Product(6L, "Kumis", new BigDecimal("1.90"), false)
//    ));


    @GetMapping
    public List<Product> getProducts(@RequestParam(name = "active", required = false, defaultValue = "all") String active) {
        if (active.equals("false")) {
            return service.getAllNotActiveProducts();

        } else if (active.equals("true")) {
            return service.getAllActiveProducts();

        }
        return service.getAllProducts();
    }

    @GetMapping("/{id}")
    public Product getProduct(@PathVariable long id) {
        return service.getById(id);
    }


    //    удаление продукта с заданным id
    @DeleteMapping("/{id}")
    public Product deliteProduct(@PathVariable Long id) {
        return service.deleteById(id);
    }

    @PostMapping
    public ResponseEntity<Product> createNewProduct(@RequestBody Product product) {
       Product savedProduct = service.save(product);
        return new ResponseEntity<>(savedProduct, HttpStatus.CREATED);
    }

    @PutMapping("/{id}")
    public Product updateProduct(@PathVariable Long id, @RequestBody Product product) {
        Product udateProduct = service.update(id,product);

        return udateProduct;
    }




}
