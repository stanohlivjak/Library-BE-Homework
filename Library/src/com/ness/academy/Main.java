package com.ness.academy;

import com.ness.academy.Book.Book;
import com.ness.academy.BorrowingSystem.BorrowingSystem;
import com.ness.academy.Customer.Address;
import com.ness.academy.Customer.Customer;
import com.ness.academy.Library.Library;

import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        System.out.println("//**Welcome to library**//");
        Library library = new Library();
        BorrowingSystem system = new BorrowingSystem(library.getBookshelf(), library.getCustomershelf());
        Customer newCustomer = new Customer("Stanislav", "Hlivjak", new Address("jana svermu", 6, "bardejov", "slovakia"));
        Customer newCustomer2 = new Customer("peter", "marcin", new Address("kosicka", 49, "bratislava", "slovakia"));
        library.addCustomerToSystem(newCustomer);
        library.addCustomerToSystem(newCustomer2);
        Book newBook = new Book("Harry Potter", "J.K. Rowling", 547, "Standard");
        Book newBook2 = new Book("jozo procko", "jozo procko", 333, "Scientific");
        Book newBook3 = new Book("Harry Potter", "J.K. Rowling", 547, "Standard");
        Book newBook4 = new Book("jozo procko", "jozo procko", 333, "Scientific");
        library.addBookToSystem(newBook);
        library.addBookToSystem(newBook2);
        library.addBookToSystem(newBook3);
        library.addBookToSystem(newBook4);
        Scanner sc = new Scanner(System.in);
        boolean onGoing = true;
        while (onGoing) {
            onGoing = navigate(system, library, sc);
        }
    }

    public static boolean navigate(BorrowingSystem system, Library library, Scanner sc) {
        System.out.print("""
                ******************************************\s
                0 - Exit application \s
                1 - Create customer \s
                2 - Create book \s
                3 - Show customers \s
                4 - Show all books in library \s
                5 - Show borrowed books \s
                6 - Show not borrowed books \s
                7 - Borrow book \s
                8 - Return book  \s
                9 - Change customer address \s
                ******************************************\s
                Enter action: \s""");
        switch (sc.nextInt()) {
            case 0 -> {
                return false;
            }
            case 1 -> library.addCustomerToSystem();
            case 2 -> library.addBookToSystem();
            case 3 -> library.showCustomers();
            case 4 -> library.showBooks();
            case 5 -> {
                system.showBorrowedBooks();
            }
            case 6 -> {
                system.showNotBorrowedBooks();

            }
            case 7 -> {
                system.borrowBook(library);

            }
            case 8 -> {
                system.returnBook();

            }
            case 9 ->{
                library.changeCustomerAddress();
            }
        }
        return true;
    }
}
