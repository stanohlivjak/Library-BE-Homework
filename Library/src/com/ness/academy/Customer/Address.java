package com.ness.academy.Customer;

import com.ness.academy.Validation.InputValidation;

import java.util.Scanner;

public class Address implements InputValidation {

    private String streetName;
    private Integer streetNumber;
    private String city;
    private String country;

    public Address() {
        this.streetName = stringValidInput("Enter customers street name: ");
        this.streetNumber = intValidInput("Enter customers street number: ");
        this.city =stringValidInput("Enter customers city: ");
        this.country = stringValidInput("Enter customers country: ");
    }

    public Address(String streetName, Integer streetNumber, String city, String country) {
        this.streetName = streetName;
        this.streetNumber = streetNumber;
        this.city = city;
        this.country = country;
    }

    @Override
    public String toString() {
        return "Address:\n"+
                "Street name: " + streetName + ", street number: " + streetNumber +"\n"+
                "City: " + city + ", Country: " + country;
    }
}
