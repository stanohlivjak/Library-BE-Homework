package com.ness.academy.BorrowingSystem;

import com.ness.academy.Book.Book;
import com.ness.academy.Customer.Customer;
import com.ness.academy.Library.Library;
import com.ness.academy.Styling.Printing;
import com.ness.academy.Validation.InputValidation;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.HashMap;
import java.util.Map;

public class BorrowingSystem implements InputValidation, Printing {

    private final HashMap<Integer, Book> bookSelf;
    private final HashMap<Integer, Customer> customerSelf;
    private final HashMap<Integer, Book> borrowedBooks;
    private final HashMap<Integer, String> booksBorrowData;
    private final HashMap<Integer, Integer> bookToCustomerID;
    private final HashMap<Integer, Integer> cutomerToBookID;

    public BorrowingSystem(HashMap<Integer, Book> bookSelf, HashMap<Integer, Customer> customerSelf) {
        this.bookSelf = bookSelf;
        this.customerSelf = customerSelf;
        this.booksBorrowData = new HashMap<>();
        this.borrowedBooks = new HashMap<>();
        this.bookToCustomerID = new HashMap<>();
        this.cutomerToBookID = new HashMap<>();
    }

    DateTimeFormatter dtf = DateTimeFormatter.ofPattern("yyyy/MM/dd HH:mm:ss");

    public void borrowBook(Library library) {
        if (bookSelf.size() < 1) {
            print("No books are available for borrow right now.");
            return;
        }
        showNotBorrowedBooks();
        LocalDateTime now = LocalDateTime.now();
        Integer bookId = intValidInput("Enter books id: ");
        library.showCustomers();
        Integer customerId = intValidInput("Enter customer id: ");
        Customer customer = customerSelf.get(customerId);
        if(!(customer.getCustomerBookCapacity().size() < customer.getMAX_CAPACITY())){
            print("Customer can't borrow more books.");
            return;
        }
        bookToCustomerID.put(bookId, customerId);
        cutomerToBookID.put(customerId,bookId);
        booksBorrowData.put(customerId, dtf.format(now));
        customer.addBookToBookCapacity(bookId, bookSelf.get(bookId));
        bookSelf.get(bookId).setBorrowed(true);
        bookSelf.get(bookId).setBorrowedDate(dtf.format(now));
        borrowedBooks.put(customerId, bookSelf.get(bookId));
        System.out.println("Book: " + bookSelf.get(bookId).getNameOfBook() + " was borrowed by : " + customer.getFirstName() + " " + customer.getLastName());
    }

    public void returnBook() {
        if (borrowedBooks.size() < 1) {
            print("No customer has borrow any book yet.");
            return;
        }
        showBorrowedBooks();
        Integer bookId = intValidInput("Enter books id: ");
        Integer customerId = bookToCustomerID.get(bookId);
        LocalDateTime now = LocalDateTime.now();
        booksBorrowData.put(customerId, dtf.format(now));
        Customer customer = customerSelf.get(customerId);
        bookSelf.put(bookId, borrowedBooks.get(customerId));
        showBorrowedBooks();
        bookSelf.get(bookId).setBorrowed(false);
        bookSelf.get(bookId).setReturnedDate(dtf.format(now));
        borrowedBooks.remove(customerId);
        System.out.println("Book: " + bookSelf.get(bookId).getNameOfBook() + " was returned from customer : " + customer.getFirstName() + " " + customer.getLastName());
        customer.removeBookFromCapacity(bookId, customer.getCustomerBookCapacity().get(bookId));
    }

    public void showBorrowedBooks() {
        if (borrowedBooks.size() < 1) {
            print("No books are currently borrowed by any customer.");
            return;
        }

        for (Map.Entry<Integer, Book> entry : borrowedBooks.entrySet()) {
            System.out.println("--------------------------------------------------\n" +
                    "Customer : \n" + customerSelf.get(entry.getKey()).getFirstName() + " " +
                    customerSelf.get(entry.getKey()).getLastName() +
                    "\nIs borrowing book named:\n" + entry.getValue().getNameOfBook() + "\n" +
                    "Book ID: " + cutomerToBookID.get(entry.getKey()) +
                    " Started borrowing on: " + booksBorrowData.get(entry.getKey())
                    + "\n--------------------------------------------------\n");
        }
    }

    public void showNotBorrowedBooks() {
        for (Map.Entry<Integer, Book> entry : bookSelf.entrySet())
            if (!entry.getValue().getBorrowed()) {
                System.out.println("\n--------------------------------------------------\n" +
                        "Book ID = " + entry.getKey() +
                        "\n" + entry.getValue().toString() + "\n"
                        + "--------------------------------------------------");
            }
        System.out.println();
    }

}
