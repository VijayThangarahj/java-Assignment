
import java.util.Scanner;

public class Itembill {

    public static void main(String[] args) {
        try (Scanner sc = new Scanner(System.in)) {

            // Taking input for 3 items
            System.out.print("Enter pencil price: ");
            float pencil = sc.nextFloat();

            System.out.print("Enter pen price: ");
            float pen = sc.nextFloat();

            System.out.print("Enter eraser price: ");
            float eraser = sc.nextFloat();

            // Calculate total
            float total = pencil + pen + eraser;
            System.out.println("Total Cost (without GST): " + total);

            // Add GST (18%)
            float gst = total * 0.18f;
            float finalBill = total + gst;
            System.out.println("GST (18%): " + gst);
            System.out.println("Final bill (with GST): " + finalBill);

            sc.close();
        }

    }

}
