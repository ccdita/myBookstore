package com.ccdita.myBookstore.ui;

import com.ccdita.myBookstore.util.UserInput;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

/**
 * Displays UI for logging in and creating an account
 */
@Component
public class LoginRegisterUI {

    /**
     * Displays login UI
     */
    public void displayLoginUI() {
        System.out.println("==========");
        System.out.println("LOG IN");
        System.out.println("==========");
    }
}
