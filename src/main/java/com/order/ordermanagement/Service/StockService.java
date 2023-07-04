package com.order.ordermanagement.Service;

import com.order.ordermanagement.DTO.StockDTO;
import com.order.ordermanagement.Entity.Stock;
import com.order.ordermanagement.Exceptopn.NotFoundException;
import com.order.ordermanagement.Repository.StockRepository;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class StockService {
    private final StockRepository stockRepository;
    private final ProductService productService;

    @Autowired
    public StockService(StockRepository stockRepository, ProductService productService) {
        this.stockRepository = stockRepository;
        this.productService = productService;
    }

    public StockDTO createStock(StockDTO stockDTO) {
        Stock stock = new Stock();
        stock.setProduct(productService.getProductById(stockDTO.getProductId()));
        stock.setQuantity(stockDTO.getQuantity());

        Stock savedStock = stockRepository.save(stock);

        StockDTO savedStockDTO = new StockDTO();
        BeanUtils.copyProperties(savedStock, savedStockDTO);

        return savedStockDTO;
    }
    public List<StockDTO> getAllStocks() {
        List<Stock> stocks = stockRepository.findAll();
        List<StockDTO> stockDTOs = new ArrayList<>();

        for (Stock stock : stocks) {
            StockDTO stockDTO = new StockDTO();
            BeanUtils.copyProperties(stock, stockDTO);
            stockDTOs.add(stockDTO);
        }

        return stockDTOs;
    }

    public StockDTO getStockById(Long stockId) {
        Stock stock = stockRepository.findById(stockId)
                .orElseThrow(() -> new NotFoundException("Stock not found"));

        StockDTO stockDTO = new StockDTO();
        BeanUtils.copyProperties(stock, stockDTO);

        return stockDTO;
    }

    public void updateStock(Long stockId, StockDTO stockDTO) {
        Stock stock = stockRepository.findById(stockId)
                .orElseThrow(() -> new NotFoundException("Stock not found"));

        stock.setQuantity(stockDTO.getQuantity());
        stock.setProduct(productService.getProductById(stockDTO.getProductId()));

        stockRepository.save(stock);
    }

    public void deleteStock(Long stockId) {
        stockRepository.deleteById(stockId);
    }

    // Additional methods for performing business logic, etc.
}
