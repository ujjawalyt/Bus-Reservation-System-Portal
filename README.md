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

-  Admin Login Module
-  Customer Login Module
-  Admin Module
-  Customer Module
-  Bus Module
-  Route Module
-  FeedBack Module
-  Reservation Module



### Features

* Admin Login Features :-
    This module provides the functionality for admin authentication and validation to access the admin dashboard. The following features are included:
    
    * Admins can log in with their username and password.
    * The module validates the admin's credentials and generates a session token for the admin to access the admin dashboard.
    * The session token is stored securely and used to verify the admin's identity for subsequent requests.
* Customer Login Features :-
  This module provides the functionality for user authentication and validation to access user-specific features. The following features are included:

  * Customer can register and create an account with a username and password.
  * Customer can log in with their username and password.
  * The module validates the user's credentials and generates a session token for the user to access user-specific features.
  * The session token is stored securely and used to verify the user's identity for subsequent requests. 



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








