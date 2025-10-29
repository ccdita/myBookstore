package com.ccdita.myBookstore.ui;

import com.ccdita.myBookstore.util.UserInput;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.Scanner;

/**
 * Main UI class; coordinates UI flow based on user input
 */
@Component
public class ConsoleUI {

    // Number of options
    private static final int MAIN_MENU_OPTIONS = 3;

    Scanner scanner = new Scanner(System.in);

    private MenuUI menuUI;
    private UserInput userInput;

    /**
     * Construct a ConsoleUI instance with constructor injection
     * @param menuUI
     * @param userInput
     */
    @Autowired
    public ConsoleUI(MenuUI menuUI, UserInput userInput) {
        this.menuUI = menuUI;
        this.userInput = userInput;
    }

    /**
     * Displays output to the console
     * Directs which UI components to call based on user input
     */
    public void start() {

        boolean isRunning = true; // Dictates whether the application is running or not
        while (isRunning) {
            // ===== MAIN MENU =====
            printHeader("MYBOOKSTORE");
            menuUI.displayMainMenu();
            int userOption = userInput.getUserOption(MAIN_MENU_OPTIONS, scanner);

            String username = null;
            String password = null;
            switch(userOption) {
                case 1: // If the user chooses to log in
                    printHeader("LOG IN");
                    username = userInput.getUserString("Username:", scanner);
                    password = userInput.getUserString("Password:", scanner);
                    break;
                case 2: // If the user chooses to create an account
                    printHeader("CREATE AN ACCOUNT");
                    username = userInput.getUserString("Username:", scanner);
                    password = userInput.getUserString("Password", scanner);
                case 3: // Exit the application
                    isRunning = false;
                    continue;
            }
        }
        scanner.close();
    }

    /**
     * Helper method for printing out a header
     * @param title to put in header
     */
    public void printHeader(String title) {
        System.out.println("==========");
        System.out.println(title);
        System.out.println("==========");
    }
}
