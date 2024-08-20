package com.example.cache_api.controller;

import com.example.cache_api.model.CacheData;
import com.example.cache_api.service.CacheService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/cache")
public class CacheController {

    private final CacheService cacheService;

    @Autowired
    public CacheController(CacheService cacheService) {
        this.cacheService = cacheService;
    }

    @PostMapping("/put")
    public ResponseEntity<String> putData(@RequestParam String cacheName, @RequestBody CacheData data) {
        try {
            cacheService.putData(cacheName, data);
            return new ResponseEntity<>("Data "+data.getValue()+" with TTL: "+data.getTimeToLiveInMinute()+" has been cached successfully.", HttpStatus.OK);
        } catch (Exception e) {
            return ResponseEntity.status(500).body("Error while caching data: " + e.getMessage());
        }
    }

    @GetMapping("/get")
    public ResponseEntity<String> getData(@RequestParam String cacheName, @RequestParam String key) {
        try {
            String value = cacheService.getData(cacheName, key);
            if (value != null) {
                return ResponseEntity.ok(value);
            } else {
                return ResponseEntity.notFound().build();
            }
        } catch (Exception e) {
            return ResponseEntity.status(500).body("Error while retrieving data: " + e.getMessage());
        }
    }

    @DeleteMapping("/delete")
    public ResponseEntity<String> deleteData(@RequestParam String cacheName, @RequestParam String key) {
        try {
            cacheService.deleteData(cacheName, key);
            return ResponseEntity.ok("Data has been deleted from cache.");
        } catch (Exception e) {
            return ResponseEntity.status(500).body("Error while deleting data: " + e.getMessage());
        }
    }
}
