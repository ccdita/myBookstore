package com.ccdita.myBookstore.datamanagement.entities;

import jakarta.persistence.*;

import java.util.ArrayList;

/**
 * Represents User objects; stores information about each user
 */
@Entity // Mark this class as an entity class
@Table(name="users") // Map the entity class to the mySQL "user" table
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
     * Returns the user's ID
     * @return id of user
     */
    public int getId() {
        return this.id;
    }

    /**
     * Returns the user's username
     * @return username of user
     */
    public String getUsername() {
        return this.username;
    }

    /**
     * Returns the user's password
     * @return password of user
     */
    public String getPassword() { return this.password; }

    /**
     * Returns the user's ReaderCash amount
     * @return readerCash amount of user
     */
    public double getReaderCash() {
        return this.readerCash;
    }

    /**
     * Checks if the given User object matches an existing user in the database
     * Prevents duplicate users (based on the username) from being made
     * @param o   the reference object with which to compare.
     * @return true if the given User matches an existing user in the database, otherwise false
     */
    @Override
    public boolean equals(Object o) {
        User otherUser = (User) o;
        return this.username.equals(otherUser.getUsername());
    }
}
