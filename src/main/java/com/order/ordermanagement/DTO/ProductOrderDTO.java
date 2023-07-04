package com.order.ordermanagement.DTO;

public class ProductOrderDTO {
    private Long id;
    private Long productId;
    private Long orderId;
    private Integer quantity;
    private Double price;
    private Double vat;

    public ProductOrderDTO(Long id, Long productId, Long orderId, Integer quantity, Double price, Double vat) {
        this.id = id;
        this.productId = productId;
        this.orderId = orderId;
        this.quantity = quantity;
        this.price = price;
        this.vat = vat;
    }

    public ProductOrderDTO() {

    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Long getProductId() {
        return productId;
    }

    public void setProductId(Long productId) {
        this.productId = productId;
    }

    public Long getOrderId() {
        return orderId;
    }

    public void setOrderId(Long orderId) {
        this.orderId = orderId;
    }

    public Integer getQuantity() {
        return quantity;
    }

    public void setQuantity(Integer quantity) {
        this.quantity = quantity;
    }

    public Double getPrice() {
        return price;
    }

    public void setPrice(Double price) {
        this.price = price;
    }

    public Double getVat() {
        return vat;
    }

    public void setVat(Double vat) {
        this.vat = vat;
    }
    // Constructors, getters, and setters

    // Additional methods if needed
}