package com.example.url_shortener.dto;

import java.time.LocalDateTime;

public class UrlStatsResponse {
    private String originalUrl;
    private String shortCode;
    private Long clickCount;
    private LocalDateTime createdAt;

    public UrlStatsResponse(String originalUrl, String shortCode, Long clickCount, LocalDateTime createdAt) {
        this.originalUrl = originalUrl;
        this.shortCode = shortCode;
        this.clickCount = clickCount;
        this.createdAt = createdAt;
    }

    public String getOriginalUrl() {
        return originalUrl;
    }
    
    public String getShortCode() {
        return shortCode;
    }
    
    public Long getClickCount() {
        return clickCount;
    }
    
    public LocalDateTime getCreatedAt() {
        return createdAt;
    }
}
