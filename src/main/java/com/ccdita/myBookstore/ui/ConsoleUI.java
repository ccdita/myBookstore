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
        menuUI.displayMainMenu();
        userInput.getUserOption(MAIN_MENU_OPTIONS, scanner);

        scanner.close();
    }
}
