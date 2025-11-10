package com.ccdita.myBookstore.ui;

import org.springframework.stereotype.Component;

/**
 * Displays different menus
 */
@Component
public class MenuUI {

    // Number of options
    private static final int MAIN_MENU_OPTIONS = 3;
    private static final int USER_MENU_OPTIONS = 3;

    /**
     * Display the main menu (when user first starts the application)
     */
    public void displayMainMenu() {
        System.out.println("Welcome to myBookstore!");
        System.out.println("----------");
        System.out.println("1. Log in");
        System.out.println("2. Create an account");
        System.out.println("3. Exit");
        System.out.println("----------");
    }

    /**
     * Display the user menu (when user logs in)
     */
    public void displayUserMenu() {
        System.out.println("----------");
        System.out.println("1. Buy books");
        System.out.println("2. Sell books");
        System.out.println("3. Log out");
        System.out.println("----------");
    }

    /**
     * Returns the number of main menu options
     * @return number of main menu options
     */
    public int getMainMenuOptions() {
        return MAIN_MENU_OPTIONS;
    }

    /**
     * Returns the number of user menu options
     * @return number of user menu options
     */
    public int getUserMenuOptions() {
        return USER_MENU_OPTIONS;
    }
}
