package de.ait.shop41_02.product.service;

import de.ait.shop41_02.product.dto.ProductRequestDTO;
import de.ait.shop41_02.product.dto.ProductResponseDTO;
import de.ait.shop41_02.product.entity.Product;

import java.util.List;

public interface ProductService {
    ProductResponseDTO save(ProductRequestDTO productRequestDTO);

    Product getById(Long id);

    Product update(Long id, Product product);

    List<ProductResponseDTO> getAllProducts();

    List<ProductResponseDTO> getAllActiveProducts();

    List<ProductResponseDTO> getAllNotActiveProducts();

    Product deleteById(Long id);

}
