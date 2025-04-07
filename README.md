# 🧠 Cache API

A minimal Spring Boot REST API for demonstrating caching strategies in Java applications.

---

## 🧩 Features

- RESTful API for managing simple data (e.g., person information)  
- In-memory caching using Spring Cache abstraction  
- Configurable cache behavior  
- Logging to observe cache hits/misses  
- Swagger UI for testing endpoints

---

## 🛠 Technologies

- Java 17  
- Spring Boot 3.3.x  
- Spring Web  
- Spring Cache (with ConcurrentMapCacheManager)  
- Lombok  
- Swagger/OpenAPI  
- Maven

---

## ⚙️ Getting Started

### Prerequisites

- Java 17  
- Maven

### Clone the Repository

```bash
git clone https://github.com/hadiseShaaban/cache-api.git
cd cache-api

---

###Run the App
mvn spring-boot:run

The app will start at:
http://localhost:8080

---

### 🧪 Running Tests
mvn test

---
### 🔍 API Documentation
Swagger UI is available at:
http://localhost:8080/swagger-ui.html

---
💾 Sample Endpoints
Method	Endpoint	Description
GET	/persons/{id}	Get person by ID (cached)
POST	/persons	Add a new person
PUT	/persons/{id}	Update person by ID
DELETE	/persons/{id}	Delete person (evicts cache)
Caching is applied on the GET endpoint. You can observe caching behavior through the logs.

🔁 Caching Configuration
Caching is enabled via @EnableCaching, and Spring's default ConcurrentMapCacheManager is used.

You can customize cache names and behavior in the future via application.properties or by defining your own cache manager bean.

🙋‍♀️ Author
programmed by Hadise Shaaban
