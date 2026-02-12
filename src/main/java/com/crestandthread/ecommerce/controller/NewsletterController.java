// AI Generated Code by Deloitte + Cursor (BEGIN)
package com.crestandthread.ecommerce.controller;

import com.crestandthread.ecommerce.dto.ApiResponse;
import com.crestandthread.ecommerce.dto.NewsletterSubscriptionRequest;
import com.crestandthread.ecommerce.service.NewsletterService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/newsletter")
@RequiredArgsConstructor
@Slf4j
@CrossOrigin(origins = "http://localhost:3000")
public class NewsletterController {

    private final NewsletterService newsletterService;

    @PostMapping("/subscribe")
    public ResponseEntity<ApiResponse> subscribe(@Valid @RequestBody NewsletterSubscriptionRequest request) {
        log.info("POST /newsletter/subscribe - Subscribing email: {}", request.getEmail());
        newsletterService.subscribe(request);
        
        ApiResponse response = ApiResponse.builder()
                .success(true)
                .message("Successfully subscribed to newsletter")
                .build();
        
        return ResponseEntity.status(HttpStatus.CREATED).body(response);
    }
}
// AI Generated Code by Deloitte + Cursor (END)
