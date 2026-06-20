package com.example.url_shortener.entity;

import jakarta.persistence.*;
import java.time.LocalDateTime;
import java.util.UUID;

@Entity
public class UrlMapping {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String originalURL;

    @Column(unique = true)
    private String shortCode;

    private LocalDateTime createdAt;

    public UrlMapping() {
    }

    public Long getId() {
        return id;
    }

    public String getOriginalUrl() {
        return originalURL;
    }

    public void setOriginalUrl(String originalUrl) {
        this.originalURL = originalUrl;
    }

    public String getShortCode() {
        return shortCode;
    }

    public void setShortCode(String shortCode) {
        this.shortCode = shortCode;
    }

    public LocalDateTime getCreatedAt() {
        return createdAt;
    }

    public void setCreatedAt(LocalDateTime createdAt) {
        this.createdAt = createdAt;
    }

    private String generateShortCode() {
        return UUID.randomUUID().toString().substring(0, 6);
    }
}
