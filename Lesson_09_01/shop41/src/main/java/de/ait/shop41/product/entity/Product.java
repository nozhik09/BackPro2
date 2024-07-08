package de.ait.shop41.product.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.Getter;

import java.math.BigDecimal;



@Data
@AllArgsConstructor
@Getter
public class Product {

    private Long id;
    private String title;
    private BigDecimal price;
    private boolean active;
}
