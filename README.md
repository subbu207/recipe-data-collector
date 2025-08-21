🍲 Recipe API (Spring Boot + MySQL)

This project is a RESTful API built with Spring Boot 3, Hibernate JPA, and MySQL for managing recipes.
It supports creating, updating, retrieving, and deleting recipes.

🚀 Features

REST API endpoints for CRUD operations on recipes

Uses MySQL as database

JPA/Hibernate for ORM

Maven for build & dependency management

Ready for Postman / curl testing

📦 Tech Stack

Java 17

Spring Boot 3.3.x

Spring Data JPA

MySQL 8

Maven

⚙️ Setup Instructions
1. Clone the repository
git clone https://github.com/your-username/recipe-api.git
cd recipe-api

2. Configure Database

Create a MySQL database:

CREATE DATABASE recipe_db;


Update src/main/resources/application.properties with your MySQL credentials:

spring.datasource.url=jdbc:mysql://localhost:3306/recipe_db?useSSL=false&serverTimezone=UTC
spring.datasource.username=root
spring.datasource.password=your_password
spring.datasource.driver-class-name=com.mysql.cj.jdbc.Driver

spring.jpa.hibernate.ddl-auto=update
spring.jpa.show-sql=true
spring.jpa.properties.hibernate.dialect=org.hibernate.dialect.MySQLDialect

3. Build the project
mvn clean package -U

4. Run the application
mvn spring-boot:run


The application will start at:
👉 http://localhost:8080

📡 REST API Endpoints
Create a Recipe
POST /api/recipes
Content-Type: application/json

{
  "title": "Sweet Potato Pie",
  "cuisine": "Southern Recipes",
  "calories": 389,
  "totalTime": 115,
  "rating": 4.8
}

Get All Recipes
GET /api/recipes

Get Recipe by ID
GET /api/recipes/{id}

Search Recipes
GET /api/recipes/search?title=Sweet%20Potato%20Pie

Update Recipe
PUT /api/recipes/{id}
Content-Type: application/json

{
  "title": "Updated Recipe Title",
  "cuisine": "Indian",
  "calories": 250,
  "totalTime": 60,
  "rating": 4.5
}

Delete Recipe
DELETE /api/recipes/{id}

🧪 Testing with curl
curl -X POST http://localhost:8080/api/recipes \
  -H "Content-Type: application/json" \
  -d '{"title":"Sweet Potato Pie","cuisine":"Southern Recipes","calories":389,"totalTime":115,"rating":4.8}'

curl http://localhost:8080/api/recipes

📝 Notes

Ensure MySQL is running before starting the app.

Default port: 8080

Database: recipe_db

Java version: 17
