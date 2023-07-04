package com.order.ordermanagement.Entity;

import com.order.ordermanagement.DTO.OrderDTO;
import com.order.ordermanagement.DTO.ProductDTO;
import jakarta.persistence.*;

@Entity
@Table(name = "product_order")
public class ProductOrder {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "product_id")
    private Product product;

    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "order_id")
    private Order order;

    private Integer quantity;
    private Double price;
    private Double vat;



    public ProductOrder() {
    }

    public ProductOrder(Long id, Product product, Order order, Integer quantity, Double price, Double vat) {
        this.id = id;
        this.product = product;
        this.order = order;
        this.quantity = quantity;
        this.price = price;
        this.vat = vat;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Product getProduct() {
        return product;
    }

    public void setProduct(ProductDTO productDTO) {
        // Convert ProductDTO to Product entity and set it
        this.product = convertToProductEntity(productDTO);
    }

    public Order getOrder() {
        return order;
    }

    public void setOrder(OrderDTO orderDTO) {
        // Convert OrderDTO to Order entity and set it
        this.order = convertToOrderEntity(orderDTO);
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

    private Product convertToProductEntity(ProductDTO productDTO) {
        // Convert ProductDTO to Product entity manually

        Product product = new Product();
        product.setId(productDTO.getId());
        product.setName(productDTO.getName());
        product.setPrice(productDTO.getPrice());

        return product;
    }

    private Order convertToOrderEntity(OrderDTO orderDTO) {
        // Convert OrderDTO to Order entity manually

        Order order = new Order();
        order.setId(orderDTO.getId());

        return order;
    }


}
