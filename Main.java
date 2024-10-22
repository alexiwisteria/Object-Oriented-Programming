import java.util.Scanner; // Needed for user input
import java.util.ArrayList; // Needed to create dynamic Array (ArrayList)
import java.util.Collections; // Needed to sort an array

/**
 * File: Main.java
 * Assignment: Lab 1a
 * Description: The Program asks the user to enter a list of numbers.  The program then lists the numbers entered by the user. Then it lists the sum of the numbers, the largest number given and the smallest number given.
 * Instructor's Name: Jeff Light
 *
 *
 * @author Alexis Binch
 * @since 04/26/24
 */

// Class Declaration
public class Main {
// Main Method
    public static void main(String[] args) {

// Array List
    ArrayList<Integer> numbers = new ArrayList<>();

// Scanner
    Scanner scanner = new Scanner(System.in);

// Collects input from user until user presses enter
    while (true) {
// Asks for user input
        System.out.println("Please enter a number (or press the <Enter> key to stop):");
        String input = scanner.nextLine();

// Checks if the input is empty after the user presses enter
        if (input.isEmpty()) {
        break;
        }

// Invalidates Strings
        try {
        int num = Integer.parseInt(input);
        numbers.add(num);
        }
        catch (NumberFormatException e) {
        System.out.println("Invalid input. Please enter a valid integer.");
        }
    }

// Close the scanner
    scanner.close();

// Prints the list of numbers entered by the user
    System.out.println("Numbers entered by the user: " + numbers);

// Uses addNumbers function and prints result
    System.out.println("Sum of numbers: " + addNumbers(numbers));

// Uses the largestNumber function and prints result
    System.out.println("Largest number: " + largestNumber(numbers));

    }

// addNumbers function
    public static int addNumbers(ArrayList<Integer> numbers) {
        int sum = 0;
        for (int num : numbers) {
            sum += num;
        }
        return sum;
    }

// largestNumber function
    public static int largestNumber(ArrayList<Integer> numbers) {
        return Collections.max(numbers);
    }

}