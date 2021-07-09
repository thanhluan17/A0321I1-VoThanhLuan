package b6_java_inheritance.bai_tap.circle_cylinder;

public class CylinderTest {
    public static void main(String[] args) {
        Cylinder cylinder = new Cylinder(3);
        System.out.println(cylinder.toString());
        System.out.println("Volume is: " + cylinder.volume());
    }
}
