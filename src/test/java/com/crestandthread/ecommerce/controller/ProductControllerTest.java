// AI Generated Code by Deloitte + Cursor (BEGIN)
package com.crestandthread.ecommerce.controller;

import com.crestandthread.ecommerce.dto.ProductDTO;
import com.crestandthread.ecommerce.dto.ProductListResponse;
import com.crestandthread.ecommerce.service.ProductService;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;

import java.math.BigDecimal;
import java.util.Arrays;
import java.util.List;

import static org.mockito.ArgumentMatchers.*;
import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;

@WebMvcTest(ProductController.class)
class ProductControllerTest {

    @Autowired
    private MockMvc mockMvc;

    @MockBean
    private ProductService productService;

    @Test
    void testGetFeaturedProducts() throws Exception {
        // Arrange
        ProductDTO product = ProductDTO.builder()
                .id(1L)
                .title("Classic Blazer")
                .category("WOMEN")
                .price(new BigDecimal("285.00"))
                .build();
        List<ProductDTO> products = Arrays.asList(product);
        when(productService.getFeaturedProducts()).thenReturn(products);

        // Act & Assert
        mockMvc.perform(get("/products/featured")
                        .contentType(MediaType.APPLICATION_JSON))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$").isArray())
                .andExpect(jsonPath("$[0].title").value("Classic Blazer"));
    }

    @Test
    void testGetProducts() throws Exception {
        // Arrange
        ProductDTO product = ProductDTO.builder()
                .id(1L)
                .title("Classic Blazer")
                .category("WOMEN")
                .price(new BigDecimal("285.00"))
                .build();
        
        ProductListResponse response = ProductListResponse.builder()
                .data(Arrays.asList(product))
                .total(1)
                .page(1)
                .totalPages(1)
                .build();
        
        when(productService.getProducts(any(), any(), any(), any(), any(), any(), any(), anyInt(), anyInt()))
                .thenReturn(response);

        // Act & Assert
        mockMvc.perform(get("/products")
                        .param("category", "WOMEN")
                        .param("page", "1")
                        .param("limit", "12")
                        .contentType(MediaType.APPLICATION_JSON))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.data").isArray())
                .andExpect(jsonPath("$.total").value(1))
                .andExpect(jsonPath("$.page").value(1));
    }

    @Test
    void testGetProductsWithFilters() throws Exception {
        // Arrange
        ProductListResponse response = ProductListResponse.builder()
                .data(Arrays.asList())
                .total(0)
                .page(1)
                .totalPages(0)
                .build();
        
        when(productService.getProducts(any(), any(), any(), any(), any(), any(), any(), anyInt(), anyInt()))
                .thenReturn(response);

        // Act & Assert
        mockMvc.perform(get("/products")
                        .param("category", "WOMEN")
                        .param("type", "outerwear")
                        .param("priceMin", "200")
                        .param("priceMax", "500")
                        .contentType(MediaType.APPLICATION_JSON))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.data").isArray())
                .andExpect(jsonPath("$.total").value(0));
    }
}
// AI Generated Code by Deloitte + Cursor (END)
