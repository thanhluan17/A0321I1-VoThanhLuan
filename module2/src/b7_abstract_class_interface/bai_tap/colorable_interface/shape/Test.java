package b7_abstract_class_interface.bai_tap.colorable_interface.shape;

import b7_abstract_class_interface.bai_tap.colorable_interface.Colorable;

public class Test {
    public static void main(String[] args) {
        Shape[] shapes = new Shape[3];
        shapes[0] = new Circle(10);
        shapes[1] = new Rectangle(10, 20);
        shapes[2] = new Square(10);
        for (Shape shape : shapes) {
            System.out.println(shape.getArea());
            if (shape instanceof Colorable) {
                ((Colorable) shape).howToColor();
            }
        }
    }
}
