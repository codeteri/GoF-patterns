#include <iostream>
#include <vector>

// Forward declarations
class Circle;
class Square;

// Visitor interface
class IShapeVisitor
{
public:
    virtual void visit(Circle &circle) = 0;
    virtual void visit(Square &square) = 0;
};

// Element interface
class IShape
{
public:
    virtual void accept(IShapeVisitor &visitor) = 0;
};

// Concrete Element: Circle
class Circle : public IShape
{
public:
    void accept(IShapeVisitor &visitor) override
    {
        visitor.visit(*this);
    }

    void draw()
    {
        std::cout << "Drawing Circle" << std::endl;
    }
};

// Concrete Element: Square
class Square : public IShape
{
public:
    void accept(IShapeVisitor &visitor) override
    {
        visitor.visit(*this);
    }

    void draw()
    {
        std::cout << "Drawing Square" << std::endl;
    }
};

// Concrete Visitor: DrawingVisitor
class DrawingVisitor : public IShapeVisitor
{
public:
    void visit(Circle &circle) override
    {
        std::cout << "Drawing a Circle" << std::endl;
        circle.draw();
    }

    void visit(Square &square) override
    {
        std::cout << "Drawing a Square" << std::endl;
        square.draw();
    }
};

// Concrete Visitor: AreaVisitor
class AreaVisitor : public IShapeVisitor
{
public:
    void visit(Circle &circle) override
    {
        std::cout << "Calculating area of Circle" << std::endl;
    }

    void visit(Square &square) override
    {
        std::cout << "Calculating area of Square" << std::endl;
    }
};

// Object Structure
class ShapeContainer
{
public:
    void addShape(IShape *shape)
    {
        shapes.push_back(shape);
    }

    void performOperations(IShapeVisitor &visitor)
    {
        for (IShape *shape : shapes)
        {
            shape->accept(visitor);
        }
    }

private:
    std::vector<IShape *> shapes;
};

int main()
{
    // Create instances of shapes
    Circle circle;
    Square square;

    // Create a container and add shapes to it
    ShapeContainer container;
    container.addShape(&circle);
    container.addShape(&square);

    // Create visitors
    DrawingVisitor drawingVisitor;
    AreaVisitor areaVisitor;

    // Perform drawing operations
    container.performOperations(drawingVisitor);

    // Perform area calculation operations
    container.performOperations(areaVisitor);

    return 0;
}