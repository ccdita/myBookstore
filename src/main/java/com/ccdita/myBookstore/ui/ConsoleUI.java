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
    private LoginRegisterUI loginRegisterUI;
    private UserInput userInput;

    /**
     * Construct a ConsoleUI instance with constructor injection
     * @param menuUI
     * @param loginRegisterUI
     * @param userInput
     */
    @Autowired
    public ConsoleUI(MenuUI menuUI, LoginRegisterUI loginRegisterUI, UserInput userInput) {
        this.menuUI = menuUI;
        this.loginRegisterUI = loginRegisterUI;
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
            menuUI.displayMainMenu();
            int userOption = userInput.getUserOption(MAIN_MENU_OPTIONS, scanner);

            switch(userOption) {
                case 1: // If the user chooses to log in
                    loginRegisterUI.displayLoginUI();
                    String username = userInput.getUserString("Username:", scanner);
                    String password = userInput.getUserString("Password:", scanner);
                    break;
                case 3: // Exit the application
                    isRunning = false;
                    continue;
            }
        }
        scanner.close();
    }
}
