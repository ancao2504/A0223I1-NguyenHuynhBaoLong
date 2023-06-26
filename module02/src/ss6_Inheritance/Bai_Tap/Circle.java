package ss6_Inheritance.Bai_Tap;

public class Circle {
    private double radius = 1.0;
    private String color = "red";

    public Circle() {

    }

    public Circle(double radius, String color) {
        this.radius = radius;
        this.color = color;
    }

    public double getRadius() {
        return this.radius;
    }

    public void setRadius(double radius) {
        this.radius = radius;
    }

    public String getColor() {
        return this.color;
    }

    public void setColor(String color) {
        this.color = color;
    }
    public double getArea () {
        return Math.pow(radius,2) * Math.PI;
    }
    public double getPerimeter() {
        return 2*radius*Math.PI;
    }
    public String toString () {
        return "A circle with "
                + getRadius()
                +" and the color is "
                + getColor();
    }
}
