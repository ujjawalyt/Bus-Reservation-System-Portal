# Bus-Reservation-System-Portal

The Bus-Reservation-System is a web-based application that allows users to reserve seats on a bus for a particular route and date. The application has a user-friendly interface that allows users to search for available buses, select their preferred seats, and make payments securely.







### Technical Stacks

- Spring Boot 
- Spring Framework
- Spring Data JPA 
- MySQL 
- Hibernate
- Java
- Swagger UI
- Postman
- Spring Security



### Modules

-  Admin Module
-  Customer Module
-  Bus Module
-  Route Module
-  FeedBack Module
-  Reservation Module



### ER Diagram
The following Diagram depicts the flow of our Entity Relation Diagram to simplify the work flow.
![Screenshot 2023-04-19 114958](https://user-images.githubusercontent.com/87421981/232984037-84ca017d-6fca-481a-b859-fc2182a4a532.png)



### Installation & Run
- Before running the API server, you have to update the database configuration inside the application.properties file
- Update the port number, username and password as per your local database configuration
````
    server.port=8888

    spring.datasource.url=jdbc:mysql://localhost:3306/ecomdb;
    spring.datasource.driver-class-name=com.mysql.cj.jdbc.Driver
    spring.datasource.username=put your mysql username
    spring.datasource.password=put your mysql password
    
````
## API Root Endpoint

`https://localhost:8888/`

`http://localhost:8888/swagger-ui.html`








