
import java.util.Scanner;

public class positivenegativechecker {

    public static void main(String[] args) {
        // Create Scanner object to take input from user
        try (Scanner sc = new Scanner(System.in)) {

            // Ask user for a number
            System.out.print("Enter a number: ");
            int num = sc.nextInt();

            // Check whether number is positive, negative, or zero
            if (num > 0) {
                System.out.println(num + " is Positive.");
            } else if (num < 0) {
                System.out.println(num + " is Negative.");
            } else {
                System.out.println("The number is Zero.");
            }

            sc.close(); // close scanner to avoid memory leaks
        }
    }

}
