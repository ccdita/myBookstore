package com.ccdita.myBookstore;

import com.ccdita.myBookstore.datamanagement.UserDAO;
import com.ccdita.myBookstore.processor.UserManager;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
public class MyBookstoreApplication {

    private UserManager userManager;

    /**
     * Constructs a MyBookstoreApplication instance
     * @param userManager, implementation of UserManager
     */
    @Autowired // Constructor injection
    public MyBookstoreApplication(UserManager userManager) {
        this.userManager = userManager;
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
     * @param userDAO
     * @return
     */
    @Bean // Run bean after application context is reader
    public CommandLineRunner commandLineRunner(UserDAO userDAO) {
        return runner -> {
            userManager.createUser(userDAO, "testUser", "testPass");
        };
    }
}
