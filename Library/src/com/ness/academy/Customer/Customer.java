package com.ness.academy.Customer;

import com.ness.academy.Book.Book;
import com.ness.academy.Validation.InputValidation;

import java.util.HashMap;
import java.util.Map;

public class Customer implements InputValidation {

    private final int MAX_CAPACITY = 3;
    private final String firstName;
    private final String lastName;
    private Address customerAddress;
    private final HashMap<Integer, Book> customerBookCapacity;

    public Customer() {
        this.firstName = stringValidInput("Enter first name of the customer: ");
        this.lastName = stringValidInput("Enter last name of the customer: ");
        this.customerAddress = new Address();
        this.customerBookCapacity = new HashMap<>(MAX_CAPACITY);
    }

    public Customer(String firstName, String lastName, Address customerAddress) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.customerAddress = customerAddress;
        this.customerBookCapacity = new HashMap<>(MAX_CAPACITY);
    }

    public int getMAX_CAPACITY() {
        return MAX_CAPACITY;
    }

    public void addBookToBookCapacity(Integer bookId, Book book) {
        this.customerBookCapacity.put(bookId, book);
    }

    public void removeBookFromCapacity(Integer bookId, Book book) {
        if (!this.customerBookCapacity.isEmpty()) {
            this.customerBookCapacity.remove(bookId, book);
        } else {
            System.out.println("~~~Customer doesn't have any books.~~~");
        }
    }

    public HashMap<Integer, Book> getCustomerBookCapacity() {
        return customerBookCapacity;
    }

    public void setCustomerAddress(Address customerAddress) {
        this.customerAddress = customerAddress;
    }

    public Address getCustomerAddress() {
        return this.customerAddress;
    }

    public String getFirstName() {
        return this.firstName;
    }

    public String getLastName() {
        return this.lastName;
    }

    public String showBorrowingBooks(HashMap<Integer, Book> customerBookCapacity) {
        if (customerBookCapacity.isEmpty()) {
            return "Customer is not borrowing any book.";
        }
        String output = "<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<";
        for (Map.Entry<Integer, Book> entry : customerBookCapacity.entrySet()) {
            output += "\n~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~\n" +
                    "Book ID = " + entry.getKey() +
                    "\n" + entry.getValue().toString();
        }
        output += "\n>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>";
        return output;
    }

    @Override
    public String toString() {
        return
                "First Name: " + firstName + ", Last Name: " + lastName + "\n" +
                        "Customer " + customerAddress + "\n" +
                        "Is borrowing : \n" + showBorrowingBooks(customerBookCapacity) + "\n";
    }

    public String showCustomerBasicInfo(){
        return
                "First Name: " + firstName + ", Last Name: " + lastName + "\n" +
                        "Customer " + customerAddress + "\n" ;
    }
}
