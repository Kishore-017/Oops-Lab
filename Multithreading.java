import java.util.Scanner;

// Thread to print odd numbers
class OddThread extends Thread {
    private int n;

    public OddThread(int n) {
        this.n = n;
    }

    @Override
    public void run() {
        System.out.println("Odd numbers from 1 to " + n + ":");
        for (int i = 1; i <= n; i++) {
            if (i % 2 != 0) {
                System.out.println("T1 (Odd): " + i);
            }
        }
    }
}

// Thread to print even numbers
class EvenThread extends Thread {
    private int n;

    public EvenThread(int n) {
        this.n = n;
    }

    @Override
    public void run() {
        System.out.println("Even numbers from 1 to " + n + ":");
        for (int i = 1; i <= n; i++) {
            if (i % 2 == 0) {
                System.out.println("T2 (Even): " + i);
            }
        }
    }
}

// Main class
public class Multithreading {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in); // Create Scanner object
        System.out.print("Enter the value of n: ");
        int n = sc.nextInt(); // Read user input

        OddThread t1 = new OddThread(n);
        EvenThread t2 = new EvenThread(n);

        t1.start(); // Start odd number thread
        t2.start(); // Start even number thread

        sc.close(); // Close scanner
    }
}

