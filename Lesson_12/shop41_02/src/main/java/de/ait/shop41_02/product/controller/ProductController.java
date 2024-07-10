package de.ait.shop41_02.product.controller;

import de.ait.shop41_02.product.dto.ProductRequestDTO;
import de.ait.shop41_02.product.dto.ProductResponseDTO;
import de.ait.shop41_02.product.entity.Product;
import de.ait.shop41_02.product.service.ProductService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.Parameter;
import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api/products")
@Tag(name = "Product Controller",description = "Contoller for various operation with Products")
public class ProductController {

    private final ProductService service;


/*
    private static List<Product> list = new ArrayList<>(List.of(
            new Product(1L, "Kefir",new BigDecimal("1.29"),true),
            new Product(2L, "Milk",new BigDecimal("0.99"),true),
            new Product(3L, "Kumis",new BigDecimal("0.94"),false),
            new Product(4L, "Butter",new BigDecimal("2.45"),true),
            new Product(5L, "Airan",new BigDecimal("2.45"),false),
            new Product(6L, "Broth",new BigDecimal("1.89"),true)
    ));
*/


    //   "/products"
    //   "/food-products"
    // "/products?active=false&sortType=byTitle"
    //   "/products/2"
    @Operation(summary = "Get list of products " , description = "Get all products by active value")
    @GetMapping
    //@RequestMapping(method = RequestMethod.GET)
    public List<ProductResponseDTO> getProducts(
            @RequestParam(name="active", required = false, defaultValue = "all")
            @Parameter(description = "For getting all active product should be true and should be false for non active" , example = "true")
            String active) {
        if (active.equals("false")){
            return service.getAllNotActiveProducts();
        } else if (active.equals("true")) {
            return service.getAllActiveProducts();
        }
        return service.getAllProducts();
    }
    @GetMapping("/{id}")
    public  Product getProduct(@PathVariable (name = "id") long id){
        return service.getById(id);
    }

    // customers/2/orders/10
    // @GetMapping("customers/{customerId}/orders/{orderId}")
    //  public  Order getCustomerOrderById(@PathVariable long customerId, @PathVariable long orderId)

    @DeleteMapping("/{id}")
    public  Product deleteProduct(@PathVariable (name = "id") long id){
        return service.deleteById(id);
    }

    @PostMapping
    public ResponseEntity<ProductResponseDTO> createNewProduct(@RequestBody ProductRequestDTO product){
        ProductResponseDTO saved = service.save(product);
        return new ResponseEntity<>(saved, HttpStatus.CREATED);
    }

    @PutMapping("/{id}")
    public Product updateProduct(@PathVariable Long id, @RequestBody Product product){
        Product updated = service.update(id, product);
        return updated;
    }



}
