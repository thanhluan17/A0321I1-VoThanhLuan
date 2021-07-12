package b7_abstract_class_interface.bai_tap.resizeable_interface.shape;

public class Test {
    public static void main(String[] args) {
        Shape[] shapes = new Shape[3];
        shapes[0] = new Circle(10);
        shapes[1] = new Rectangle(10, 20);
        shapes[2] = new Square(10);
        double resizePercent = 50;
        System.out.println("Resize percent: " + resizePercent + "% \n----------");
        for (Shape shape : shapes) {
            if (shape instanceof Circle) {
                System.out.println("Before resize: ");
                System.out.println(shape.toString());
                ((Circle) shape).resize(resizePercent);
                System.out.println("After resize: ");
                System.out.println(shape.toString());
            } else if (shape instanceof Square) {
                System.out.println("Before resize: ");
                System.out.println(shape.toString());
                ((Square) shape).resize(resizePercent);
                System.out.println("Before resize: ");
                System.out.println(shape.toString());
            } else if (shape instanceof Rectangle) {
                System.out.println("Before resize: ");
                System.out.println(shape.toString());
                ((Rectangle) shape).resize(resizePercent);
                System.out.println("Before resize: ");
                System.out.println(shape.toString());
            }
        }
    }
}
