package com.ness.academy.Book;

public class Scientific extends Book {

    public Scientific() {
        super.setType("Scientific");
        String scientificField = stringValidInput("Enter scientific field: ");
    }
}
