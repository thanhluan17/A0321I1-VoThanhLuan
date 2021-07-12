package b7_abstract_class_interface.bai_tap.resizeable_interface.shape;

import b7_abstract_class_interface.bai_tap.resizeable_interface.Resizeable;

public class Circle extends Shape implements Resizeable {
    private double radius = 1.0;

    public Circle() {
    }

    public Circle(double radius) {
        this.radius = radius;
    }

    public Circle(double radius, String color, boolean filled) {
        super(color, filled);
        this.radius = radius;
    }

    public double getRadius() {
        return radius;
    }

    public void setRadius(double radius) {
        this.radius = radius;
    }

    public double getArea() {
        return radius * radius * Math.PI;
    }

    public double getPerimeter() {
        return 2 * radius * Math.PI;
    }

    @Override
    public String toString() {
        return "Radius="
                + getRadius()
                + ", "
                + super.toString();
    }

    @Override
    public void resize(double percent) {
        this.radius = this.radius * percent / 100;
    }
}
