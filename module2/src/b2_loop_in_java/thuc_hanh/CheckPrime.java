package b2_loop_in_java.thuc_hanh;

import java.util.Scanner;

public class CheckPrime {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Enter number to check: ");
        int number = scanner.nextInt();
        if (number < 2) {
            System.out.println(number + " is not a prime number!");
        } else {
            int count = 0;
            for (int i = 1; i <= number; i++) {
                if (number % i == 0) {
                    count++;
                }
            }
            if (count == 2) {
                System.out.println(number + " is a prime number!");
            } else {
                System.out.println(number + " is not a prime number!");
            }
        }
    }
}
