package com.order.ordermanagement.Service;

import com.order.ordermanagement.DTO.ProductOrderDTO;
import com.order.ordermanagement.Entity.ProductOrder;
import com.order.ordermanagement.Exceptopn.NotFoundException;
import com.order.ordermanagement.Repository.ProductOrderRepository;
import com.order.ordermanagement.Service.ProductService;
import com.order.ordermanagement.Service.OrderService;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ProductOrderService {
    private final ProductOrderRepository productOrderRepository;
    private final ProductService productService;
    private final OrderService orderService;

    @Autowired
    public ProductOrderService(ProductOrderRepository productOrderRepository, ProductService productService, OrderService orderService) {
        this.productOrderRepository = productOrderRepository;
        this.productService = productService;
        this.orderService = orderService;
    }

    public ProductOrderDTO createProductOrder(ProductOrderDTO productOrderDTO) {
        ProductOrder productOrder = new ProductOrder();
        productOrder.setProduct(productService.getProductById(productOrderDTO.getProductId()));
        productOrder.setOrder(orderService.getOrderById(productOrderDTO.getOrderId()));
        productOrder.setQuantity(productOrderDTO.getQuantity());
        productOrder.setPrice(productOrderDTO.getPrice());
        productOrder.setVat(productOrderDTO.getVat());

        ProductOrder savedProductOrder = productOrderRepository.save(productOrder);

        ProductOrderDTO savedProductOrderDTO = new ProductOrderDTO();
        BeanUtils.copyProperties(savedProductOrder, savedProductOrderDTO);

        return savedProductOrderDTO;
    }

    public ProductOrderDTO getProductOrderById(Long productOrderId) {
        ProductOrder productOrder = productOrderRepository.findById(productOrderId)
                .orElseThrow(() -> new NotFoundException("Product Order not found"));

        ProductOrderDTO productOrderDTO = new ProductOrderDTO();
        BeanUtils.copyProperties(productOrder, productOrderDTO);

        return productOrderDTO;
    }

    public void updateProductOrder(Long productOrderId, ProductOrderDTO productOrderDTO) {
        ProductOrder productOrder = productOrderRepository.findById(productOrderId)
                .orElseThrow(() -> new NotFoundException("Product Order not found"));

        productOrder.setProduct(productService.getProductById(productOrderDTO.getProductId()));
        productOrder.setOrder(orderService.getOrderById(productOrderDTO.getOrderId()));
        productOrder.setQuantity(productOrderDTO.getQuantity());
        productOrder.setPrice(productOrderDTO.getPrice());
        productOrder.setVat(productOrderDTO.getVat());

        productOrderRepository.save(productOrder);
    }

    public void deleteProductOrder(Long productOrderId) {
        productOrderRepository.deleteById(productOrderId);
    }


}
