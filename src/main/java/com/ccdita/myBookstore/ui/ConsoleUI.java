package com.ccdita.myBookstore.ui;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

/**
 * Main UI class; coordinates UI flow based on user input
 */
@Component
public class ConsoleUI {

    private MenuUI menuUI;

    /**
     * Construct a ConsoleUI instance with constructor injection
     * @param menuUI
     */
    @Autowired
    public ConsoleUI(MenuUI menuUI) {
        this.menuUI = menuUI;
    }

    /**
     * Displays output to the console
     * Directs which UI components to call based on user input
     */
    public void start() {
    }
}
