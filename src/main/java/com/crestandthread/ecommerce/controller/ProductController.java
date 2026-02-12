// AI Generated Code by Deloitte + Cursor (BEGIN)
package com.crestandthread.ecommerce.controller;

import com.crestandthread.ecommerce.dto.ProductDTO;
import com.crestandthread.ecommerce.dto.ProductListResponse;
import com.crestandthread.ecommerce.service.ProductService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.math.BigDecimal;
import java.util.List;

@RestController
@RequestMapping("/products")
@RequiredArgsConstructor
@Slf4j
@CrossOrigin(origins = "http://localhost:3000")
public class ProductController {

    private final ProductService productService;

    @GetMapping("/featured")
    public ResponseEntity<List<ProductDTO>> getFeaturedProducts() {
        log.info("GET /products/featured - Fetching featured products");
        List<ProductDTO> products = productService.getFeaturedProducts();
        return ResponseEntity.ok(products);
    }

    @GetMapping
    public ResponseEntity<ProductListResponse> getProducts(
            @RequestParam(required = false) String category,
            @RequestParam(required = false) String type,
            @RequestParam(required = false) String color,
            @RequestParam(required = false) String size,
            @RequestParam(required = false) BigDecimal priceMin,
            @RequestParam(required = false) BigDecimal priceMax,
            @RequestParam(required = false, defaultValue = "featured") String sort,
            @RequestParam(defaultValue = "1") int page,
            @RequestParam(defaultValue = "12") int limit
    ) {
        log.info("GET /products - Fetching products with filters");
        ProductListResponse response = productService.getProducts(
                category, type, color, size, priceMin, priceMax, sort, page, limit
        );
        return ResponseEntity.ok(response);
    }
}
// AI Generated Code by Deloitte + Cursor (END)
