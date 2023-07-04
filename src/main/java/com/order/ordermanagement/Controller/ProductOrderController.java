package com.order.ordermanagement.Controller;


import com.order.ordermanagement.DTO.ProductOrderDTO;
import com.order.ordermanagement.Service.ProductOrderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/product-orders")
public class ProductOrderController {
    private final ProductOrderService productOrderService;

    @Autowired
    public ProductOrderController(ProductOrderService productOrderService) {
        this.productOrderService = productOrderService;
    }

    @PostMapping
    public ResponseEntity<ProductOrderDTO> createProductOrder(@RequestBody ProductOrderDTO productOrderDTO) {
        ProductOrderDTO savedProductOrderDTO = productOrderService.createProductOrder(productOrderDTO);
        return ResponseEntity.status(HttpStatus.CREATED).body(savedProductOrderDTO);
    }

    @GetMapping("/{id}")
    public ResponseEntity<ProductOrderDTO> getProductOrderById(@PathVariable("id") Long productOrderId) {
        ProductOrderDTO productOrderDTO = productOrderService.getProductOrderById(productOrderId);
        return ResponseEntity.ok(productOrderDTO);
    }

    @PutMapping("/{id}")
    public ResponseEntity<Void> updateProductOrder(@PathVariable("id") Long productOrderId, @RequestBody ProductOrderDTO productOrderDTO) {
        productOrderService.updateProductOrder(productOrderId, productOrderDTO);
        return ResponseEntity.noContent().build();
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteProductOrder(@PathVariable("id") Long productOrderId) {
        productOrderService.deleteProductOrder(productOrderId);
        return ResponseEntity.noContent().build();
    }

    // Additional mapping methods for handling exceptions, etc.
}

