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

### Project Structure
![bus](https://user-images.githubusercontent.com/87421981/233263149-c348e6b0-0e3f-4a54-8392-68cb734cc47e.png)





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



### Admin Module

* `POST /admin/add` : Adds a new admin to the system.
* `POST /admin/login` : Allows an admin to login to the system using their username and password.`Request Body`: JSON object representing the admin's login credentials
* `DELETE /admin/logout/{sessionKey}` : `Path Parameters`: `sessionKey` The session key of the admin to logout
* `PUT /update/{sessionKey}`: `Path Parameters`: `sessionKey` The session key of the admin to update
`Request Body`: JSON object representing the updated admin details
* `DELETE /delete/{sessionKey}` : `Path Parameters :` `sessionKey` The session key of the admin to delete


### Customer Module


* `POST /customer/add` : Adds a new customer to the system.
* `POST /customer/login` : Allows a customer to login with their username and password. `Request Body`: CustomerLoginDto object in JSON format
* `DELETE/customer/logout/{key}` : Allows a customer to logout from the system. `Request Header:` Authorization containing the session key
* `PUT /customer/update/{key}` : Updates an existing customer in the system.
`Request Header:` Authorization containing the session key
`Request Body:` Customer object in JSON format
* `DELETE /customer/delete/{id}` : Deletes an existing customer from the system
`Path Parameters:`id: The ID of the customer to delete
`Request Header:` Authorization containing the session key
* `GET /customer/view/{id}` : Retrieves a customer by their ID `Path Parameters:` id: The ID of the customer to retrieve
`Request Header:` Authorization containing the session key









