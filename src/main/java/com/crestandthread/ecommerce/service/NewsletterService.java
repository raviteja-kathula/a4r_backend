// AI Generated Code by Deloitte + Cursor (BEGIN)
package com.crestandthread.ecommerce.service;

import com.crestandthread.ecommerce.dto.NewsletterSubscriptionRequest;
import com.crestandthread.ecommerce.entity.NewsletterSubscription;
import com.crestandthread.ecommerce.exception.DuplicateSubscriptionException;
import com.crestandthread.ecommerce.repository.NewsletterSubscriptionRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@RequiredArgsConstructor
@Slf4j
public class NewsletterService {

    private final NewsletterSubscriptionRepository newsletterRepository;

    @Transactional
    public void subscribe(NewsletterSubscriptionRequest request) {
        String email = request.getEmail().toLowerCase().trim();
        
        log.debug("Processing newsletter subscription for email: {}", email);

        if (newsletterRepository.existsByEmail(email)) {
            log.warn("Email already subscribed: {}", email);
            throw new DuplicateSubscriptionException("Email is already subscribed to the newsletter");
        }

        NewsletterSubscription subscription = NewsletterSubscription.builder()
                .email(email)
                .isActive(true)
                .build();

        newsletterRepository.save(subscription);
        log.info("Successfully subscribed email: {}", email);
    }
}
// AI Generated Code by Deloitte + Cursor (END)
