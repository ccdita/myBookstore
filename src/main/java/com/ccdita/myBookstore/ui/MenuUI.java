package com.ccdita.myBookstore.ui;

import org.springframework.stereotype.Component;

@Component
public class MenuUI {

    public void displayMainMenu() {
        System.out.println("Welcome to myBookstore!");
        System.out.println("==========");
        System.out.println("1. Log in");
        System.out.println("2. Create an account");
        System.out.println("==========");
    }
}
