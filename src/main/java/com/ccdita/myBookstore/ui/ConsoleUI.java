package com.ccdita.myBookstore.ui;

import com.ccdita.myBookstore.datamanagement.entities.User;
import com.ccdita.myBookstore.util.UserInput;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.Scanner;

/**
 * Main UI class; coordinates UI flow based on user input
 */
@Component
public class ConsoleUI {

    Scanner scanner = new Scanner(System.in);

    private MenuUI menuUI;
    private LoginRegisterUI loginRegisterUI;
    private BooksUI booksUI;
    private UserInput userInput;

    /**
     * Construct a ConsoleUI instance with constructor injection
     * @param menuUI, instance of MenuUI
     * @param loginRegisterUI, instance of LoginRegisterUI
     * @param booksUI, instance of BooksUI
     * @param userInput, instance of UserInput
     */
    @Autowired
    public ConsoleUI(MenuUI menuUI, LoginRegisterUI loginRegisterUI, BooksUI booksUI, UserInput userInput) {
        this.menuUI = menuUI;
        this.loginRegisterUI = loginRegisterUI;
        this.booksUI = booksUI;
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
            int userOption = userInput.getUserOption(menuUI.getMainMenuOptions(), scanner);

            User loggedInUser = null;
            boolean isUserRegistered = false;
            switch(userOption) {
                // ===== LOG IN =====
                case 1:
                    printHeader("LOG IN");
                    loggedInUser = loginRegisterUI.loginUser(scanner);
                    break;
                // ===== CREATE AN ACCOUNT =====
                case 2:
                    printHeader("CREATE AN ACCOUNT");
                    isUserRegistered = loginRegisterUI.registerUser(scanner);
                    // If the user successfully registers an account, redirect them to the main menu
                    if (isUserRegistered) { continue; }
                    break;
                // ===== EXIT THE APPLICATION =====
                case 0:
                    isRunning = false;
                    continue;
            }

            // ===== LOGIN SESSION =====
            while (loggedInUser != null) {
                printHeader("Welcome " + loggedInUser.getUsername() + "!");
                menuUI.displayUserMenu();
                userOption = userInput.getUserOption(menuUI.getUserMenuOptions(), scanner);

                switch (userOption) {
                    // ===== BUY BOOKS =====
                    case 1:
                        printHeader("BUY BOOKS");
                        booksUI.buyBook(scanner, loggedInUser);
                        break;
                    // ===== SELL BOOKS =====
                    case 2:
                        printHeader("SELL BOOKS");
                        break;
                    // ===== LOG OUT =====
                    case 0:
                        loggedInUser = null;
                }
            }
        }
        scanner.close();
        System.out.println("See you next time!");
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
