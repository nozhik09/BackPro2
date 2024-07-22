package de.ait.shop41_02.customer.controller;


import de.ait.shop41_02.customer.dto.CustomerRequestDto;
import de.ait.shop41_02.customer.dto.CustomerResponseDto;
import de.ait.shop41_02.customer.entity.Customer;
import de.ait.shop41_02.customer.service.CustomerService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api/customers")
public class CustomerController {
    private final CustomerService customerService;

    @PostMapping
    public CustomerResponseDto saveCustomer(@RequestBody CustomerRequestDto customerRequestDto) {

        return customerService.save(customerRequestDto);

    }

    @GetMapping("/{id}")
    public CustomerResponseDto getById(@PathVariable Long id) {
        return customerService.getById(id);
    }

    @PutMapping("/{customerId}/products/{productId}")
    public void addProductToCustomerCart(@PathVariable Long customerId,
                                         @PathVariable Long productId) {
        customerService.addProductToCustomerCart(customerId, productId);
    }

    @GetMapping
    public List<CustomerResponseDto> getCustomers() {
        return customerService.getAllCustomers();
    }


    @PutMapping
    public ResponseEntity<CustomerResponseDto> updateCustomer(@PathVariable Long id, @RequestBody CustomerRequestDto customerRequestDto) {
        try {
            CustomerResponseDto updatedCustomer = customerService.updateCustomer(id, customerRequestDto);
            return new ResponseEntity<>(updatedCustomer, HttpStatus.OK);
        } catch (RuntimeException e) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }


    }

    @DeleteMapping("{id}")
    public ResponseEntity<Void> deleteCustomer(@PathVariable Long id) {
        try {
            customerService.deleteCustomer(id);
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        } catch (RuntimeException e) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }

    }

}
