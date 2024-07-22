package de.ait.shop41_02.customer.service;

import de.ait.shop41_02.customer.dto.CustomerRequestDto;
import de.ait.shop41_02.customer.dto.CustomerResponseDto;

import java.util.List;

public interface CustomerService {

    CustomerResponseDto updateCustomer(Long id ,CustomerRequestDto customerRequestDto);

    CustomerResponseDto save(CustomerRequestDto dto);

    CustomerResponseDto getById(Long id);

    void addProductToCustomerCart(Long customerId, Long productId);

    List<CustomerResponseDto> getAllCustomers();

    void deleteCustomer(Long id);

}


