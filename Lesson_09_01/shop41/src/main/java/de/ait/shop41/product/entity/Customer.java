package de.ait.shop41.product.entity;


import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class Customer {
    private Long id;
    private String name;
    private boolean active;

}
