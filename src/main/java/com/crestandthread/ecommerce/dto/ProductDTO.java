// AI Generated Code by Deloitte + Cursor (BEGIN)
package com.crestandthread.ecommerce.dto;

import com.fasterxml.jackson.annotation.JsonInclude;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.math.BigDecimal;
import java.util.List;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
@JsonInclude(JsonInclude.Include.NON_NULL)
public class ProductDTO {
    private Long id;
    private String title;
    private String category;
    private String type;
    private String description;
    private BigDecimal price;
    private String image;
    private String badge;
    private Double rating;
    private Integer ratingCount;
    private List<String> colors;
    private List<String> sizes;
    private Integer stockQuantity;
    private Boolean isFeatured;
}
// AI Generated Code by Deloitte + Cursor (END)
