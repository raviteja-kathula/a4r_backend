// AI Generated Code by Deloitte + Cursor (BEGIN)
package com.crestandthread.ecommerce.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;

@Entity
@Table(name = "newsletter_subscriptions", 
       uniqueConstraints = @UniqueConstraint(columnNames = "email"))
@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class NewsletterSubscription {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false, unique = true)
    private String email;

    @Column(name = "subscribed_at")
    private LocalDateTime subscribedAt;

    @Column(name = "is_active")
    private Boolean isActive;

    @PrePersist
    protected void onCreate() {
        subscribedAt = LocalDateTime.now();
        if (isActive == null) {
            isActive = true;
        }
    }
}
// AI Generated Code by Deloitte + Cursor (END)
