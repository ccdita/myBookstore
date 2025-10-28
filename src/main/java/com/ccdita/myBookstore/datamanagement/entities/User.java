package com.ccdita.myBookstore.datamanagement.entities;

import jakarta.persistence.*;

import java.util.ArrayList;

// TODO: Add and test getPassword() method?
/**
 * Represents User objects; stores information about each user
 */
@Entity // Mark this class as an entity class
@Table(name="user") // Map the entity class to the mySQL "user" table
public class User {

    @Id // ID will serve as the primary key for the user table
    @GeneratedValue(strategy= GenerationType.IDENTITY) // mySQL will handle auto-incrementing of the ID
    @Column(name="id") // Map fields to mySQL table columns with the specified name
    private int id;

    @Column(name="username")
    private String username;

    @Column(name="password")
    private String password;

    @Column(name="readercash")
    private double readerCash;

    /**
     * Public no-argument constructor as required by a Spring entity class
     */
    public User() {}

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
}
