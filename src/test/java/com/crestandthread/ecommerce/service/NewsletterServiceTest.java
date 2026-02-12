// AI Generated Code by Deloitte + Cursor (BEGIN)
package com.crestandthread.ecommerce.service;

import com.crestandthread.ecommerce.dto.NewsletterSubscriptionRequest;
import com.crestandthread.ecommerce.entity.NewsletterSubscription;
import com.crestandthread.ecommerce.exception.DuplicateSubscriptionException;
import com.crestandthread.ecommerce.repository.NewsletterSubscriptionRepository;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.*;

@ExtendWith(MockitoExtension.class)
class NewsletterServiceTest {

    @Mock
    private NewsletterSubscriptionRepository newsletterRepository;

    @InjectMocks
    private NewsletterService newsletterService;

    private NewsletterSubscriptionRequest validRequest;

    @BeforeEach
    void setUp() {
        validRequest = NewsletterSubscriptionRequest.builder()
                .email("test@example.com")
                .build();
    }

    @Test
    void testSubscribeSuccess() {
        // Arrange
        when(newsletterRepository.existsByEmail(any())).thenReturn(false);
        when(newsletterRepository.save(any(NewsletterSubscription.class)))
                .thenReturn(new NewsletterSubscription());

        // Act
        assertDoesNotThrow(() -> newsletterService.subscribe(validRequest));

        // Assert
        verify(newsletterRepository, times(1)).existsByEmail("test@example.com");
        verify(newsletterRepository, times(1)).save(any(NewsletterSubscription.class));
    }

    @Test
    void testSubscribeDuplicateEmail() {
        // Arrange
        when(newsletterRepository.existsByEmail(any())).thenReturn(true);

        // Act & Assert
        assertThrows(DuplicateSubscriptionException.class, () -> 
            newsletterService.subscribe(validRequest)
        );
        
        verify(newsletterRepository, times(1)).existsByEmail("test@example.com");
        verify(newsletterRepository, never()).save(any());
    }

    @Test
    void testSubscribeEmailNormalization() {
        // Arrange
        NewsletterSubscriptionRequest request = NewsletterSubscriptionRequest.builder()
                .email("  TEST@EXAMPLE.COM  ")
                .build();
        when(newsletterRepository.existsByEmail(any())).thenReturn(false);
        when(newsletterRepository.save(any(NewsletterSubscription.class)))
                .thenReturn(new NewsletterSubscription());

        // Act
        assertDoesNotThrow(() -> newsletterService.subscribe(request));

        // Assert
        verify(newsletterRepository, times(1)).existsByEmail("test@example.com");
        verify(newsletterRepository, times(1)).save(any(NewsletterSubscription.class));
    }
}
// AI Generated Code by Deloitte + Cursor (END)
