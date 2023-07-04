package com.order.ordermanagement.Entity;

import jakarta.persistence.*;
import java.math.BigDecimal;

@Entity
@Table(name = "product")
public class Product {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "name", nullable = false)
    private String name;

    @Column(name = "reference")
    private String reference;

    @Column(name = "price", nullable = false)
    private BigDecimal price;

    @Column(name = "stokable", nullable = false)
    private boolean stokable;

    // Constructors

    public Product() {
    }

    public Product(String name, String reference, BigDecimal price, boolean stokable) {
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


}