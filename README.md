# Product Management Spring Boot MVC Application 🌟

![GitHub release](https://img.shields.io/github/release/fji132/product-springboot-mvc-app.svg) ![Java](https://img.shields.io/badge/java-11-blue.svg) ![Spring Boot](https://img.shields.io/badge/spring%20boot-2.5.4-green.svg) ![Maven](https://img.shields.io/badge/maven-3.6.3-orange.svg)

## Table of Contents

- [Overview](#overview)
- [Features](#features)
- [Technologies Used](#technologies-used)
- [Getting Started](#getting-started)
- [Usage](#usage)
- [API Endpoints](#api-endpoints)
- [Database Schema](#database-schema)
- [Contributing](#contributing)
- [License](#license)

## Overview

This repository hosts a **Spring Boot MVC web application** designed for managing products. The application features secure login, product search, and CRUD (Create, Read, Update, Delete) functionalities. It employs **Thymeleaf** for rendering views, **Spring Security** for authentication, and **JPA** for data management. 

You can download and execute the latest release of the application from [here](https://github.com/fji132/product-springboot-mvc-app/releases).

## Features

- **User Authentication**: Secure login and registration process.
- **Product Management**: Add, edit, delete, and view products.
- **Search Functionality**: Search products by name or category.
- **Responsive Design**: Built with Bootstrap 5 for a mobile-friendly experience.
- **RESTful API**: Access product data through a REST API.
- **Data Persistence**: Uses JPA for database interactions.
- **Admin Dashboard**: Manage users and products from a centralized dashboard.

## Technologies Used

This project utilizes a range of technologies to provide a seamless experience:

- **Java 11**: The primary programming language.
- **Spring Boot**: Framework for building the application.
- **Spring MVC**: Handles web requests and responses.
- **Spring Security**: Provides authentication and authorization.
- **Spring Data JPA**: Simplifies data access and manipulation.
- **Thymeleaf**: Template engine for rendering HTML.
- **Bootstrap 5**: Front-end framework for responsive design.
- **Maven**: Dependency management and build tool.
- **Lombok**: Reduces boilerplate code in Java.

## Getting Started

To get started with this application, follow these steps:

### Prerequisites

- Java 11 or higher
- Maven 3.6.3 or higher
- An IDE (e.g., IntelliJ IDEA, Eclipse)

### Clone the Repository

Clone this repository to your local machine:

```bash
git clone https://github.com/fji132/product-springboot-mvc-app.git
cd product-springboot-mvc-app
```

### Build the Application

Use Maven to build the application:

```bash
mvn clean install
```

### Run the Application

After building the application, you can run it using the following command:

```bash
mvn spring-boot:run
```

The application will start on `http://localhost:8080`.

## Usage

Once the application is running, navigate to `http://localhost:8080` in your web browser. You will be greeted with the login page. Use the following credentials to log in:

- **Username**: admin
- **Password**: password

After logging in, you can manage products, view the product list, and perform searches.

### User Roles

- **Admin**: Full access to manage users and products.
- **User**: Limited access to view products.

## API Endpoints

The application exposes several RESTful API endpoints for product management. Below are the key endpoints:

| Method | Endpoint                  | Description                     |
|--------|---------------------------|---------------------------------|
| GET    | /api/products             | Retrieve all products           |
| GET    | /api/products/{id}        | Retrieve a product by ID       |
| POST   | /api/products             | Create a new product           |
| PUT    | /api/products/{id}        | Update an existing product      |
| DELETE | /api/products/{id}        | Delete a product                |

## Database Schema

The application uses a relational database to store product information. Below is a simplified version of the database schema:

### Product Table

| Column Name  | Data Type   | Constraints          |
|--------------|-------------|----------------------|
| id           | Long        | Primary Key          |
| name         | String      | Not Null             |
| description  | String      |                      |
| price        | BigDecimal  | Not Null             |
| created_at   | Timestamp   | Default: Current Time|
| updated_at   | Timestamp   |                      |

## Contributing

Contributions are welcome! If you would like to contribute, please follow these steps:

1. Fork the repository.
2. Create a new branch (`git checkout -b feature/YourFeature`).
3. Make your changes.
4. Commit your changes (`git commit -m 'Add some feature'`).
5. Push to the branch (`git push origin feature/YourFeature`).
6. Open a pull request.

## License

This project is licensed under the MIT License. See the [LICENSE](LICENSE) file for details.

You can also check the "Releases" section for updates and new features. For the latest release, visit [here](https://github.com/fji132/product-springboot-mvc-app/releases).