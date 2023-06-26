package ss6_Inheritance.Bai_Tap;

public class MoveablePoint extends Point {
    private float xSpeed = 0.0f;
    private float ySpeed = 0.0f;

    public MoveablePoint() {

    }
    public MoveablePoint(float xSpeed,float ySpeed) {
        this.xSpeed =xSpeed;
        this.ySpeed = ySpeed;
    }

    public MoveablePoint(float x, float y, float xSpeed, float ySpeed) {
        super(x, y);
        this.xSpeed = xSpeed;
        this.ySpeed = ySpeed;
    }

    public float getxSpeed() {
        return this.xSpeed;
    }

    public void setxSpeed(float xSpeed) {
        this.xSpeed = xSpeed;
    }

    public float getySpeed() {
        return this.ySpeed;
    }

    public void setySpeed(float ySpeed) {
        this.ySpeed = ySpeed;
    }

    public float[] getSpeed() {
        float[] speed = {getxSpeed(), getySpeed()};
        return speed;
    }

    public void setSpeed(float xSpeed, float ySpeed) {
        this.xSpeed = xSpeed;
        this.ySpeed = ySpeed;
    }

    public String toString() {
        return "( " + getX() + ", " + getY() + " ) " + "speed = ( " + getxSpeed() + ", " + getySpeed() + " )";
    }
    public String move() {
        setX(getX() + getxSpeed());
        setY(getY() + getySpeed());
        return this.toString();
    }
}
