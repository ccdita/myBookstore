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

In designing and building this project, I learned the following:
- **The purpose of Inversion of Control (IoC) and Dependency Injection (DI)**. Spring follows the principle of IoC, and one pattern of IoC that it uses is DI. By transferring the responsibility of an object's lifecycle to the Spring IoC container, the application becomes loosely coupled. The code therefore becomes more modular and testable; developers can reuse components in different contexts and test them in isolation via mocks.
- **Setting up a Spring Boot CRUD application**. By following [Chad Darby's Spring Boot course on Udemy](https://www.udemy.com/course/spring-hibernate-tutorial/?couponCode=KEEPLEARNING), I learned how to connect to a MySQL database, create and configure entity classes and Data Access Objects, and implement JPA CRUD operations.
- **Testing classes in the data access layer**. I learned how to use the `@DataJpaTest` annotation to create an embedded in-memory (H2) database and perform transactional operations that were automatically rolled back after execution. Moreover, I learned how to use the `@Import` annotation to load custom repository implementations, since `@DataJpaTest` only scans for Spring Data JPA repositories.
- **Testing logic-level classes in isolation using the Mockito framework**. I learned the importance of using mock dependencies to test business logic code in a controlled environment (i.e., without interference from data access dependencies).
- **Spring Annotations**:
  - Fundamental annotations such as `@SpringBootApplication`, `@Component`, and `@Autowired`
  - Functionality-related annotations such as `@Service`, `@Repository`, and `@Transactional`
  - JPA mapping annotations such as `@Entity`, `@Table`, `@GeneratedValue`, and `@Column`
  - Test-related annotations such as `@DataJpaTest`, `@Mock`, and `@InjectMocks`

## Contact:
Christal Dita | [LinkedIn](https://www.linkedin.com/in/cdita/) 

## References:

I used the following resources to guide my learning:
- [Chad Darby's Spring Boot 3, Spring 6 & Hibernate for Beginners course on Udemy](https://www.udemy.com/course/spring-hibernate-tutorial/?couponCode=KEEPLEARNING)
- [What is Java Spring Boot? on IBM](https://www.ibm.com/think/topics/java-spring-boot)
- [Using the @SpringBootApplication Annotation on Spring docs](https://docs.spring.io/spring-boot/docs/2.0.x/reference/html/using-boot-using-springbootapplication-annotation.html)
- [Difference between controller, service, and manager by Patricio Garcia on Medium](https://medium.com/zbytes/difference-between-controller-service-and-manager-b76762d1ba6b)
- [Spring Boot - Database Integration (JPA, Hibernate, MySQL, H2) by Mahesh K on GeeksforGeeks](https://www.geeksforgeeks.org/advance-java/spring-boot-database-integration-jpa-hibernate-mysql-h2/)
- [Using @Autowired and @InjectMocks in Spring Boot Tests by Abhinav Pandey on Baeldung](https://www.baeldung.com/spring-test-autowired-injectmocks)
- [Mockito.mock() vs @Mock vs @MockBean by baeldung on Baeldung](https://www.baeldung.com/java-spring-mockito-mock-mockbean)
- [@DataJpaTest and Repository Class in JUnit by Wynn Teo on Baeldung](https://www.baeldung.com/junit-datajpatest-repository)
- [Annotation Interface DataJpaTest on Spring docs](https://docs.spring.io/spring-boot/api/java/org/springframework/boot/test/autoconfigure/orm/jpa/DataJpaTest.html)
- [Spring @Import Annotation by Gilvan Ornelas on Baeldung](https://www.baeldung.com/spring-import-annotation)
- [Annotation Interface Repository on Spring docs](https://docs.spring.io/spring-framework/docs/current/javadoc-api/org/springframework/stereotype/Repository.html)
- [Spring @Service Annotation by Pankaj Kumar on DigitalOcean](https://www.digitalocean.com/community/tutorials/spring-service-annotation)
