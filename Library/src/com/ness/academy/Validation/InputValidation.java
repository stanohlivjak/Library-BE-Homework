package com.ness.academy.Validation;

import com.ness.academy.Book.Book;
import com.ness.academy.Book.Foreign;
import com.ness.academy.Book.Scientific;

import java.util.Objects;
import java.util.Scanner;

public interface InputValidation {
    Scanner scanner = new Scanner(System.in);

    default String stringValidInput(String string2) {
        System.out.print(string2);
        String string = scanner.nextLine();
        while (Objects.equals(string, "") || Objects.equals(string, " ") || string.matches(".*\\d.*")){
            System.out.print("Please enter correct data input: ");
            string = scanner.nextLine();
        }
        return string;
    }

    default int intValidInput(String string2) {
        System.out.print(string2);
        int number = Integer.parseInt(scanner.nextLine());
        while (number<=0) {
            System.out.print("Please enter correct number: ");
            number = Integer.parseInt(scanner.nextLine());
        }
        return number;
    }

    default Book validBookType(String string2) {
        System.out.print(string2);
        int number = Integer.parseInt(scanner.nextLine());
        while (number != 1 && number != 2 && number != 3) {
            System.out.print("Please enter valid book type (1 - Standard, 2 - Scientific, 3 - Foreign):");
            number = Integer.parseInt(scanner.nextLine());
        }
        Book newBook = null;
        switch (number) {
            case 1 -> newBook = new Book();
            case 2 -> newBook = new Scientific();
            case 3 -> newBook = new Foreign();
        }
        return newBook;
    }
}
