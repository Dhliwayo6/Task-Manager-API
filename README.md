# Tasked

A simple yet powerful task manager REST API built with Spring Boot that provides comprehensive CRUD operations for task management with JWT-based authentication.

## ✨ Features
- **Complete CRUD Operations**: Create, read, update, and delete tasks
- **JWT Authentication**: Secure API endpoints with JSON Web Token authentication
- **User Management**: User registration, login, and profile management
- **Email Integration**: Email verification and notifications
- **Data Persistence**: MySQL database integration with JPA
- **RESTful Design**: Clean and intuitive API endpoints
- **Input Validation**: Robust request validation
- **Security**: Spring Security implementation with authentication filters

## 🛠 Technology Stack

- **Backend Framework**: Spring Boot 3.4.3
- **Language**: Java 17
- **Database**: MySQL
- **ORM**: Spring Data JPA
- **Security**: Spring Security with JWT
- **Build Tool**: Maven
- **Testing**: Postman
- **Database Management**: MySQL Workbench

## 📋 Prerequisites

Before running this application, make sure you have the following installed:

- **Java 17** or higher
- **Maven 3.6+**
- **MySQL 8.0+**
- **MySQL Workbench** (optional, for database management)
- **Postman** (optional, for API testing)

## 🚀 Installation

### 1. Clone the Repository

```bash
git clone git@github.com:Dhliwayo6/Task-Manager-API.git
cd tasked
```

### 2. Database Setup

Create a MySQL database for the application:

```sql
CREATE DATABASE tasked_db;
CREATE USER 'tasked_user'@'localhost' IDENTIFIED BY 'your_password';
GRANT ALL PRIVILEGES ON tasked_db.* TO 'tasked_user'@'localhost';
FLUSH PRIVILEGES;
```

### 3. Configure Application Properties

Update `src/main/resources/application.properties`:

```properties
# Database Configuration
spring.datasource.url=jdbc:mysql://localhost:3306/tasked_db
spring.datasource.username=tasked_user
spring.datasource.password=your_password
spring.datasource.driver-class-name=com.mysql.cj.jdbc.Driver

# JPA Configuration
spring.jpa.hibernate.ddl-auto=update
spring.jpa.show-sql=true
spring.jpa.properties.hibernate.dialect=org.hibernate.dialect.MySQLDialect

# JWT Configuration
jwt.secret=your-secret-key
jwt.expiration=86400000

# Email Configuration
spring.mail.host=your-smtp-server
spring.mail.port=587
spring.mail.username=your-email
spring.mail.password=your-email-password
spring.mail.properties.mail.smtp.auth=true
spring.mail.properties.mail.smtp.starttls.enable=true
```

### 4. Build and Run

```bash
# Build the project
mvn clean compile

# Run the application
mvn spring-boot:run
```

The application will start on `http://localhost:8080`

## ⚙️ Configuration

### Environment Variables

You can also configure the application using environment variables:

```bash
export DB_URL=jdbc:mysql://localhost:3306/tasked_db
export DB_USERNAME=tasked_user
export DB_PASSWORD=your_password
export JWT_SECRET=your-secret-key
export JWT_EXPIRATION=86400000
```

### Database Initialization

The application includes a `data.sql` file for initial data setup. Modify this file to add sample data if needed.


## 📁 Project Structure

```
src/
├── main/
│   ├── java/com/example/taskmanager/
│   │   ├── controller/          # REST Controllers
│   │   │   ├── AuthenticationController.java
│   │   │   ├── TaskController.java
│   │   │   └── UserController.java
│   │   ├── dto/                 # Data Transfer Objects
│   │   ├── model/              # Entity Classes
│   │   │   ├── Task.java
│   │   │   └── User.java
│   │   ├── repository/         # JPA Repositories
│   │   ├── security/           # Security Configuration
│   │   ├── services/           # Business Logic
│   │   │   ├── task/          # Task-related services
│   │   │   └── user/          # User-related services
│   │   └── response/          # Response Objects
│   └── resources/
│       ├── application.properties
│       └── data.sql
└── test/                      # Unit and Integration Tests
```

## 🧪 Testing

### Using Postman

1. Import the provided Postman collection https://platform-0738.postman.co/workspace/Task-Manager-API~bc626d82-5a28-4494-87d2-159e527b3397/request/44641522-091a48a8-461e-4b77-ae10-d1549eb68705?action=share&source=copy-link&creator=44641522
2. Set up environment variables for base URL and JWT token
3. Test authentication endpoints first
4. Use the received JWT token for testing protected endpoints

### Running Unit Tests

```bash
mvn test
```

## 🔧 Troubleshooting

### Common Issues

**Database Connection Issues:**
- Verify MySQL is running
- Check database credentials in `application.properties`
- Ensure the database exists and user has proper permissions

**JWT Token Issues:**
- Make sure the JWT secret is properly configured
- Check token expiration settings
- Verify the Authorization header format: `Bearer <token>`

**Email Service Issues:**
- Verify SMTP server settings
- Check email credentials
- Ensure firewall allows SMTP connections

**Build Issues:**
- Ensure Java 17 is installed and configured
- Run `mvn clean install` to resolve dependencies
- Check for any missing environment variables

### Logging

Enable debug logging by adding to `application.properties`:

```properties
logging.level.com.example.taskmanager=DEBUG
logging.level.org.springframework.security=DEBUG
```
