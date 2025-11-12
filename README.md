# myBookstore

Welcome to myBookStore! myBookStore is a command-line application that enables users to create an account, log in, and purchase and sell books. I built this application to demonstrate what I have learned so far in Spring.

## Built With:

__[Spring Boot](https://spring.io/projects/spring-boot/) for simplifying Spring configuration__<br>
- myBookstore uses Spring Boot to simplify Spring configuration and dependency management.

__[Spring Data](https://spring.io/projects/spring-data), [Hibernate](https://hibernate.org/), and [MySQL](https://www.mysql.com/) for data persistence and Object-Relational Mapping__<br>
- myBookstore handles data persistence by employing Spring Data JPA and Hibernate, mapping Java objects to a relational MySQL database and executing seamless CRUD operations without the use of raw SQL queries.

__[JUnit](https://junit.org/) and [Mockito](https://site.mockito.org/) for unit and integration testing__<br>
- myBookstore utilizes JUnit 5 and Mockito to thoroughly test the application's logic and database interactions. JUnit 5 is used for unit testing, as well as integration testing with Spring Data JPA. Mockito is used for mocking dependencies and isolating testing of service-level classes.

## Design

myBookstore is implemented using N-tier architecture. The data access layer is abstracted through Data Access Object interfaces, and business logic is handled by service classes. Finally, UI classes within the presentation layer handle all user interactions and send requests to the logic layer for processing. Altogether, this design promotes modularity, security, and maintainability.

## Lessons Learned:

(In progress)

## Contact:
Christal Dita | [LinkedIn](https://www.linkedin.com/in/cdita/) 

## Acknowledgements:

(In progress)
