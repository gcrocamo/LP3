package application;

import java.util.ArrayList;
import java.util.List;

class Shape2D {
    protected String name;

    public Shape2D(String name) {
        this.name = name;
    }

    public String draw() {
        return "Drawing " + name;
    }

    public double area() {
        return 0.0;
    }

    public double perimeter() {
        return 0.0;
    }
}

class Circle extends Shape2D {
    private double radius;

    public Circle(double radius) {
        super("Circle");
        this.radius = radius;
    }

    @Override
    public String draw() {
        return "Drawing Circle with radius " + radius;
    }

    @Override
    public double area() {
        return Math.PI * radius * radius;
    }

    @Override
    public double perimeter() {
        return 2 * Math.PI * radius;
    }
}

class Rectangle extends Shape2D {
    private double width;
    private double height;

    public Rectangle(double width, double height) {
        super("Rectangle");
        this.width = width;
        this.height = height;
    }

    @Override
    public String draw() {
        return "Drawing Rectangle with width " + width + " and height " + height;
    }

    @Override
    public double area() {
        return width * height;
    }

    @Override
    public double perimeter() {
        return 2 * (width + height);
    }
}

class ShapeCollection {
    private List<Shape2D> shapes;

    public ShapeCollection() {
        this.shapes = new ArrayList<>();
    }

    public void addShape(Shape2D shape) {
        shapes.add(shape);
    }

    public void drawAll() {
        for (Shape2D shape : shapes) {
            System.out.println(shape.draw());
        }
    }

    public double calculateTotalArea() {
        double totalArea = 0;
        for (Shape2D shape : shapes) {
            totalArea += shape.area();
        }
        return totalArea;
    }

    public double calculateTotalPerimeter() {
        double totalPerimeter = 0;
        for (Shape2D shape : shapes) {
            totalPerimeter += shape.perimeter();
        }
        return totalPerimeter;
    }
}

public class Teste {
    public static void main(String[] args) {
        Circle circle = new Circle(5);
        Rectangle rectangle = new Rectangle(3, 4);

        ShapeCollection shapeCollection = new ShapeCollection();
        shapeCollection.addShape(circle);
        shapeCollection.addShape(rectangle);

        shapeCollection.drawAll();

        System.out.println("Total Area: " + shapeCollection.calculateTotalArea());
        System.out.println("Total Perimeter: " + shapeCollection.calculateTotalPerimeter());
    }
}
