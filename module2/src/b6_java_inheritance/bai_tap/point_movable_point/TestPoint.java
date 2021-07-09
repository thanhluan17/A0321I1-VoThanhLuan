package b6_java_inheritance.bai_tap.point_movable_point;

public class TestPoint {
    public static void main(String[] args) {
        Point point = new Point();
        System.out.println(point.toString());
        point.setXY(3, 7);
        System.out.println(point.toString());
    }
}
