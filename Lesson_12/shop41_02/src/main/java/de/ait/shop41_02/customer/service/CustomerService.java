package de.ait.shop41_02.customer.service;

import de.ait.shop41_02.customer.dto.CustomerRequestDto;
import de.ait.shop41_02.customer.dto.CustomerResponseDto;

public interface CustomerService {
    CustomerResponseDto save(CustomerRequestDto dto);

    CustomerResponseDto getById(Long id);

    void addProductToCustomerCart(Long customerId, Long productId);
}


