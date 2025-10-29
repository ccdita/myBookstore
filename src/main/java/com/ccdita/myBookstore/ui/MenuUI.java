package com.ccdita.myBookstore.ui;

import org.springframework.stereotype.Component;

/**
 * Displays different menus
 */
@Component
public class MenuUI {

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
}
