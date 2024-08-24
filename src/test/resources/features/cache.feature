Feature: Cache API
  Scenario: Add data to cache
    Given I have a cache name "myCache"
    And I have a cache data with key "testKey" and value "testValue" and TTL 5 minutes
    When I add the data to the cache
    Then the response should be "Data testValue with TTL: 5 has been cached successfully."

  Scenario: Retrieve data from cache
    Given I have a cache name "myCache"
    And I have a cache data with key "testKey" and value "testValue" and TTL 5 minutes
    When I retrieve the data from the cache with key "testKey"
    Then the response should be "testValue"

  Scenario: Delete data from cache
    Given I have a cache name "myCache"
    When I delete the data from the cache with key "testKey"
    Then the response should be "Data has been deleted from cache."
