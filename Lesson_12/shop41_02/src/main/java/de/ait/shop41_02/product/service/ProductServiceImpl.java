package de.ait.shop41_02.product.service;

import de.ait.shop41_02.product.dto.ProductRequestDTO;
import de.ait.shop41_02.product.dto.ProductResponseDTO;
import de.ait.shop41_02.product.entity.Product;
import de.ait.shop41_02.product.repository.ProductRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.nio.file.ProviderNotFoundException;
import java.util.List;


@RequiredArgsConstructor
@Service
public class ProductServiceImpl implements ProductService{
    private final ProductRepository repository;


    @Override
    public ProductResponseDTO save(ProductRequestDTO productRequestDTO) {
        Product product = ProductRequestDTO.of(productRequestDTO);
        return ProductResponseDTO.of(repository.save(product));
    }

    @Override
    public List<ProductResponseDTO> getAllProducts() {
        return ProductResponseDTO.of(repository.findAll());
    }

    @Override
    public Product getById(Long id) {
        return repository.findById(id).orElseThrow(()->new ProviderNotFoundException());
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
