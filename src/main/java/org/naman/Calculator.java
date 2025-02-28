package org.naman;

import java.util.InputMismatchException;
import java.util.Scanner;

public class Calculator {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        while (true) {
            System.out.print("\n");
            System.out.println("Scientific Calculator Menu:");
            System.out.println("1. Square root (\u221Ax)");
            System.out.println("2. Factorial (x!)");
            System.out.println("3. Natural logarithm (ln(x))");
            System.out.println("4. Power function (x^b)");
            System.out.println("5. Exit");
            System.out.print("Enter your choice: ");

            int choice = getValidIntInput(sc);
            if (choice == -1) continue;

            int x, y;
            double result;
            switch (choice) {
                case 1:
                    System.out.print("Enter a number: ");
                    x = getValidIntInput(sc);
                    if (x == -1) continue;
                    result = squareRoot(x);
                    System.out.println("Square root is: " + result);
                    break;
                case 2:
                    System.out.print("Enter a number: ");
                    x = getValidIntInput(sc);
                    if (x == -1) continue;
                    result = factorial(x);
                    System.out.println("Factorial is: " + result);
                    break;
                case 3:
                    System.out.print("Enter a number: ");
                    x = getValidIntInput(sc);
                    if (x == -1) continue;
                    result = logNatural(x);
                    System.out.println("Log is: " + result);
                    break;
                case 4:
                    System.out.print("Enter a number: ");
                    x = getValidIntInput(sc);
                    if (x == -1) continue;
                    System.out.print("Enter power: ");
                    y = getValidIntInput(sc);
                    if (y == -1) continue;
                    result = powerFunction(x, y);
                    System.out.println("Answer is: " + result);
                    break;
                case 5:
                    System.out.println("Thank you! Goodbye!");
                    sc.close();
                    return;
                default:
                    System.out.println("Wrong choice. Please enter a valid number");
            }
        }
    }

    private static int getValidIntInput(Scanner sc) {
        try {
            return sc.nextInt();
        } catch (InputMismatchException e) {
            System.out.println("Invalid input! Please enter a valid number.");
            sc.nextLine(); // Clear invalid input
            return -1; // Indicate invalid input
        }
    }

    public static double squareRoot(int x) {
        return Math.sqrt(x);
    }

    public static double factorial(int x) {
        double result = 1;
        for (int i = 1; i <= x; i++) {
            result *= i;
        }
        return result;
    }

    public static double logNatural(int x) {
        return Math.log(x);
    }

    public static double powerFunction(int x, int b) {
        return Math.pow(x, b);
    }
}
