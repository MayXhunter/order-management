package com.order.ordermanagement.Controller;


import com.order.ordermanagement.DTO.StockDTO;
import com.order.ordermanagement.Service.StockService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/stocks")
public class StockController {
    private final StockService stockService;

    @Autowired
    public StockController(StockService stockService) {
        this.stockService = stockService;
    }

    @GetMapping
    public ResponseEntity<List<StockDTO>> getAllStocks() {
        List<StockDTO> stocks = stockService.getAllStocks();
        return ResponseEntity.ok(stocks);
    }
    @PostMapping
    public ResponseEntity<StockDTO> createStock(@RequestBody StockDTO stockDTO) {
        StockDTO savedStockDTO = stockService.createStock(stockDTO);
        return ResponseEntity.status(HttpStatus.CREATED).body(savedStockDTO);
    }

    @GetMapping("/{id}")
    public ResponseEntity<StockDTO> getStockById(@PathVariable("id") Long stockId) {
        StockDTO stockDTO = stockService.getStockById(stockId);
        return ResponseEntity.ok(stockDTO);
    }

    @PutMapping("/{id}")
    public ResponseEntity<Void> updateStock(@PathVariable("id") Long stockId, @RequestBody StockDTO stockDTO) {
        stockService.updateStock(stockId, stockDTO);
        return ResponseEntity.noContent().build();
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteStock(@PathVariable("id") Long stockId) {
        stockService.deleteStock(stockId);
        return ResponseEntity.noContent().build();
    }

    // Additional mapping methods for handling exceptions, etc.
}

