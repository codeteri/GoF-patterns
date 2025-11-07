#include <iostream>
#include <sstream>
#include <string>

// Base Shape class
class Shape
{
public:
  virtual std::string str() const = 0;
};

// Circle class
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

// Square class
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

// ColoredShape decorator class
class ColoredShape : public Shape
{
  // https://iq.opengenus.org/print-text-in-color-in-c/
  static constexpr const char *colorCode = "\033[1;{}m"; // ansi escape code for colors
  int color;
  Shape &shape; // use composition, not inheritance
public:
  ColoredShape(const int color, Shape &shape) : color(color), shape(shape) {}

  std::string str() const override
  {
    std::stringstream ss;
    ss << shape.str();
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
  Square square(5);  // A square with side length 5
  Circle circle(10); // A circle with radius 10
  // Dynamically add color using the decorator
  ColoredShape redSquare(ColorRed, square);
  ColoredShape blueCircle(ColorBlue, circle);
  std::cout << redSquare.str() << std::endl;
  std::cout << blueCircle.str() << std::endl;
  std::cout << square.str() << std::endl;
  return 0;
}
// output
// A Square with side 5 having color red
// A Circle of radius 10 having color blue
// A Square with side 5