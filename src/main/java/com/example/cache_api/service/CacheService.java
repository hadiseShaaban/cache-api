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
        try {
            String fullKey = cacheName + ":" + data.getKey();
            redisTemplate.opsForValue().set(fullKey, data.getValue(), data.getTimeToLiveInMinute(), TimeUnit.MINUTES);//ttl
        } catch (Exception e) {
            e.printStackTrace();
            throw new RuntimeException("error in inserting data to cache!!!", e);
        }
    }

    public String getData(String cacheName, String key) {
        try {
            String fullKey = cacheName + ":" + key;
            return redisTemplate.opsForValue().get(fullKey);
        } catch (Exception e) {
            e.printStackTrace();
            throw new RuntimeException("error in read data from cache!!!", e);
        }
    }

    public void deleteData(String cacheName, String key) {
        try {
            String fullKey = cacheName + ":" + key;
            redisTemplate.delete(fullKey);
        } catch (Exception e) {
            e.printStackTrace();
            throw new RuntimeException("error in delete!!!", e);
        }
    }
}