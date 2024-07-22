package de.ait.shop41_02.customer.dto;


import de.ait.shop41_02.customer.entity.Customer;
import io.swagger.v3.oas.annotations.media.Schema;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class CustomerRequestDto {

    @Schema(description = "Customer Name", example = "John Doe")
    private String name;
    private boolean active;

    public static Customer toEntity(CustomerRequestDto customerRequestDto) {

        return new Customer(null, customerRequestDto.name, customerRequestDto.active, null);
    }

}
