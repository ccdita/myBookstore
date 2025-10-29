package com.ccdita.myBookstore;

import com.ccdita.myBookstore.ui.ConsoleUI;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

/**
 * Start the application once Spring has initialized the application context and prepared all beans
 */
@Component
public class BookstoreCLApp implements CommandLineRunner {

    private ConsoleUI consoleUI;

    /**
     * Construct a BookstoreCLApp instance with constructor injection
     * @param consoleUI, instance of ConsoleUI which manages UI flow based on user input
     */
    @Autowired
    public BookstoreCLApp(ConsoleUI consoleUI) {
        this.consoleUI = consoleUI;
    }

    /**
     * Run main user interaction flow
     * Since this class is a component, Spring will run this method
     * @param args passed into method
     * @throws Exception
     */
    @Override
    public void run(String... args) throws Exception {
        consoleUI.start(); // Start the main UI flow
    }
}
