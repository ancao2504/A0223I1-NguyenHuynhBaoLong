package ss15_exception.exercise;

public class CheckIllegalTriangleException {

    private double side1;
    private double side2;
    private double side3;

    public CheckIllegalTriangleException() {
    }

    public CheckIllegalTriangleException(double side1, double side2, double side3) {
        this.side1 = side1;
        this.side2 = side2;
        this.side3 = side3;
    }

    public double getSide1() {
        return side1;
    }

    public void setSide1(double side1) throws IllegalTriangleException{
        this.side1 = side1;
        if (side1 < 0 ) {
            throw new  IllegalTriangleException("Side must be larger than 0 !");
        }
    }

    public double getSide2() {
        return side2;
    }

    public void setSide2(double side2) throws IllegalTriangleException {
        this.side2 = side2;
        if(side2 < 0) {
            throw new IllegalTriangleException("Side must be larger than 0 !");
        }
    }

    public double getSide3() {
        return side3;
    }

    public void setSide3(double side3) throws IllegalTriangleException {
        this.side3 = side3;
        if(side3 < 0 ) {
            throw new IllegalTriangleException("Side must be larger than 0 !");
        }
    }

}
