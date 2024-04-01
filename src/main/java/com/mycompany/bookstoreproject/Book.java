package com.mycompany.bookstoreproject;

public class Book {

    private String isbn;
    private String title;
    private String author;
    private double price;

    public Book() {
        isbn = null;
        title = null;
        author = null;
        price = 0.0;
    }

    public Book(String isbn, String title, String author, double price) {
        this.isbn = isbn;
        this.title  = title;
        this.author = author;
        this.price = price;
    }

    public void setIsbn(String x) {
        isbn = x;
    }

    public void setTitle(String x) {
        title = x;
    }

    public void setAuthor(String x) {
        author = x;
    }

    public void setPrice(double x) {
        price = x;
    }

    public String getIsbn() {
        return isbn;
    }

    public String getTitle() {
        return title;
    }

    public String getAuthor() {
        return author;
    }

    public double getPrice() {
        return price;
    }

    public String toString() {
        String p = String.format("%.2f", price);
        String info = "The book with title : " + getTitle() + " written by : "
                + getAuthor() + " with price : " + getPrice() + " has the ISBN : " + getIsbn();
        return info;
    }

}
