// Interface for shapes
interface Shape {
    double calculateArea();
}

// Rectangle class
class Rectangle implements Shape {
    private double length;
    private double breadth;

    public Rectangle(double length, double breadth) {
        this.length = length;
        this.breadth = breadth;
    }

    @Override
    public double calculateArea() {
        return length * breadth;
    }
}

// Circle class
class Circle implements Shape {
    private double radius;

    public Circle(double radius) {
        this.radius = radius;
    }

    @Override
    public double calculateArea() {
        return Math.PI * Math.pow(radius, 2);
    }
}
b
// AreaCalculator class
class AreaCalculator {
    public double calculateArea(Shape shape) {
        return shape.calculateArea();
    }
}

// Main class to use AreaCalculator
public class Main {
    public static void main(String[] args) {
        AreaCalculator calculator = new AreaCalculator();

        Shape rectangle = new Rectangle(5, 10);
        System.out.println("Rectangle Area: " + calculator.calculateArea(rectangle));

        Shape circle = new Circle(7);
        System.out.println("Circle Area: " + calculator.calculateArea(circle));
    }
}