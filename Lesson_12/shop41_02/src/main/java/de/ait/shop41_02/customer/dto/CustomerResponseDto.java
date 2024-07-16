package de.ait.shop41_02.customer.dto;


import de.ait.shop41_02.cart.dto.CartResponseDto;
import de.ait.shop41_02.cart.entity.Cart;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;


@Data
@NoArgsConstructor
@AllArgsConstructor
public class CustomerResponseDto {


    private Long id;
    private String name;
    private boolean active;
    private CartResponseDto cart;

}
