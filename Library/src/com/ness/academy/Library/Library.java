package com.ness.academy.Library;

import com.ness.academy.Book.Book;
import com.ness.academy.Customer.Address;
import com.ness.academy.Customer.Customer;
import com.ness.academy.Styling.ConsoleColors;
import com.ness.academy.Styling.Printing;
import com.ness.academy.Validation.InputValidation;

import java.util.HashMap;
import java.util.Map;

public class Library implements InputValidation, Printing {
    private final HashMap<Integer, Book> bookshelf;
    private final HashMap<Integer, Customer> customershelf;

    public Library() {
        this.bookshelf = new HashMap<>();
        this.customershelf = new HashMap<>();
    }

    public HashMap<Integer, Book> getBookshelf() {
        return bookshelf;
    }

    public HashMap<Integer, Customer> getCustomershelf() {
        return customershelf;
    }

    private Integer numberOfBooks = 0;
    private Integer numberOfCustomers = 0;

    public void addBookToSystem() {
        numberOfBooks++;
        Book newBook = validBookType("Enter what type of the book (1 - Standard, 2 - Scientific, 3 - Foreign) do you want to add: ");
        bookshelf.put(numberOfBooks, newBook);
        System.out.println("Book successfully added to bookshelf");
    }

    public void addBookToSystem(Book book) {
        numberOfBooks++;
        bookshelf.put(numberOfBooks, book);
        System.out.println("Book successfully added to bookshelf");
    }


    public void addCustomerToSystem() {
        numberOfCustomers++;
        Customer newCustomer = new Customer();
        customershelf.put(numberOfCustomers, newCustomer);
        System.out.println("Customer successfully added to customershelf");
    }

    public void addCustomerToSystem(Customer customer) {
        numberOfCustomers++;
        customershelf.put(numberOfCustomers, customer);
        System.out.println("Customer successfully added to customershelf");
    }

    public void changeCustomerAddress() {
        showCustomers();
        Integer customerId = intValidInput("Enters customer id to change his address: ");
        System.out.println("Old address: \n" + customershelf.get(customerId).getCustomerAddress());
        customershelf.get(customerId).setCustomerAddress(new Address());
        System.out.println("New address: \n" + customershelf.get(customerId).getCustomerAddress());
    }

    public void showCustomers() {
        if (customershelf.size() < 1) {
            print("No customers are currently in library right now.");
            return;
        }
        for (Map.Entry<Integer, Customer> entry : customershelf.entrySet())
            System.out.println("''''''''''''''''''''''''''''''''''''''''''''''''''\n" +
                    "Customer ID = " + entry.getKey() +
                    "\n" + entry.getValue() +
                    "''''''''''''''''''''''''''''''''''''''''''''''''''\n");
    }



    public void showBooks() {
        if (bookshelf.size() < 1) {
            print("No books are are available for borrow right now.");
            return;
        }
        for (Map.Entry<Integer, Book> entry : bookshelf.entrySet()) {
            if (entry.getValue().getBorrowed()) {
                System.out.print(ConsoleColors.RED);
            }
            else System.out.print(ConsoleColors.RESET);
            System.out.println("\n--------------------------------------------------\n" +
                    "Book ID = " + entry.getKey() +
                    "\n" + entry.getValue() + "\n"
                    + "--------------------------------------------------");
        }
        System.out.println();
    }
}