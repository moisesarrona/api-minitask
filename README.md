# api-minitask 📓
### Api to organize your tasks
This Api save your tasks classifying them by priority and status

### Technologies 💻
- Java 11
- Spring Boot
- JPA

### Dependencies 🏗
- MySQL Connector
- Validators
- Lombok

### Requirements 📋
- Java 11
- Apache
- Mysql

## Setup 🚀
This app run Java framework the Spring boot, you need an interpreter java, in my case using an IDE Intellij,
```
You need to click  run
```

### Test 🔍 
api-minitask need http requests to work You can do them through an app that embeds the application you can do them through an app that embeds the application
or you can use postman.

In postman sends information in JSON format, this api has validations which verify the information and the fields to send

#### Modules and format JSON
```
request post
{
    "name": "Tarea 1",
    "description": "Limpiar los baños",
    "status": true
}
request put
{
    "id": 1,
    "name": "Tarea uno",
    "description": "Limpiar los baños",
    "status": true
}
```

#### Modules and routes 
Route main: localhost:8080/api/
- Tasks
  - get /task
  - post /task
  - put /task/{id}
  - delete /task/{id}
