package ss4_OOP.Bai_tap;

public class Fan {
    final int slow = 1;
    final int medium = 2;
    final int fast = 3;
    boolean on = false;
    int speed = 1;
    double radius = 5;
    String color = "blue";

    public Fan() {

    }
    public Fan(int speed, boolean on, double radius, String color) {
        this.speed = speed;
        this.on = on;
        this.radius = radius;
        this.color= color;
    }

    public int speed(int speed) {
        this.speed = speed;
        return this.speed;
    }

    public boolean isOn(boolean status) {
        this.on = status;
        return this.on;
    }

    public String toString() {
        if(this.on) {
            System.out.print("Fan is on "+this.speed + " " + this.color);
        } else {
            System.out.print("Fan is off " +this.color);
        }


        return null;
    }
    public static void main(String[] args) {
        Fan fan1 = new Fan(3,true,10,"yellow");
        Fan fan2 = new Fan(2,false,3,"blue");
        fan1.toString();
        System.out.println("\n");
        fan2.toString();
    }
}
