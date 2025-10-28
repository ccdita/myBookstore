package com.ccdita.myBookstore;

import com.ccdita.myBookstore.datamanagement.BookDAO;
import com.ccdita.myBookstore.datamanagement.UserDAO;
import com.ccdita.myBookstore.processor.BookManager;
import com.ccdita.myBookstore.processor.UserManager;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
public class MyBookstoreApplication {

    private UserManager userManager;
    private BookManager bookManager;

    /**
     * Constructs a MyBookstoreApplication instance
     * @param userManager, implementation of UserManager
     * @param bookManager, implementation of BookManager
     */
    @Autowired // Constructor injection
    public MyBookstoreApplication(UserManager userManager, BookManager bookManager) {
        this.userManager = userManager;
        this.bookManager = bookManager;
    }

    /**
     * Bootstrap and launch Spring Boot application
     * @param args from command line
     */
	public static void main(String[] args) {
		SpringApplication.run(MyBookstoreApplication.class, args);
	}

    /**
     * Run code after the Spring context has been initialized
     * @param userDAO, implementation of UserDAO interface
     * @param bookDAO, implementation of BookDAO interface
     * @return
     */
    @Bean // Run bean after application context is ready
    public CommandLineRunner commandLineRunner(UserDAO userDAO, BookDAO bookDAO) {
        return runner -> {
            userManager.createUser(userDAO, "testUser", "testPass");
            bookManager.addBook(bookDAO, "testTitle", "testAuthor", "testGenre");
        };
    }
}
