package com.ness.academy.Styling;

public interface Printing {
    default void print(String string){
        System.out.println(
                "\n--------------------------------------------------\n" +
                        "***"+string+"***\n"+
                        "--------------------------------------------------\n"
        );
    }
}
