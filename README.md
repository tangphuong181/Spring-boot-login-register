# Spring Boot Login Register

> A secure user authentication system with registration and login functionality built using Spring Boot, Spring Security and Thymeleaf.

## ✨ Features

- User Registration with form validation
- Secure Login & Logout
- Password encryption with BCrypt
- Responsive UI with Thymeleaf templates
- Database integration (SQL Server)
- Error handling and success messages
- Ready for role-based authentication

## 🛠 Tech Stack

- **Backend**: Spring Boot 3
- **Security**: Spring Security
- **Template Engine**: Thymeleaf
- **Database**: SQL Server
- **ORM**: Spring Data JPA + Hibernate
- **Build Tool**: Maven
- **Frontend**: HTML, CSS, Bootstrap

## 🚀 Installation & Setup

spring.datasource.url=jdbc:sqlserver://localhost:1433;databaseName=your_database_name;encrypt=true;trustServerCertificate=true
spring.datasource.username=sa
spring.datasource.password=your_password

spring.jpa.hibernate.ddl-auto=update
spring.jpa.show-sql=true

spring.thymeleaf.cache=false


### 1. Clone project
 ./mvnw spring-boot:run
 git clone https://github.com/tangphuong181/spring-boot-login-register.git
 cd spring-boot-login-register

### About Me
 Hi, I'm Phuong (Tang Phuong) — a passionate Java Backend Developer from Vietnam.I specialize in developing web applications using Spring Boot framework, Spring Security, and SQL Server. This project was built to practice and master user authentication flow in Spring Boot

