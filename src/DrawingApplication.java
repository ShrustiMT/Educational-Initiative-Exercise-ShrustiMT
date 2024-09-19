//Structural Design Patterns - Drawing Application = Bridge pattern
interface DrawingTool {
    void draw();
}

class Pen implements DrawingTool {
    public void draw() {
        System.out.println("Drawing with pen");
    }
}

class Brush implements DrawingTool {
    public void draw() {
        System.out.println("Drawing with brush");
    }
}

abstract class Shape {
    protected DrawingTool drawingTool;

 public Shape(DrawingTool drawingTool) {
        this.drawingTool = drawingTool;
    }

    abstract void draw();
}

class Circle extends Shape {
    public Circle(DrawingTool drawingTool) {
        super(drawingTool);
    }

    public void draw() {
        System.out.println("Drawing circle");
        drawingTool.draw();
    }
}

class Rectangle extends Shape {
    public Rectangle(DrawingTool drawingTool) {
        super(drawingTool);
    }

    public void draw() {
        System.out.println("Drawing rectangle");
        drawingTool.draw();
    }
}

public class DrawingApplication {
    public static void main(String[] args) {
        DrawingTool pen = new Pen();
        Shape circle = new Circle(pen);
        circle.draw();

        DrawingTool brush = new Brush();
        Shape rectangle = new Rectangle(brush);
        rectangle.draw();
    }
}