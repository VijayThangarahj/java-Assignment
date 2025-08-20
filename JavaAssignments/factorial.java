import java.util.Scanner;

public class factorial {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);

        // Ask user to enter a number
        System.out.print("Enter a number: ");
        int num = input.nextInt();
        long factorial = 1;

        // Calculate factorial
        if (num < 0) {
            System.out.println("Factorial does not exist for negative numbers.");
        } else {
            for (int i = 1; i <= num; i++) {
                factorial *= i;
            }
            System.out.println("The factorial of " + num + " is " + factorial + ".");
        }

        input.close();
    }
}
