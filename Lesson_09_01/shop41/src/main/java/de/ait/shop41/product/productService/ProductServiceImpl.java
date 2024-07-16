package de.ait.shop41.product.productService;

import de.ait.shop41.product.entity.Product;
import de.ait.shop41.product.expeptions.ProductNotFoundException;
import de.ait.shop41.product.repository.ProductRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;


@Service
@RequiredArgsConstructor
public class ProductServiceImpl implements ProductService {

    private final ProductRepository productRepository;


    @Override
    public Product save(Product product) {
        return productRepository.save(product);
    }

    @Override
    public Product getById(Long id) {
        return productRepository.findById(id).orElseThrow(()-> new ProductNotFoundException());
    }

    @Override
    public Product deleteById(Long id) {
        productRepository.deleteById(id);
        return null;
    }

    @Override
    public Product update(Long id, Product product) {
        Product updatedProduct = getById(id);
        updatedProduct.setTitle(product.getTitle());
        updatedProduct.setPrice(product.getPrice());
        updatedProduct.setActive(product.isActive());
        return productRepository.save(updatedProduct);
    }

    @Override
    public List<Product> getAllProducts() {
        return productRepository.findAll();
    }

    @Override
    public List<Product> getAllActiveProducts() {
        return productRepository.findProductByActive(true);
    }

    @Override
    public List<Product> getAllNotActiveProducts() {
        return productRepository.findProductByActive(false);
    }
}
