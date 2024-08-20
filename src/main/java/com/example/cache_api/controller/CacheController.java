package com.example.cache_api.controller;

import com.example.cache_api.model.CacheData;
import com.example.cache_api.service.CacheService;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/cache")
public class CacheController {

    private final CacheService cacheService;

    public CacheController(CacheService cacheService) {
        this.cacheService = cacheService;
    }

    @PostMapping("/put")
    public void putData(@RequestParam String cacheName, @RequestBody CacheData data) {
        cacheService.putData(cacheName, data);
    }

    @GetMapping("/get")
    public String getData(@RequestParam String cacheName, @RequestParam String key) {
        return cacheService.getData(cacheName, key);
    }

    @DeleteMapping("/delete")
    public void deleteData(@RequestParam String cacheName, @RequestParam String key) {
        cacheService.deleteData(cacheName, key);
    }
}

