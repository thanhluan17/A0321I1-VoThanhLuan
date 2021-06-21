package b2_loop_in_java.bai_tap;

import java.util.Scanner;

public class DrawShape {
    public static void main(String[] args) {
        int selection;
        Scanner scanner = new Scanner(System.in);
        while (true) {
            System.out.println("-----Menu-----");
            System.out.println("1. Print the rectangle");
            System.out.println("2. Print the square triangle");
            System.out.println("3. Print isosceles triangle");
            System.out.println("4. Exit");
            System.out.println("Enter your selection: ");
            selection = scanner.nextInt();

            switch (selection) {
                case 1:
                    int width, height;
                    System.out.println("Enter width: ");
                    width = scanner.nextInt();
                    System.out.println("Enter height: ");
                    height = scanner.nextInt();
                    for (int i = 1; i <= height; i++) {
                        for (int j = 1; j <= width; j++) {
                            System.out.print("*");
                        }
                        System.out.println();
                    }
                    break;
                case 2:
                    System.out.println("Enter width: ");
                    width = scanner.nextInt();
                    for (int i = 1; i <= width; i++) {
                        for (int j = 1; j <= i; j++) {
                            System.out.print("*");
                        }
                        System.out.println();
                    }

                    System.out.println();

                    for (int i = 1; i <= width; i++) {
                        for (int j = 1; j <= width; j++) {
                            if (i == 1 || j >= i) {
                                System.out.print("*");
                            } else {
                                System.out.print(" ");
                            }
                        }
                        System.out.println();
                    }
                    break;
                case 3:
                    System.out.println("Enter width: ");
                    height = scanner.nextInt();
                    for (int i = 1; i <= height; i++) {
                        for (int j = 1; j <= height - i; j++) {
                            System.out.print("  ");
                        }
                        for (int k = 1; k <= 2 * i - 1; k++) {
                            System.out.print("* ");
                        }
                        System.out.println("");
                    }
                    break;
                case 4:
                    System.exit(0);
                default:
                    System.out.println("Invalid selection!");
            }
        }
    }
}
