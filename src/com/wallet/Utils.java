package com.wallet;

import com.wallet.exception.InvalidInputException;

import java.util.Scanner;

public class Utils {
    static final Scanner scanner = new Scanner(System.in);

    public static void print(String sentence) {
        System.out.println(sentence);
    }
    public static double doubleScanner() {
        try {
            return scanner.nextDouble();
        } catch (Exception e) {
            print("Invalid input");
            scanner.nextLine();
        }
        return 0;
    }

    public static int intScanner() {
        try {
            return scanner.nextInt();
        } catch (Exception e) {
            print("Invalid input");
            scanner.nextLine();
        }
        return 0;
    }

    public static void notImplemented() {
        print("Not implemented yet.");
    }

    public static void quit() {
        Utils.print("See you later !");
    };
}
