package de.ait.shop41.product.controller;

import de.ait.shop41.product.entity.Customer;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.List;


@RestController
public class CustomerController {
    private static List<Customer> customers = new ArrayList<>(List.of(
            new Customer(1L, "Vlad", true),
            new Customer(2L, "Igor", true),
            new Customer(3L, "Andrey", true)
    ));


    @GetMapping("/customer")
    public List<Customer> getAllCustomers() {
        return customers;
    }

    @GetMapping("/customer/{id}")
    public Customer GetCustomerById(@PathVariable Long id) {
        return customers.stream()
                .filter(customer -> customer.getId().equals(Long.valueOf(id)))
                .findAny()
                .get();
    }


}
