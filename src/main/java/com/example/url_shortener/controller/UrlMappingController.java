package com.example.url_shortener.controller;

import com.example.url_shortener.dto.CreateUrlRequest;
import com.example.url_shortener.dto.CreateUrlResponse;
import com.example.url_shortener.entity.UrlMapping;
import com.example.url_shortener.service.UrlMappingService;

import org.springframework.web.bind.annotation.*;

import java.net.URI;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

@RestController
@RequestMapping("api/v1/urls")
public class UrlMappingController {
    private final UrlMappingService service;

    public UrlMappingController(UrlMappingService service) {
        this.service = service;
    }

    @PostMapping
    public CreateUrlResponse createShortUrl(@RequestBody CreateUrlRequest request) {
        UrlMapping saved = service.createShortUrl(request.getOriginalUrl());
        return new CreateUrlResponse(saved.getShortCode(), "http://localhost:8080/api/v1/urls/" + saved.getShortCode());
    }

    @GetMapping("/{shortCode}")
    public ResponseEntity<Object> redirectToOriginalUrl(@PathVariable String shortCode) {
        return service.getShortCode(shortCode)
                .map(urlMapping -> ResponseEntity.status(HttpStatus.FOUND).location(URI.create(urlMapping.getOriginalUrl())).build())
                .orElse(ResponseEntity.status(HttpStatus.NOT_FOUND).build());
    }
}
