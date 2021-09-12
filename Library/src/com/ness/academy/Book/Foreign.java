package com.ness.academy.Book;

public class Foreign extends Book {

    public Foreign() {
        super.setType("Foreign");
        String bookLanguage = stringValidInput("Enter foreign book language: ");
    }
}
