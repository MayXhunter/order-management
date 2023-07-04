package com.order.ordermanagement.DTO;

import java.time.LocalDateTime;
import java.util.List;

public class OrderDTO {
    private Long id;
    private Long customerId;
    private LocalDateTime orderedAt;
    private List<ProductOrderDTO> productOrders;

    public OrderDTO(Long id, Long customerId, LocalDateTime orderedAt, List<ProductOrderDTO> productOrders) {
        this.id = id;
        this.customerId = customerId;
        this.orderedAt = orderedAt;
        this.productOrders = productOrders;
    }

    public OrderDTO() {

    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Long getCustomerId() {
        return customerId;
    }

    public void setCustomerId(Long customerId) {
        this.customerId = customerId;
    }

    public LocalDateTime getOrderedAt() {
        return orderedAt;
    }

    public void setOrderedAt(LocalDateTime orderedAt) {
        this.orderedAt = orderedAt;
    }

    public List<ProductOrderDTO> getProductOrders() {
        return productOrders;
    }

    public void setProductOrders(List<ProductOrderDTO> productOrders) {
        this.productOrders = productOrders;
    }
// Constructors, getters, and setters

    // Additional methods if needed
}
