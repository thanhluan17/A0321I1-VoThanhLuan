package b6_java_inheritance.bai_tap.circle_cylinder;

public class Cylinder extends Circle {
    private double height = 2.0;

    public Cylinder() {
    }

    public Cylinder(double height) {
        this.height = height;
    }

    public Cylinder(double radius, String color, double height) {
        super(radius, color);
        this.height = height;
    }

    @Override
    public String toString() {
        return "Cylinder{" +
                "radius=" + getRadius() +
                ", color='" + getColor() + '\'' +
                ", height=" + height +
                '}';
    }

    public double volume() {
        return Math.pow(getRadius(), 2) * height * Math.PI;
    }
}
