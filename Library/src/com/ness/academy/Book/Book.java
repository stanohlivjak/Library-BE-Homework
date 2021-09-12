package com.ness.academy.Book;

import com.ness.academy.Validation.InputValidation;

public class Book implements InputValidation {
    private final String nameOfBook;
    private final String author;
    private final Integer numberOfPage;
    private Boolean borrowed;
    private String type;
    private String borrowedDate;
    private String returnedDate;

    public Book() {
        this.nameOfBook = stringValidInput("Enter name of the book: ");
        this.author = stringValidInput("Enter author of the book: ");
        this.numberOfPage = intValidInput("Enter number of pages: ");
        this.borrowed = false;
        this.type = "Standard";
        this.borrowedDate = "Book was not borrowed yet.";
        this.returnedDate = "Book was not borrowed yet.";
    }

    public Book(String nameOfBook, String author, Integer numberOfPage, String type) {
        this.nameOfBook = nameOfBook;
        this.author = author;
        this.numberOfPage = numberOfPage;
        this.type = type;
        this.borrowed = false;
        this.borrowedDate = "Book was not borrowed yet.";
        this.returnedDate = "Book was not returned yet.";
    }

    public void setType(String type) {
        this.type = type;
    }

    @Override
    public String toString() {
        return
                "Name: " + nameOfBook + "\n" +
                        "Author: " + author + ", number of pages: " + numberOfPage + "\n" +
                        "Is borrowed: " + borrowed + ", book type: " + type + "\n"+
                        "Borrowed on: " + borrowedDate + " Returned on: " + returnedDate;
    }

    public void setBorrowed(Boolean borrowed) {
        this.borrowed = borrowed;
    }

    public Boolean getBorrowed() {
        return this.borrowed;
    }

    public String getBorrowedDate() {
        return borrowedDate;
    }

    public void setBorrowedDate(String borrowedDate) {
        this.borrowedDate = borrowedDate;
    }

    public String getReturnedDate() {
        return returnedDate;
    }

    public void setReturnedDate(String returnedDate) {
        this.returnedDate = returnedDate;
    }

    public String getNameOfBook() {
        return nameOfBook;
    }
}
