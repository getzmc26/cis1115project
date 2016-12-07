package utilities;

import java.util.Scanner;

/**
 * Prompt is a class that gets console input from the user, validates the input,
 * and then returns the result.
 *
 * @author Matt Getz
 */
public class Prompt {

    public static int getInt(String prompt) {
        Scanner sc = new Scanner(System.in);
        boolean isValid = false;
        int i = 0;
        while (isValid == false) {
            System.out.print(prompt);
            if (sc.hasNextInt()) {
                i = sc.nextInt();
                isValid = true;
            } else {
                System.out.println("\nError! Invalid integer value. Try again.");
            }
            sc.nextLine();
        }
        return i;
    }

    public static int getInt(String prompt, int min, int max) {
        boolean isValid = false;
        int i = 0;
        while (isValid == false) {
            i = getInt(prompt);
            if (i < min) {
                System.out.println("\nError! Must be greater than or equal to " + min);
            } else if (i > max) {
                System.out.println("\nError! Must be less than or equal to " + max);
            } else {
                isValid = true;
            }
        }
        return i;
    }
    
    public static double getDouble(String prompt) {
        Scanner sc = new Scanner(System.in);
        boolean isValid = false;
        double d = 0;
        while (isValid == false) {
            System.out.print(prompt);
            if (sc.hasNextDouble()) {
                d = sc.nextDouble();
                isValid = true;
            } else {
                System.out.println("\nError! Invalid double value. Try again.");
            }
            sc.nextLine();
        }
        return d;
    }
    
    public static double getInt(String prompt, double min, double max) {
        boolean isValid = false;
        double d = 0;
        while (isValid == false) {
            d = getDouble(prompt);
            if (d < min) {
                System.out.println("\nError! Must be greater than or equal to " + min);
            } else if (d > max) {
                System.out.println("\nError! Must be less than or equal to " + max);
            } else {
                isValid = true;
            }
        }
        return d;
    }
    
    public static String getLine(String prompt) {
        Scanner sc = new Scanner(System.in);
        System.out.print(prompt);
        return sc.nextLine();
    }
}
