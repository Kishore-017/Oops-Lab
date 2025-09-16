import java.util.Scanner;

// Abstract class Shape
abstract class Shape {
    int a, b;   // dimensions (could be length, breadth, radius, etc.)

    Shape(int x, int y) {
        a = x;
        b = y;
    }

    // Abstract method
    abstract void printArea();
}

// Rectangle class
class Rectangle extends Shape {
    Rectangle(int x, int y) {
        super(x, y);
    }

    void printArea() {
        int area = a * b;
        System.out.println("Area of Rectangle: " + area);
    }
}

// Triangle class
class Triangle extends Shape {
    Triangle(int x, int y) {
        super(x, y);
    }

    void printArea() {
        double area = 0.5 * a * b;
        System.out.println("Area of Triangle: " + area);
    }
}

// Circle class
class Circle extends Shape {
    Circle(int r) {
        super(r, 0); // only radius is needed
    }

    void printArea() {
        double area = Math.PI * a * a;
        System.out.println("Area of Circle: " + area);
    }
}

// Main class
public class ShapeArea {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        // Rectangle input
        System.out.print("Enter length and breadth of Rectangle: ");
        int l = sc.nextInt();
        int b = sc.nextInt();
        Shape rect = new Rectangle(l, b);
        rect.printArea();

        // Triangle input
        System.out.print("Enter base and height of Triangle: ");
        int base = sc.nextInt();
        int h = sc.nextInt();
        Shape tri = new Triangle(base, h);
        tri.printArea();

        // Circle input
        System.out.print("Enter radius of Circle: ");
        int r = sc.nextInt();
        Shape cir = new Circle(r);
        cir.printArea();

        sc.close();
    }
}