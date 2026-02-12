// AI Generated Code by Deloitte + Cursor (BEGIN)
package com.crestandthread.ecommerce.repository;

import com.crestandthread.ecommerce.entity.Product;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.math.BigDecimal;
import java.util.List;

@Repository
public interface ProductRepository extends JpaRepository<Product, Long> {

    List<Product> findByIsFeaturedTrue();

    @Query("SELECT p FROM Product p WHERE " +
           "(:category IS NULL OR p.category = :category) AND " +
           "(:type IS NULL OR p.type = :type) AND " +
           "(:color IS NULL OR :color MEMBER OF p.colors) AND " +
           "(:size IS NULL OR :size MEMBER OF p.sizes) AND " +
           "(:priceMin IS NULL OR p.price >= :priceMin) AND " +
           "(:priceMax IS NULL OR p.price <= :priceMax)")
    Page<Product> findByFilters(@Param("category") String category,
                                @Param("type") String type,
                                @Param("color") String color,
                                @Param("size") String size,
                                @Param("priceMin") BigDecimal priceMin,
                                @Param("priceMax") BigDecimal priceMax,
                                Pageable pageable);
}
// AI Generated Code by Deloitte + Cursor (END)
