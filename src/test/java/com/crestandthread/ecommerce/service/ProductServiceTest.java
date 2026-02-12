// AI Generated Code by Deloitte + Cursor (BEGIN)
package com.crestandthread.ecommerce.service;

import com.crestandthread.ecommerce.dto.ProductDTO;
import com.crestandthread.ecommerce.dto.ProductListResponse;
import com.crestandthread.ecommerce.entity.Product;
import com.crestandthread.ecommerce.repository.ProductRepository;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageImpl;
import org.springframework.data.domain.Pageable;

import java.math.BigDecimal;
import java.util.Arrays;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.*;

@ExtendWith(MockitoExtension.class)
class ProductServiceTest {

    @Mock
    private ProductRepository productRepository;

    @InjectMocks
    private ProductService productService;

    private Product testProduct;

    @BeforeEach
    void setUp() {
        testProduct = Product.builder()
                .id(1L)
                .title("Classic Tailored Blazer")
                .category("WOMEN")
                .type("outerwear")
                .price(new BigDecimal("285.00"))
                .image("/images/blazer.jpg")
                .badge("NEW")
                .rating(4.8)
                .ratingCount(120)
                .colors(Arrays.asList("black", "navy"))
                .sizes(Arrays.asList("S", "M", "L"))
                .stockQuantity(50)
                .isFeatured(true)
                .build();
    }

    @Test
    void testGetFeaturedProducts() {
        // Arrange
        List<Product> featuredProducts = Arrays.asList(testProduct);
        when(productRepository.findByIsFeaturedTrue()).thenReturn(featuredProducts);

        // Act
        List<ProductDTO> result = productService.getFeaturedProducts();

        // Assert
        assertNotNull(result);
        assertEquals(1, result.size());
        assertEquals("Classic Tailored Blazer", result.get(0).getTitle());
        verify(productRepository, times(1)).findByIsFeaturedTrue();
    }

    @Test
    void testGetProducts() {
        // Arrange
        List<Product> products = Arrays.asList(testProduct);
        Page<Product> productPage = new PageImpl<>(products);
        when(productRepository.findByFilters(any(), any(), any(), any(), any(), any(), any(Pageable.class)))
                .thenReturn(productPage);

        // Act
        ProductListResponse result = productService.getProducts(
                "WOMEN", "outerwear", null, null, null, null, "featured", 1, 12
        );

        // Assert
        assertNotNull(result);
        assertEquals(1, result.getTotal());
        assertEquals(1, result.getPage());
        assertEquals(1, result.getData().size());
        verify(productRepository, times(1)).findByFilters(any(), any(), any(), any(), any(), any(), any(Pageable.class));
    }

    @Test
    void testGetProductsWithPriceFilters() {
        // Arrange
        List<Product> products = Arrays.asList(testProduct);
        Page<Product> productPage = new PageImpl<>(products);
        when(productRepository.findByFilters(any(), any(), any(), any(), any(), any(), any(Pageable.class)))
                .thenReturn(productPage);

        // Act
        ProductListResponse result = productService.getProducts(
                null, null, null, null, new BigDecimal("200"), new BigDecimal("300"), "price_asc", 1, 12
        );

        // Assert
        assertNotNull(result);
        assertEquals(1, result.getTotal());
        verify(productRepository, times(1)).findByFilters(any(), any(), any(), any(), any(), any(), any(Pageable.class));
    }

    @Test
    void testGetProductsWithSorting() {
        // Arrange
        List<Product> products = Arrays.asList(testProduct);
        Page<Product> productPage = new PageImpl<>(products);
        when(productRepository.findByFilters(any(), any(), any(), any(), any(), any(), any(Pageable.class)))
                .thenReturn(productPage);

        // Act
        ProductListResponse result = productService.getProducts(
                null, null, null, null, null, null, "price_desc", 1, 12
        );

        // Assert
        assertNotNull(result);
        assertEquals(1, result.getTotal());
        verify(productRepository, times(1)).findByFilters(any(), any(), any(), any(), any(), any(), any(Pageable.class));
    }
}
// AI Generated Code by Deloitte + Cursor (END)
