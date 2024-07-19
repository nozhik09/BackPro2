package de.ait.shop41_02.product.dto;

import de.ait.shop41_02.product.entity.Product;
import io.swagger.v3.oas.annotations.media.Schema;
import jakarta.validation.constraints.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.math.BigDecimal;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class ProductRequestDTO {

    @NotNull(message = "product title should be not null")
    @NotBlank(message = "product title should be not blank")
//    @Pattern(regexp = "[A-Z][a-z]{2,}",message = "not valid pattern")
    @Schema(description = "product title" , example = "milk")
    private String title;


    @DecimalMax(value = "10000.00")
    @DecimalMin(value = "0.01")
    @Schema(description = "price title" , example = "9.99")
    private BigDecimal price;


    @Schema(description = "product active status" , example = "true")
    private boolean active;


    public static Product of(ProductRequestDTO productDTO){
        return new Product(null, productDTO.title, productDTO.price, productDTO.active);

    }
}
