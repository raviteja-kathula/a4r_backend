// AI Generated Code by Deloitte + Cursor (BEGIN)
package com.crestandthread.ecommerce.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class ProductListResponse {
    private List<ProductDTO> data;
    private int total;
    private int page;
    private int totalPages;
}
// AI Generated Code by Deloitte + Cursor (END)
