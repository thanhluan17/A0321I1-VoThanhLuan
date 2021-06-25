package b4_class_object_in_java.bai_tap.quadratic_equation;

import java.util.Scanner;

public class Program {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Enter a: ");
        double a = scanner.nextDouble();
        System.out.println("Enter b: ");
        double b = scanner.nextDouble();
        System.out.println("Enter c: ");
        double c = scanner.nextDouble();
        QuadraticEquation equation = new QuadraticEquation(a, b, c);
        System.out.println(equation.toString());
        double delta = equation.getDiscriminant();
        System.out.println("Delta: " + delta);
        if (delta > 0) {
            System.out.println("x1: " + equation.getRoot1() + "\nx2: " + equation.getRoot2());
        } else if (delta == 0) {
            System.out.println("x: " + equation.getRoot1());
        } else {
            System.out.println("The equation has no roots");
        }
    }
}
