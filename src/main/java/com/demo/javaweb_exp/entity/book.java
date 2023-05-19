package com.demo.javaweb_exp.entity;

/**
 *JavaBean--book
 */
public class book {
    private String bookid;
    private String title;
    private String author;
    private String publisher;
    private Double price;

    public book(String bookid, String title, String author, String publisher, Double price) {
        this.bookid = bookid;
        this.title = title;
        this.author = author;
        this.publisher = publisher;
        this.price = price;
    }

    public String getBookid() {
        return bookid;
    }

    public void setBookid(String bookid) {
        this.bookid = bookid;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getAuthor() {
        return author;
    }

    public void setAuthor(String author) {
        this.author = author;
    }

    public String getPublisher() {
        return publisher;
    }

    public void setPublisher(String publisher) {
        this.publisher = publisher;
    }

    public Double getPrice() {
        return price;
    }

    public void setPrice(Double price) {
        this.price = price;
    }
}
