package b11_dsa_stack_queue.bai_tap.decimal_to_binary;

import java.util.Scanner;
import java.util.Stack;

public class DecimalBinary {
    public static void main(String[] args) {
        Stack<Integer> stack = new Stack<>();
        System.out.println("Enter decimal number: ");
        Scanner scanner = new Scanner(System.in);
        int decimalNumber = scanner.nextInt();
        String binaryNumber = "";
        int remainder;
        while (decimalNumber != 0) {
            remainder = decimalNumber % 2;
            stack.push(remainder);
            decimalNumber /= 2;
        }
        while (!stack.isEmpty()) {
            binaryNumber += stack.pop();
        }
        System.out.println(decimalNumber + " (Decimal) = " + binaryNumber + " (Binary)");
    }
}
