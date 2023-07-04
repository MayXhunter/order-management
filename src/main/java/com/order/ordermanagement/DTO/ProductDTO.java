package com.order.ordermanagement.DTO;

import java.math.BigDecimal;

public class ProductDTO {
    private Long id;
    private String name;
    private String reference;
    private BigDecimal price;
    private boolean stokable;

    // Constructors

    public ProductDTO() {
    }

    public ProductDTO(Long id, String name, String reference, BigDecimal price, boolean stokable) {
        this.id = id;
        this.name = name;
        this.reference = reference;
        this.price = price;
        this.stokable = stokable;
    }

    // Getters and Setters

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getReference() {
        return reference;
    }

    public void setReference(String reference) {
        this.reference = reference;
    }

    public BigDecimal getPrice() {
        return price;
    }

    public void setPrice(BigDecimal price) {
        this.price = price;
    }

    public boolean isStokable() {
        return stokable;
    }

    public void setStokable(boolean stokable) {
        this.stokable = stokable;
    }

    // Additional methods if needed
}
