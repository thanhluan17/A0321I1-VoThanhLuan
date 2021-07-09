package b6_java_inheritance.bai_tap.point2d_point3d;

public class TestPoint3D {
    public static void main(String[] args) {
        Point3D point3D = new Point3D();
        System.out.println(point3D.toString());
        point3D.setXYZ(2, 1, 5);
        System.out.println(point3D.toString());
    }
}
