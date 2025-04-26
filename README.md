# Product Management API Uisng Spring Boot, MySQL, Spring Security, JPA, Rest API

This API provides basic CRUD (Create, Read, Update, Delete) operations for managing a list of products. It's built using Spring Boot and leverages Spring Data JPA for database interaction.

## About the API

This API serves as a backend for managing a collection of products. It provides a straightforward way to perform fundamental operations on product data, allowing clients to:

* **Create** new product entries, specifying their name, price, and quantity.
* **Read** details of individual products by their unique ID, or retrieve a comprehensive list of all available products.
* **Update** the information of existing products, such as their name, price, or quantity, using their ID.
* **Delete** product entries from the system based on their unique ID.

This API is built using Spring Boot, a Java framework known for its ease of use and rapid development capabilities. It utilizes Spring Data JPA to simplify database interactions, allowing the application to seamlessly manage product data within a persistent storage. For security, the API employs basic HTTP authentication to protect data modification endpoints, ensuring that only authorized users can create, update, or delete products. The read operations (retrieving product information) are publicly accessible.

In essence, this API provides the essential building blocks for any application that needs to manage and display product information, from simple inventory tracking systems to more complex e-commerce platforms.

## File Descriptions

* **`src/main/java/com/crud/api/Repository/ProductRepository.java`**: This interface defines the repository for the `ProductList` entity. It extends `JpaRepository`, providing methods for basic database operations like saving, finding, and deleting records. Spring Data JPA automatically generates the implementation for this interface.
* **`src/main/java/com/crud/api/Model/ProductList.java`**: This class represents the `ProductList` entity, which maps to the `products` table in the database. It defines the structure of a product, including its `id`, `name`, `price`, and `quantity`. It uses Jakarta Persistence annotations (`@Entity`, `@Table`, `@Id`, `@GeneratedValue`, `@Column`) to define its mapping to the database.
* **`src/main/java/com/crud/api/Controller/ProductController.java`**: This class is a REST controller that handles incoming HTTP requests related to products. It exposes endpoints for creating, retrieving, updating, and deleting products. It uses the `ProductRepository` to interact with the database and returns appropriate HTTP responses.
* **`src/main/java/com/crud/api/SecurityConfiguration/SecurityConfig.java`**: This class configures the security for the API. It sets up basic HTTP authentication and specifies that GET requests to `/api/product/**` are permitted without authentication, while all other requests require authentication. It also defines an in-memory user for authentication.

## API Endpoints

### Product Operations

| Method | URL             | Description                     | Sample Valid Request Body                                  |
| :----- | :-------------- | :------------------------------ | :--------------------------------------------------------- |
| POST   | `/api/product`   | Creates a new product.          | [Link to Sample JSON Data](#sample-json-data)             |
| GET    | `/api/product`   | Retrieves a list of all products. | N/A                                                        |
| GET    | `/api/product/{id}` | Retrieves a product by its ID.  | N/A                                                        |
| DELETE | `/api/product/{id}` | Deletes a product by its ID.    | N/A                                                        |
| PUT    | `/api/product/{id}` | Updates an existing product.    | [Link to Sample JSON Data](#sample-json-data)             |

### Sample JSON Data

```json
{
  "name": "Example Product",
  "price": 25.99,
  "quantity": 100
}

## Authentication

The API is secured using basic HTTP authentication for all endpoints except for GET requests to /api/product/**.

| Method | URL             | Description                         |                                
| :----- | :-------------- | :------------------------------     | 
| POST   | `/api/product`   | Creates a new product require auth.|
| DELETE | `/api/product/{id}` | Delete a product require auth.    |
| PUT    | `/api/product/{id}` | Updates an existing product require auth.| 
