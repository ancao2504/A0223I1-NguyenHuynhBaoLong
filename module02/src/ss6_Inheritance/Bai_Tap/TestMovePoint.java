package ss6_Inheritance.Bai_Tap;

public class TestMovePoint {
    public static void main(String[] args) {
        Point point = new Point(10.2f,120.3f);
        System.out.println(point);

        MoveablePoint moveablePoint = new MoveablePoint(1.0f,2.0f);
        System.out.println(moveablePoint);

        System.out.println(moveablePoint.move());
        System.out.println(moveablePoint.move());
        System.out.println(moveablePoint.move());
    }
}
