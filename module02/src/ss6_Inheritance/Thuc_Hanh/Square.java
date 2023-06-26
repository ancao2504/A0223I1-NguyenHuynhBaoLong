package ss6_Inheritance.Thuc_Hanh;

public class Square extends Rectangle{
    private double side=1.0;

    public Square () {

    }
    public Square(double side) {
        super(side,side);
    }
    public Square(double side,String color, Boolean filled) {
        super(side,side,color,filled);
    }
    public double getSide() {
        return getWidth();
    }

    public void setSide(double side) {
        setWidth(side);
        setLength(side);
    }

    @Override
    public void setWidth(double width) {
        setSide(width);
    }

    @Override
    public void setLength(double length) {
        setSide(length);
    }

    @Override
    public String toString() {
        return "A Square with side="
                + getSide()
                + ", which is a subclass of "
                + super.toString();
    }

}
