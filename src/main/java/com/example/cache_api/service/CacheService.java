package com.example.cache_api.service;

import com.example.cache_api.model.CacheData;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.stereotype.Service;

import java.util.concurrent.TimeUnit;

@Service
public class CacheService {

    private final RedisTemplate<String, String> redisTemplate;

    public CacheService(RedisTemplate<String, String> redisTemplate) {
        this.redisTemplate = redisTemplate;
    }

    public void putData(String cacheName, CacheData data) {
        redisTemplate.opsForValue().set(cacheName + ":" + data.getKey(),
                data.getValue(), data.getTimeToLiveInMinute(), TimeUnit.MINUTES);
    }

    public String getData(String cacheName, String key) {
        try {
            return redisTemplate.opsForValue().get(cacheName + ":" + key);
        } catch (Exception e) {
            e.printStackTrace();
            throw new RuntimeException("خطا در دریافت داده از کش", e);
        }
    }

    public void deleteData(String cacheName, String key) {
        redisTemplate.delete(cacheName + ":" + key);
    }
}

