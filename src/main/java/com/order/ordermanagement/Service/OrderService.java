package com.order.ordermanagement.Service;

import com.order.ordermanagement.DTO.CustomerDTO;
import com.order.ordermanagement.DTO.OrderDTO;
import com.order.ordermanagement.Entity.Customer;
import com.order.ordermanagement.Entity.Order;
import com.order.ordermanagement.Exceptopn.NotFoundException;
import com.order.ordermanagement.Repository.OrderRepository;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class OrderService {
    private final OrderRepository orderRepository;
    private final CustomerService customerService;

    @Autowired
    public OrderService(OrderRepository orderRepository, CustomerService customerService) {
        this.orderRepository = orderRepository;
        this.customerService = customerService;
    }

    public OrderDTO createOrder(OrderDTO orderDTO) {
        Order order = new Order();

        // Convert CustomerDTO to Customer
        CustomerDTO customerDTO = customerService.getCustomerById(orderDTO.getCustomerId());
        Customer customer = new Customer();
        BeanUtils.copyProperties(customerDTO, customer);

        order.setCustomer(customer);
        order.setOrderedAt(orderDTO.getOrderedAt());

        Order savedOrder = orderRepository.save(order);

        OrderDTO savedOrderDTO = new OrderDTO();
        BeanUtils.copyProperties(savedOrder, savedOrderDTO);

        return savedOrderDTO;
    }


    public OrderDTO getOrderById(Long orderId) {
        Order order = orderRepository.findById(orderId)
                .orElseThrow(() -> new NotFoundException("Order not found"));

        OrderDTO orderDTO = new OrderDTO();
        BeanUtils.copyProperties(order, orderDTO);

        return orderDTO;
    }

    public void deleteOrder(Long orderId) {
        orderRepository.deleteById(orderId);
    }


}
