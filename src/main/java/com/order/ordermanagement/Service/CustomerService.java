package com.order.ordermanagement.Service;

import com.order.ordermanagement.DTO.CustomerDTO;
import com.order.ordermanagement.Entity.Customer;
import com.order.ordermanagement.Exceptopn.NotFoundException;
import com.order.ordermanagement.Repository.CustomerRepository;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class CustomerService {
    private final CustomerRepository customerRepository;

    @Autowired
    public CustomerService(CustomerRepository customerRepository) {
        this.customerRepository = customerRepository;
    }

    public CustomerDTO createCustomer(CustomerDTO customerDTO) {
        Customer customer = new Customer();
        BeanUtils.copyProperties(customerDTO, customer);

        Customer savedCustomer = customerRepository.save(customer);

        CustomerDTO savedCustomerDTO = new CustomerDTO();
        BeanUtils.copyProperties(savedCustomer, savedCustomerDTO);

        return savedCustomerDTO;
    }

    public CustomerDTO getCustomerById(Long customerId) {
        Customer customer = customerRepository.findById(customerId)
                .orElseThrow(() -> new NotFoundException("Customer not found"));

        CustomerDTO customerDTO = new CustomerDTO();
        BeanUtils.copyProperties(customer, customerDTO);

        return customerDTO;
    }

    public void deleteCustomer(Long customerId) {
        customerRepository.deleteById(customerId);
    }


}
