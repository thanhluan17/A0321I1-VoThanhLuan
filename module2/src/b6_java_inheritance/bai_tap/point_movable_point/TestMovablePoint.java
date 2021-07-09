package b6_java_inheritance.bai_tap.point_movable_point;

public class TestMovablePoint {
    public static void main(String[] args) {
        MovablePoint movablePoint = new MovablePoint();
        System.out.println(movablePoint.toString());
        movablePoint.setSpeed(3, 2);
        System.out.println(movablePoint.toString());
        System.out.println("Point move!");
        movablePoint.move();
        System.out.println(movablePoint.toString());
    }
}
