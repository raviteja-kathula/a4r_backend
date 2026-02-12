// AI Generated Code by Deloitte + Cursor (BEGIN)
package com.crestandthread.ecommerce.controller;

import com.crestandthread.ecommerce.dto.NewsletterSubscriptionRequest;
import com.crestandthread.ecommerce.exception.DuplicateSubscriptionException;
import com.crestandthread.ecommerce.service.NewsletterService;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;

import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.doNothing;
import static org.mockito.Mockito.doThrow;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;

@WebMvcTest(NewsletterController.class)
class NewsletterControllerTest {

    @Autowired
    private MockMvc mockMvc;

    @Autowired
    private ObjectMapper objectMapper;

    @MockBean
    private NewsletterService newsletterService;

    @Test
    void testSubscribeSuccess() throws Exception {
        // Arrange
        NewsletterSubscriptionRequest request = NewsletterSubscriptionRequest.builder()
                .email("test@example.com")
                .build();
        doNothing().when(newsletterService).subscribe(any());

        // Act & Assert
        mockMvc.perform(post("/newsletter/subscribe")
                        .contentType(MediaType.APPLICATION_JSON)
                        .content(objectMapper.writeValueAsString(request)))
                .andExpect(status().isCreated())
                .andExpect(jsonPath("$.success").value(true))
                .andExpect(jsonPath("$.message").value("Successfully subscribed to newsletter"));
    }

    @Test
    void testSubscribeDuplicateEmail() throws Exception {
        // Arrange
        NewsletterSubscriptionRequest request = NewsletterSubscriptionRequest.builder()
                .email("test@example.com")
                .build();
        doThrow(new DuplicateSubscriptionException("Email is already subscribed to the newsletter"))
                .when(newsletterService).subscribe(any());

        // Act & Assert
        mockMvc.perform(post("/newsletter/subscribe")
                        .contentType(MediaType.APPLICATION_JSON)
                        .content(objectMapper.writeValueAsString(request)))
                .andExpect(status().isConflict())
                .andExpect(jsonPath("$.success").value(false))
                .andExpect(jsonPath("$.message").value("Email is already subscribed to the newsletter"));
    }

    @Test
    void testSubscribeInvalidEmail() throws Exception {
        // Arrange
        NewsletterSubscriptionRequest request = NewsletterSubscriptionRequest.builder()
                .email("invalid-email")
                .build();

        // Act & Assert
        mockMvc.perform(post("/newsletter/subscribe")
                        .contentType(MediaType.APPLICATION_JSON)
                        .content(objectMapper.writeValueAsString(request)))
                .andExpect(status().isBadRequest())
                .andExpect(jsonPath("$.success").value(false))
                .andExpect(jsonPath("$.message").value("Validation failed"));
    }

    @Test
    void testSubscribeEmptyEmail() throws Exception {
        // Arrange
        NewsletterSubscriptionRequest request = NewsletterSubscriptionRequest.builder()
                .email("")
                .build();

        // Act & Assert
        mockMvc.perform(post("/newsletter/subscribe")
                        .contentType(MediaType.APPLICATION_JSON)
                        .content(objectMapper.writeValueAsString(request)))
                .andExpect(status().isBadRequest())
                .andExpect(jsonPath("$.success").value(false));
    }
}
// AI Generated Code by Deloitte + Cursor (END)
