package de.ait.shop41.product.productService;

import de.ait.shop41.product.entity.Product;

import java.util.List;

public interface ProductService {
Product save(Product product);

Product getById(Long id);

Product update(Long id , Product product);

List<Product> getAllProducts();

List<Product> getAllActiveProducts();

List<Product> getAllNotActiveProducts();

Product deleteById(Long id);

}
