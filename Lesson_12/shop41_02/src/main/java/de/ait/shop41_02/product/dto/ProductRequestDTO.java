package de.ait.shop41_02.product.dto;

import de.ait.shop41_02.product.entity.Product;
import io.swagger.v3.oas.annotations.media.Schema;
import jakarta.persistence.Column;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.math.BigDecimal;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class ProductRequestDTO {

    @Schema(description = "product title" , example = "milk")
    private String title;

    @Schema(description = "price title" , example = "1.09")
    private BigDecimal price;

    @Schema(description = "product active status" , example = "true")
    private boolean active;


    public static Product of(ProductRequestDTO productDTO){
        return new Product(null, productDTO.title, productDTO.price, productDTO.active);

    }
}
