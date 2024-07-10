package de.ait.shop41_02.product.repository;

import de.ait.shop41_02.product.entity.Product;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface ProductRepository extends JpaRepository<Product,Long> {

    List<Product> findProductsByActive(boolean active);

}
