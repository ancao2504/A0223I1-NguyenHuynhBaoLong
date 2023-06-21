package ss5_Access_Modifier.Bai_tap;

public class Circle {
    private final double PI = 3.14;
    private double radius = 1.0;
    private String color = "red";

    public Circle () {

    }
    public Circle (double r) {
        radius = r;
    }
    public double getRadius () {
        return radius;
    }
    public double getArea() {
        return PI * Math.pow(radius,2);
    }

}
