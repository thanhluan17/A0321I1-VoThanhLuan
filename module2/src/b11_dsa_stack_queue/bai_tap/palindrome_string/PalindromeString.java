package b11_dsa_stack_queue.bai_tap.palindrome_string;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class PalindromeString {
    public static void main(String[] args) {
        System.out.print("Enter string:");
        Scanner scanner = new Scanner(System.in);
        String inputString = scanner.nextLine();
        Queue queue = new LinkedList();

        for (int i = inputString.length() - 1; i >= 0; i--) {
            queue.add(inputString.charAt(i));
        }

        String reverseString = "";

        while (!queue.isEmpty()) {
            reverseString = reverseString + queue.remove();
        }
        if (inputString.equals(reverseString))
            System.out.println("The input String is a palindrome.");
        else
            System.out.println("The input String is not a palindrome.");
    }
}
