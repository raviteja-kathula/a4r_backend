// AI Generated Code by Deloitte + Cursor (BEGIN)
package com.crestandthread.ecommerce.repository;

import com.crestandthread.ecommerce.entity.NewsletterSubscription;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface NewsletterSubscriptionRepository extends JpaRepository<NewsletterSubscription, Long> {
    
    Optional<NewsletterSubscription> findByEmail(String email);
    
    boolean existsByEmail(String email);
}
// AI Generated Code by Deloitte + Cursor (END)
