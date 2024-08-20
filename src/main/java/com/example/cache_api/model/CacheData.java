package com.example.cache_api.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class CacheData {
    private String key;
    private String value;
    private int timeToLiveInMinute;
}
