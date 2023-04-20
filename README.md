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
* Customer Features :-
  This module provides functionality for managing customer data. The following features are included:
  
  * Add customer: Allows adding a new customer to the system.
  * Update customer: Allows updating an existing customer's data, such as their name, email, or address.
  * Delete customer: Allows deleting an existing customer from the system.
  * View customer by ID: Allows retrieving a single customer's data by their unique ID.
  * Admin can View all customers: Allows retrieving a list of all customers in the system, optionally filtered by a search key.
* Bus Features :-
  This module provides functionality for managing bus data. The following features are included:
  
  * Add bus: Admin adding a new bus to the system.
  * Update bus: Admin updating an existing bus's data, such as its name, model, or seating capacity.
  * Delete bus: Admin deleting an existing bus from the system.
  * View bus by ID: Admin and Customer retrieving a single bus's data by its unique ID.
  * View buses by type: Admin and Customer retrieving a list of all buses in the system of a particular type.
  * View all buses: Admin and Customer retrieving a list of all buses in the system.
* Route Features :-
  This module provides functionality for managing bus data. The following features are included:
  
  * Add bus: Admin adding a new bus to the system.
  * Update bus: Admin updating an existing bus's data, such as its name, model, or seating capacity.
  * Delete bus: Admin deleting an existing bus from the system.
  * View bus by ID: Admin and Customer retrieving a single bus's data by its unique ID.
  * View buses by type: Admin and Customer retrieving a list of all buses in the system of a particular type.
  * View all buses: Admin and Customer retrieving a list of all buses in the system.
* FeedBack Features :-
  This module provides functionality for managing feedback data. The following features are included:
  
  * Add feedback: Allows a customer to add new feedback to the system.
  * Update feedback: Allows a customer to update their existing feedback.
  * View feedback: Allows viewing a single feedback's data by its unique ID.
  * View all feedback: Admin  viewing a list of all feedback in the system.

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
* `DELETE /admin/logout/{sessionKey}` : `Path Parameters : sessionKey` The session key of the admin to logout
* `PUT /update/{sessionKey}`: `Path Parameters : sessionKey` The session key of the admin to update
`Request Body`: JSON object representing the updated admin details
* `DELETE /delete/{sessionKey}` : `Path Parameters :sessionKey` The session key of the admin to delete


### Customer Module


* `POST /customer/add` : Adds a new customer to the system.
* `POST /customer/login` : Allows a customer to login with their username and password. `Request Body`: CustomerLoginDto object in JSON format
* `DELETE/customer/logout/{key}` : Allows a customer to logout from the system. `Request Header:` Authorization containing the session key
* `PUT /customer/update/{key}` : Updates an existing customer in the system.
`Request Header:` Authorization containing the session key
`Request Body:` Customer object in JSON format
* `DELETE /customer/delete/{id}` : Deletes an existing customer from the system
`Path Parameters: id` The ID of the customer to delete
`Request Header:` Authorization containing the session key
* `GET /customer/view/{id}` : Retrieves a customer by their ID `Path Parameters: id` The ID of the customer to retrieve
`Request Header:` Authorization containing the session key


### Bus Module


* `POST /buses/add/{key}` : Adds a new bus to the system. Path Parameters: key The authentication key of the admin adding the bus. `Request Body`: JSON object representing the new bus's details.
* `PUT /buses/update/{id}/{key}` : `Path Parameters: id` The ID of the bus to update. key The authentication key of the admin updating the bus. `Request Body`: JSON object representing the updated bus details.
* `DELETE /buses/delete/{id}/{key}` : `Path Parameters: id` The ID of the bus to delete. key The authentication key of the admin deleting the bus.
* `GET /buses/views/{id}` : `Path Parameters: id` The ID of the bus to view. Returns the details of the bus with the specified ID.
* `GET /buses/viewall` : Returns a list of all buses registered in the system.
* `GET /buses/view/{type}` : `Path Parameters: type` The type of bus to view. Returns a list of all buses with the specified type.


### Route module


* `POST /route/add/{key}`: Adds a new route to the system. `Request Body:` JSON object representing the route details. Path Parameters: key The authentication key of the admin user.
* `PUT /route/update/{id}/{key}`: Updates an existing route in the system. `Request Body:` JSON object representing the updated route details. `Path Parameters: id` The ID of the route to update. key The authentication key of the admin user.
* `DELETE /route/delete/{id}/{key}`: Deletes a route from the system. `Path Parameters: id` The ID of the route to delete. key The authentication key of the admin user.
* `GET /route/views/{id}`: Retrieves the details of a specific route by its ID. `Path Parameters: id` The ID of the route to retrieve.
* `GET /route/viewall`: Retrieves the details of all routes in the system.



#### For any feedback, report, suggestions, you can contact with me 
[Let's Connect...]
### THANK YOU


