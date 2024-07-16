package de.ait.shop41_02.customer.service;


import de.ait.shop41_02.cart.entity.Cart;
import de.ait.shop41_02.customer.dto.CustomerRequestDto;
import de.ait.shop41_02.customer.dto.CustomerResponseDto;
import de.ait.shop41_02.customer.entity.Customer;
import de.ait.shop41_02.customer.repository.CustomerRepository;
import de.ait.shop41_02.product.entity.Product;
import de.ait.shop41_02.product.service.ProductService;
import lombok.RequiredArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@RequiredArgsConstructor
public class CustomerServiceImpl implements CustomerService {

    private final CustomerRepository customerRepository;
    private final ModelMapper modelMapper;
    private final ProductService productService;


    @Override
    public CustomerResponseDto save(CustomerRequestDto customerRequestDto) {

        Customer entity = modelMapper.map(customerRequestDto, Customer.class);
        Cart cart = new Cart();
        cart.setCustomer(entity);
        entity.setCart(cart);

        Customer saved = customerRepository.save(entity);
        return modelMapper.map(saved, CustomerResponseDto.class);

    }
    @Override
    public CustomerResponseDto getById(Long id) {
        Customer entity = customerRepository.findById(id).orElseThrow(()->new RuntimeException("customer not found "+ id));
        return modelMapper.map(entity, CustomerResponseDto.class);
    }

    @Override
    @Transactional
    public void addProductToCustomerCart(Long customerId, Long productId) {
        Customer customer = customerRepository
                .findById(customerId)
                .orElseThrow(() -> new RuntimeException("Customer not found"));

        Product product = productService
                .getById(productId);

        customer.getCart().addProduct(product);

    }


}
