package ss6_Inheritance.Thuc_Hanh;

public class Circle extends Shape{
    private double radius =1.0;

    public Circle() {

    }
    public  Circle(double radius) {
        this.radius = radius;
    }
    public  Circle(double radius, String color, Boolean filled) {
        super(color, filled);
        this.radius= radius;
    }
    public double getArea () {
        return Math.pow(radius,2) * Math.PI;
    }
    public double getPerimeter() {
        return 2*radius*Math.PI;
    }
    public double getRadius() {
        return radius;
    }

    public void setRadius(double radius) {
        this.radius = radius;
    }
    @Override
    public String toString () {
        return "A circle with radius "
                + getRadius()
                +" , which is a subclass of "
                + super.toString();
    }
}
