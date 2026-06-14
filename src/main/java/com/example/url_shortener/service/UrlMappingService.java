package com.example.url_shortener.service;

import com.example.url_shortener.entity.UrlMapping;
import com.example.url_shortener.repository.UrlMappingRepository;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.UUID;
import java.util.Optional;

@Service
public class UrlMappingService {
    private final UrlMappingRepository repository;

    public UrlMappingService(UrlMappingRepository repository) {
        this.repository = repository;
    }

    public UrlMapping createShortUrl(String originalUrl) {
        String shortCode = UUID.randomUUID().toString().substring(0, 6);
        
        UrlMapping urlMapping = new UrlMapping();

        urlMapping.setOriginalUrl(originalUrl);
        urlMapping.setShortCode(shortCode);
        urlMapping.setCreatedAt(LocalDateTime.now());

        return repository.save(urlMapping);
    }

    public Optional<UrlMapping> getShortCode(String shortCode) {
        return repository.findByShortCode(shortCode);
    }
}
