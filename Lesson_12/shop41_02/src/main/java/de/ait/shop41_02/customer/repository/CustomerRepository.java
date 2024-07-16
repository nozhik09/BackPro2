package de.ait.shop41_02.customer.repository;

import de.ait.shop41_02.customer.entity.Customer;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CustomerRepository extends JpaRepository<Customer, Long> {
}
