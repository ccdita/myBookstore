package com.ccdita.myBookstore.entities;

/**
 * Represents a Book object; stores information about each book
 */
public class Book {

    private int id;
    private String title;
    private String author;
    private String genre;
    private double price;
    private boolean forSale;

    /**
     * No-arg constructor as required by a Spring entity class
     */
    public Book() {}

    /**
     * Constructs a Book object with the given title, author, and genre
     * Initializes the forSale field to true to indicate that the book is up for sale
     * @param title of book
     * @param author of book
     * @param genre of book
     */
    public Book(String title, String author, String genre) {
        this.title = title;
        this.author = author;
        this.genre = genre;
        this.price = 10.00;
        this.forSale = true;
    }

    /**
     * Returns the book's title
     * @return title of book
     */
    public String getTitle() {
        return this.title;
    }

    /**
     * Returns the book's author
     * @return author of book
     */
    public String getAuthor() {
        return this.author;
    }

    /**
     * Returns the book's genre
     * @return genre of book
     */
    public String getGenre() {
        return this.genre;
    }

    /**
     * Returns the book's price
     * @return price of book
     */
    public double getPrice() {
        return this.price;
    }

    /**
     * Returns whether the book is on sale or has already been sold
     * @return true if the book is on sale, otherwise false
     */
    public boolean getStatus() {
        return this.forSale;
    }

    /**
     * Sets the book's status depending on whether it is on sale or has been sold
     * @param forSale, true if the book is on sale, otherwise false
     */
    public void setStatus(boolean forSale) {
        this.forSale = forSale;
    }

    /**
     * Returns a String representation of the Book object, which includes its title, author, genre, price, and status
     * @return a String representation of the Book object
     */
    @Override
    public String toString() {
        // Format the book's price to 2 decimal places, then convert to String
        String formattedPrice = String.format("%.2f", this.price);

        String bookInfo = "Book:\n" +
                "Title: " + this.title + "\n" +
                "Author: " + this.author + "\n" +
                "Genre: " + this.genre + "\n" +
                "Price: $" + formattedPrice + "\n" +
                "For Sale? " + this.forSale;

        return bookInfo;
    }
}
