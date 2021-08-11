package b15_exception_and_debug.bai_tap.illegal_triangle;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Enter size 1: ");
        int size1 = scanner.nextInt();
        System.out.println("Enter size 2: ");
        int size2 = scanner.nextInt();
        System.out.println("Enter size 3: ");
        int size3 = scanner.nextInt();
        try {
            Triangle triangle = new Triangle(size1, size2, size3);
        } catch (IllegalTriangleException e) {
            //e.getStackTrace();
            System.out.println(e);
        }
    }
}
