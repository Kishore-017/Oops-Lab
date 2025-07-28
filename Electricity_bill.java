import java.util.Scanner;

public class Bill1 {
    public static void main(String[] args) {
        int a, d;
        String name;
        float e, c, b;
        Scanner s = new Scanner(System.in);

        // Read the consumer number
        System.out.println("Enter consumer number:");
        a = s.nextInt();

        // Read the consumer name
        System.out.println("Enter consumer name:");
        s.nextLine();  // Clear the buffer
        name = s.nextLine();

        // Read the previous and current month readings
        System.out.println("Enter previous month reading:");
        b = s.nextFloat();
        System.out.println("Enter current month reading:");
        c = s.nextFloat();

        // Read the type of EB connection
        System.out.println("Enter the type of EB connection(Domestic=1,Commercial=2):");
        d = s.nextInt();

        // Calculate electricity consumption
        e = c - b;

        // Bill calculation based on the type of connection and consumption
        if (d == 1) { // Domestic
            if (e <= 100) {
                System.out.println("Bill = " + (e * 1));
            } else if (e <= 200) {
                System.out.println("Bill = " + (e * 2.50));
            } else if (e <= 500) {
                System.out.println("Bill = " + (e * 4));
            } else {
                System.out.println("Bill = " + (e * 6));
            }
        } else if (d == 2) { // Commercial
            if (e <= 100) {
                System.out.println("Bill = " + (e * 2));
            } else if (e <= 200) {
                System.out.println("Bill = " + (e * 4.50));
            } else if (e <= 500) {
                System.out.println("Bill = " + (e * 6));
            } else {
                System.out.println("Bill = " + (e * 7));
            }
        } else {
            System.out.println("Please enter a valid number for connection type.");
        }

        // Close the scanner resource to avoid memory leak
        s.close();
    }
}
