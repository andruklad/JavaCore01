package com.shop.console.utils;

import java.util.Scanner;

public class Input {
    private static final Scanner scn = new Scanner(System.in);

    public static String getStringFromKeyboard(String text) {
        System.out.println(text);
        return scn.next();
    }

    public static Double getDoubleFromKeyboard(String text) {
        System.out.println(text);
        while (!scn.hasNextDouble()) {
            System.out.println("You not entered double value");
            scn.next();
        }
        return scn.nextDouble();
    }

    public static Integer getIntFromKeyboard(String text) {
        System.out.println(text);
        while (!scn.hasNextInt()) {
            System.out.println("You not entered integer");
            scn.next();
        }
        return scn.nextInt();
    }

    public static int getPosIntFromKeyboard(String text) {
        int i;
        do {
            i = getIntFromKeyboard(text);
            if (i <= 0) {
                System.out.println("You not entered positive integer");
            }
        } while (i <= 0);
        return i;
    }
}
