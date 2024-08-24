package com.example.cache_api.configuration;

import com.example.cache_api.CacheApiApplication;
import io.cucumber.spring.CucumberContextConfiguration;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.ContextConfiguration;

@CucumberContextConfiguration
@SpringBootTest(classes = CacheApiApplication.class)
public class CucumberSpringConfiguration {
}
