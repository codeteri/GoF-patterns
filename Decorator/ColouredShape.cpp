#include <iostream>
#include <sstream>
#include <string>

// Component: The base interface for objects that can be decorated.
class Shape
{
public:
  virtual std::string str() const = 0;
};

// Concrete Component: A basic implementation of the interface.
class Circle : public Shape
{
public:
  float radius;

  Circle(float radius) : radius(radius) {}

  std::string str() const override
  {
    std::stringstream ss;
    ss << "A Circle of radius " << radius;
    return ss.str();
  }
};

// Concrete Component: Another basic implementation.
class Square : public Shape
{
public:
  float side;

  Square(float side) : side(side) {}

  std::string str() const override
  {
    std::stringstream ss;
    ss << "A Square with side " << side;
    return ss.str();
  }
};

/*
Antipattern:
  class RedSquare: public Square {};
  class BlueCircle: public Circle {};
  ....
*/

// const auto ColorNone
const auto ColorRed = 31;
const auto ColorBlue = 34;

// Decorator: Also implements the Shape interface. It wraps another Shape object.
class ColoredShape : public Shape
{
  // https://iq.opengenus.org/print-text-in-color-in-c/
  static constexpr const char *colorCode = "\033[1;{}m"; // ansi escape code for colors
  int color;
  Shape &shape; // Composition: The decorator holds a reference to the component it wraps.
public:
  ColoredShape(const int color, Shape &shape) : color(color), shape(shape) {}

  std::string str() const override
  {
    std::stringstream ss;
    // 1. Delegate the call to the wrapped object.
    ss << shape.str();
    // 2. Add its own behavior.
    if (color == ColorRed)
    {
      ss << " having color red";
    }
    else if (color == ColorBlue)
    {
      ss << " having color blue";
    }
    return ss.str();
  }
};

int main()
{
  // Create concrete component objects.
  Square square(5);  // A square with side length 5
  Circle circle(10); // A circle with radius 10

  // Dynamically "wrap" the components with decorators to add new functionality.
  ColoredShape redSquare(ColorRed, square);
  ColoredShape blueCircle(ColorBlue, circle);

  // Call the same `str()` method, which now includes the decorated behavior.
  std::cout << redSquare.str() << std::endl;
  std::cout << blueCircle.str() << std::endl;
  std::cout << square.str() << std::endl;
  return 0;
}
// output
// A Square with side 5 having color red
// A Circle of radius 10 having color blue
// A Square with side 5