package ss6_Inheritance.Bai_Tap.Point_MoveablePoint;

public class Point {
    private float x = 0.0f;
    private float y = 0.0f;

    public Point() {

    }

    public Point(float x, float y) {
        this.x = x;
        this.y = y;
    }

    public float getX() {
        return this.x;
    }

    public void setX(float x) {
        this.x = x;
    }

    public float getY() {
        return this.y;
    }

    public void setY(float y) {
        this.y = y;
    }

    public float[] getXY() {
        float[] arr = {getX(), getY()};
        return arr;
    }

    public String toString() {
        return "( " + getX() + ", " + getY() + ")";
    }
}
