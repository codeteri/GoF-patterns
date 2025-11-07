package Decorator;

/* 
This program demonstrates the Decorator pattern with the example of shapes 
being dynamically colored.
 */

interface Shape {
  String str();
}

class Circle implements Shape {
  private float radius;

  public Circle(float radius) {
    this.radius = radius;
  }

  @Override
  public String str() {
    return "A Circle of radius " + radius;
  }
}

class Square implements Shape {
  private float side;

  public Square(float side) {
    this.side = side;
  }

  @Override
  public String str() {
    return "A Square with side " + side;
  }
}

// ColoredShape decorator class
class ColoredShape implements Shape {
  private Shape shape;
  private String color;

  public ColoredShape(Shape shape, String color) {
    this.shape = shape;
    this.color = color;
  }

  @Override
  public String str() {
    return shape.str() + " having color " + color;
  }
}

public class Main {
  public static void main(String[] args) {
    Square square = new Square(5);
    Circle circle = new Circle(10);

    // Dynamically add color using the decorator
    ColoredShape redSquare = new ColoredShape(square, "red");
    ColoredShape blueCircle = new ColoredShape(circle, "blue");

    System.out.println(redSquare.str());
    System.out.println(blueCircle.str());
    System.out.println(square.str());
  }
}
