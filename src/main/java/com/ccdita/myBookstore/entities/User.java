package com.ccdita.myBookstore.entities;

import java.util.ArrayList;

// TODO: Add and test getPassword() method?
/**
 * Represents User objects; stores information about each user
 */
public class User {

    private int id;
    private String username;
    private String password;
    private double readerCash;
    private ArrayList<Book> booksPurchased;
    private ArrayList<Book> booksSold;

    /**
     * No-argument constructor as required by a Spring entity class
     */
    private User() {}

    /**
     * Constructs a User object with the given username and password
     * Initializes the readerCash field to $0.00
     * @param username of user
     * @param password of user
     */
    public User(String username, String password) {
        this.username = username;
        this.password = password;
        this.readerCash = 0.00;
        this.booksPurchased = new ArrayList<>();
        this.booksSold = new ArrayList<>();
    }

    /**
     * Returns the user's username
     * @return username of user
     */
    public String getUsername() {
        return this.username;
    }

    /**
     * Returns the user's ReaderCash amount
     * @return readerCash amount of user
     */
    public double getReaderCash() {
        return this.readerCash;
    }

    /**
     * Returns a list of books the user has purchased
     * @return booksPurchased by the user
     */
    public ArrayList<Book> getBooksPurchased() {
        return this.booksPurchased;
    }

    /**
     * Returns a list of books the user has sold
     * @return booksSold by the user
     */
    public ArrayList<Book> getBooksSold() {
        return this.booksSold;
    }
}
