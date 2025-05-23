import java.util.InputMismatchException;
import java.util.Scanner;

// Custom Exception class
class InvalidInputException extends Exception {
    public InvalidInputException(String message) {
        super(message);
    }
}

public class ExceptionHandlingDemo {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        // Task 1: ArithmeticException
        try {
            System.out.println("Enter two numbers for division:");
            int numerator = scanner.nextInt();
            int denominator = scanner.nextInt();
            int result = numerator / denominator; 
            System.out.println("Result: " + result);
        } catch (ArithmeticException e) {
            System.out.println("Error: ArithmeticException - Division by zero is not allowed.");
        }

        // Task 2: ArrayIndexOutOfBoundsException
        try {
            int[] array = {1, 2, 3};
            System.out.println("Enter an index to access the array:");
            int index = scanner.nextInt();
            System.out.println("Value at index " + index + ": " + array[index]); 
        } catch (ArrayIndexOutOfBoundsException e) {
            System.out.println("Error: ArrayIndexOutOfBoundsException - Invalid array index.");
        }

        // Task 3: Multiple Catch Blocks
        try {
            System.out.println("Enter a number to process:");
            int input = scanner.nextInt();
            int[] numbers = {10, 20};
            int result = 100 / input; 
            System.out.println("Value at index " + input + ": " + numbers[input]); 
        } catch (ArithmeticException e) {
            System.out.println("Error: ArithmeticException - Division by zero in multiple catch block.");
        } catch (ArrayIndexOutOfBoundsException e) {
            System.out.println("Error: ArrayIndexOutOfBoundsException - Invalid index in multiple catch block.");
        } catch (Exception e) {
            System.out.println("Error: " + e.getClass().getSimpleName() + " - An unexpected error occurred: " + e.getMessage());
        }

        // Task 4: InputMismatchException
        try {
            System.out.println("Enter an integer:");
            int number = scanner.nextInt(); 
            System.out.println("You entered: " + number);
        } catch (InputMismatchException e) {
            System.out.println("Error: InputMismatchException - Please enter a valid integer.");
            scanner.nextLine(); 
        }

        // Task 5: Custom Exception
        try {
            System.out.println("Enter your age:");
            int age = scanner.nextInt();
            if (age < 0) {
                throw new InvalidInputException("Age cannot be negative.");
            }
            System.out.println("Your age is: " + age);
        } catch (InvalidInputException e) {
            System.out.println("Error: InvalidInputException - " + e.getMessage());
        } catch (InputMismatchException e) {
            System.out.println("Error: InputMismatchException - Please enter a valid integer for age.");
        } finally {
            scanner.close();
        }
    }
}