package de.ait.shop41_02.customer.controller;


import de.ait.shop41_02.customer.dto.CustomerRequestDto;
import de.ait.shop41_02.customer.dto.CustomerResponseDto;
import de.ait.shop41_02.customer.entity.Customer;
import de.ait.shop41_02.customer.service.CustomerService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api/customers")
public class CustomerController {
private final CustomerService customerService;

@PostMapping
public CustomerResponseDto saveCustomer(CustomerRequestDto customerRequestDto) {

    return  customerService.save(customerRequestDto);

}
    @GetMapping("/{id}")
    public CustomerResponseDto getById(@PathVariable Long id){
        return customerService.getById(id);
    }

    @PutMapping("/{customerId}/products/{productId}")
    public void addProductToCustomerCart(@PathVariable Long customerId,
                                         @PathVariable Long productId){
        customerService.addProductToCustomerCart(customerId,productId);
    }






}
