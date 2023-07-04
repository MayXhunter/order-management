package com.order.ordermanagement.Service;


import com.order.ordermanagement.DTO.ProductDTO;
import com.order.ordermanagement.Entity.Product;
import com.order.ordermanagement.Exceptopn.NotFoundException;
import com.order.ordermanagement.Repository.ProductRepository;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class ProductService {
    private final ProductRepository productRepository;

    @Autowired
    public ProductService(ProductRepository productRepository) {
        this.productRepository = productRepository;
    }

    public ProductDTO createProduct(ProductDTO productDTO) {
        Product product = new Product();
        BeanUtils.copyProperties(productDTO, product);

        Product savedProduct = productRepository.save(product);

        ProductDTO savedProductDTO = new ProductDTO();
        BeanUtils.copyProperties(savedProduct, savedProductDTO);

        return savedProductDTO;
    }

    public ProductDTO getProductById(Long productId) {
        Product product = productRepository.findById(productId)
                .orElseThrow(() -> new NotFoundException("Product not found"));

        ProductDTO productDTO = new ProductDTO();
        BeanUtils.copyProperties(product, productDTO);

        return productDTO;
    }
    public List<ProductDTO> getAllProducts() {
        List<Product> productList = productRepository.findAll();
        List<ProductDTO> productDTOList = new ArrayList<>();

        for (Product product : productList) {
            ProductDTO productDTO = new ProductDTO();
            BeanUtils.copyProperties(product, productDTO);
            productDTOList.add(productDTO);
        }

        return productDTOList;
    }
    public ProductDTO updateProductById(Long productId, ProductDTO productDTO) {
        Product product = productRepository.findById(productId)
                .orElseThrow(() -> new NotFoundException("Product not found"));

        // Update the properties of the product entity with the values from the productDTO
        product.setName(productDTO.getName());
        product.setPrice(productDTO.getPrice());


        Product updatedProduct = productRepository.save(product);

        ProductDTO updatedProductDTO = new ProductDTO();
        BeanUtils.copyProperties(updatedProduct, updatedProductDTO);

        return updatedProductDTO;
    }

    public void deleteProduct(Long productId) {
        productRepository.deleteById(productId);
    }



}
