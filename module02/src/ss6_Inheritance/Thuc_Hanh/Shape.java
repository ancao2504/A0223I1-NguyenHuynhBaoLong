package ss6_Inheritance.Thuc_Hanh;

public class Shape {
    private String color = "Green";
    private Boolean fill = true;

    public Shape () {

    }

    public Shape(String color, Boolean filled) {
        this.color = color;
        this.fill = filled;
    }

    public String getColor() {
        return this.color;
    }
    public void setColor(String color) {
        this.color = color;
    }
    public Boolean isFilled() {
        return this.fill;
    }
    public void setColor(Boolean filled) {
        this.fill = filled;
    }
    @Override
    public String toString() {
        return "A shape with color is "
                + getColor()
                + " and "
                +(isFilled()?"filled" :"not filled");
    }
}
