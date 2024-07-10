package de.ait.shop41_02.product.dto;

import de.ait.shop41_02.product.entity.Product;
import io.swagger.v3.oas.annotations.media.Schema;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.math.BigDecimal;
import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class ProductResponseDTO {

    @Schema(description = "product unique" , example = "100")
    private Long id;

    @Schema(description = "product title" , example = "milk")
    private String title;


    @Schema(description = "price title" , example = "1.09")
    private BigDecimal price;


    @Schema(description = "product active status" , example = "true")
    private boolean active;

public static ProductResponseDTO of(Product product){
    return new ProductResponseDTO(
            product.getId(),
            product.getTitle(),
            product.getPrice(),
            product.isActive());
}

    public static List<ProductResponseDTO> of(List<Product> product){
        return product.stream().map(ProductResponseDTO::of).toList();
    }








}
