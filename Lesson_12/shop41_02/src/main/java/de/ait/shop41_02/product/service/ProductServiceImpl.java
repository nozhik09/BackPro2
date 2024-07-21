package de.ait.shop41_02.product.service;

import de.ait.shop41_02.exception_handing.exceptions.ProductNotFoundException2;
import de.ait.shop41_02.exception_handing.exceptions.ProductNotFoundException3;
import de.ait.shop41_02.logging.Profiler;
import de.ait.shop41_02.product.dto.ProductRequestDTO;
import de.ait.shop41_02.product.dto.ProductResponseDTO;
import de.ait.shop41_02.product.entity.Product;
import de.ait.shop41_02.product.repository.ProductRepository;
import lombok.RequiredArgsConstructor;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.stereotype.Service;

import java.util.List;


@RequiredArgsConstructor
@Service
public class ProductServiceImpl implements ProductService{
    private final ProductRepository repository;
    private final Logger logger = LogManager.getLogger(ProductServiceImpl.class);


    @Override
    public ProductResponseDTO save(ProductRequestDTO productRequestDTO) {
        Product product = ProductRequestDTO.of(productRequestDTO);
        return ProductResponseDTO.of(repository.save(product));
    }

    @Override
    @Profiler
    public List<ProductResponseDTO> getAllProducts() {
        return ProductResponseDTO.of(repository.findAll());
    }

    @Override
    public Product getById(Long id) {
        logger.error("get by id start with {}: ",id);
        logger.warn("get by id end with {}: ",id);
        logger.info("get by id end with {}: ",id);
        return repository.findById(id).orElseThrow(()->new ProductNotFoundException3(String.format("Product with id %s not found", id)));
    }


    @Override
    public Product getEntityById(Long id) {
        return repository.findById(id).orElseThrow(()->
                new ProductNotFoundException2(String.format("Product with id %s not found", id)));
    }

    @Override
    public Product update(Long id, Product product) {
        Product updatedProduct = getById(id);
        updatedProduct.setTitle(product.getTitle());
        updatedProduct.setPrice(product.getPrice());
        updatedProduct.setActive(updatedProduct.isActive());

        return repository.save(updatedProduct);
    }



    @Override
    public List<ProductResponseDTO> getAllActiveProducts() {
        return ProductResponseDTO.of(repository.findAll());
    }

    @Override
    public List<ProductResponseDTO> getAllNotActiveProducts() {

       return ProductResponseDTO.of(repository.findProductsByActive(false));

    }

    @Override
    public Product deleteById(Long id) {
        return null;
    }
}
