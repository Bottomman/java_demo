class GeometricObject {
    String color;
    double weight;

    GeometricObject(String color, double weight) {
        this.color = color;
        this.weight = weight;
    }

    public double findArea() {
        return 10;
    }

    public String getColor() {
        return color;
    }

    public void setColor(String color) {
        this.color = color;
    }

    public double getWeight() {
        return weight;
    }

    public void setWeight(double weight) {
        this.weight = weight;
    }
}

class Circle extends GeometricObject {
    private double radius;

    Circle(double radius, String color, double weight) {
        super(color, weight);
        this.radius = radius;
    }

    @Override
    public double findArea() {
        return Math.PI * radius * radius;
    }

    public double getRadius() {
        return radius;
    }

    public void setRadius(double radius) {
        this.radius = radius;
    }
}

class MyRectangle extends GeometricObject {
    private double width;
    private double height;

    MyRectangle(double width, double height, String color, double weight) {
        super(color, weight);
        this.width = width;
        this.height = height;
    }

    @Override
    public double findArea() {
        return this.height * width;
    }

    public double getWidth() {
        return width;
    }

    public void setWidth(double width) {
        this.width = width;
    }

    public double getHeight() {
        return height;
    }

    public void setHeight(double height) {
        this.height = height;
    }
}

public class GeometricTest {
    public boolean equalsArea(GeometricObject g1, GeometricObject g2) {
        return g1.findArea() == g2.findArea();
    }

    public static void main(String[] args) {
        System.out.println(new GeometricTest().equalsArea(new Circle(1, "1", 1), new MyRectangle(1, Math.PI, "1", 1)));
    }
}