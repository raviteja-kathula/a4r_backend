// AI Generated Code by Deloitte + Cursor (BEGIN)
package com.crestandthread.ecommerce.service;

import com.crestandthread.ecommerce.dto.ProductDTO;
import com.crestandthread.ecommerce.dto.ProductListResponse;
import com.crestandthread.ecommerce.entity.Product;
import com.crestandthread.ecommerce.repository.ProductRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.math.BigDecimal;
import java.util.List;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
@Slf4j
@Transactional(readOnly = true)
public class ProductService {

    private final ProductRepository productRepository;

    public List<ProductDTO> getFeaturedProducts() {
        log.debug("Fetching featured products");
        List<Product> products = productRepository.findByIsFeaturedTrue();
        return products.stream()
                .map(this::convertToDTO)
                .collect(Collectors.toList());
    }

    public ProductListResponse getProducts(String category, String type, String color, 
                                          String size, BigDecimal priceMin, BigDecimal priceMax,
                                          String sort, int page, int limit) {
        log.debug("Fetching products with filters - category: {}, type: {}, color: {}, size: {}, priceRange: {}-{}, sort: {}, page: {}, limit: {}",
                category, type, color, size, priceMin, priceMax, sort, page, limit);

        Sort sortOrder = getSortOrder(sort);
        Pageable pageable = PageRequest.of(page - 1, limit, sortOrder);

        Page<Product> productPage = productRepository.findByFilters(
                category, type, color, size, priceMin, priceMax, pageable
        );

        List<ProductDTO> productDTOs = productPage.getContent().stream()
                .map(this::convertToDTO)
                .collect(Collectors.toList());

        return ProductListResponse.builder()
                .data(productDTOs)
                .total((int) productPage.getTotalElements())
                .page(page)
                .totalPages(productPage.getTotalPages())
                .build();
    }

    private Sort getSortOrder(String sort) {
        if (sort == null || sort.equalsIgnoreCase("featured")) {
            return Sort.by(Sort.Direction.DESC, "isFeatured").and(Sort.by(Sort.Direction.DESC, "createdAt"));
        }
        return switch (sort.toLowerCase()) {
            case "price_asc" -> Sort.by(Sort.Direction.ASC, "price");
            case "price_desc" -> Sort.by(Sort.Direction.DESC, "price");
            case "newest" -> Sort.by(Sort.Direction.DESC, "createdAt");
            case "rating" -> Sort.by(Sort.Direction.DESC, "rating");
            default -> Sort.by(Sort.Direction.DESC, "createdAt");
        };
    }

    private ProductDTO convertToDTO(Product product) {
        return ProductDTO.builder()
                .id(product.getId())
                .title(product.getTitle())
                .category(product.getCategory())
                .type(product.getType())
                .description(product.getDescription())
                .price(product.getPrice())
                .image(product.getImage())
                .badge(product.getBadge())
                .rating(product.getRating())
                .ratingCount(product.getRatingCount())
                .colors(product.getColors())
                .sizes(product.getSizes())
                .stockQuantity(product.getStockQuantity())
                .isFeatured(product.getIsFeatured())
                .build();
    }
}
// AI Generated Code by Deloitte + Cursor (END)
