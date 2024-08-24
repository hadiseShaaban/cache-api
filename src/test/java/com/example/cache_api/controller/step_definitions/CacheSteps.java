package com.example.cache_api.controller.step_definitions;

import com.example.cache_api.model.CacheData;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.When;
import io.cucumber.java.en.Then;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpMethod;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.client.RestTemplate;
import org.junit.Assert;

@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
public class CacheSteps {

    @Autowired
    private RestTemplate restTemplate;

    private String cacheName;
    private CacheData cacheData;
    private ResponseEntity<String> response;

    @Given("I have a cache name {string}")
    public void i_have_a_cache_name(String cacheName) {
        this.cacheName = cacheName;
    }

    @Given("I have a cache data with key {string} and value {string} and TTL {int} minutes")
    public void i_have_a_cache_data(String key, String value, int ttl) {
        this.cacheData = new CacheData(key, value, ttl);
    }

    @When("I add the data to the cache")
    public void i_add_the_data_to_the_cache() {
        String url = "http://localhost:8080/cache-api/caches/" + cacheName + "/entries";
        HttpEntity<CacheData> request = new HttpEntity<>(cacheData);
        response = restTemplate.exchange(url, HttpMethod.POST, request, String.class);
    }

    @When("I retrieve the data from the cache with key {string}")
    public void i_retrieve_the_data_from_the_cache(String key) {
        String url = "http://localhost:8080/cache-api/caches/" + cacheName + "/entries/" + key;
        response = restTemplate.exchange(url, HttpMethod.GET, null, String.class);
    }

    @When("I delete the data from the cache with key {string}")
    public void i_delete_the_data_from_the_cache(String key) {
        String url = "http://localhost:8080/cache-api/caches/" + cacheName + "/entries/" + key;
        response = restTemplate.exchange(url, HttpMethod.DELETE, null, String.class);
    }

    @Then("the response should be {string}")
    public void the_response_should_be(String expectedResponse) {
        Assert.assertEquals(expectedResponse, response.getBody());
        Assert.assertEquals(HttpStatus.OK, response.getStatusCode());
    }
}