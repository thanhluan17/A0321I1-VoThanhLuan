package b11_dsa_stack_queue.bai_tap.stack_reverse_array;

import java.util.Scanner;
import java.util.Stack;

public class StackReverseArray {
    public static void reverseNumberArray(int[] intArray) {
        Stack<Integer> integerStack = new Stack<>();
        for (int i = 0; i < intArray.length; i++) {
            integerStack.push(intArray[i]);
        }
        for (int i = 0; i < intArray.length; i++) {
            intArray[i] = integerStack.pop();
        }

        for (int item : intArray) {
            System.out.println(item);
        }
    }

    public static String reverseStringArray(String[] strArray) {
        Stack<String> stringStack = new Stack<>();
        String resultStr = "";
        for (int i = 0; i < strArray.length; i++) {
            stringStack.push(strArray[i]);
        }
        for (int i = 0; i < strArray.length; i++) {
            resultStr += stringStack.pop() + " ";
        }
        return resultStr;
    }

    public static void main(String[] args) {
        int[] intArray = {1, 2, 3, 4, 5};
        reverseNumberArray(intArray);

        System.out.println("Enter string to reverse: ");
        Scanner scanner = new Scanner(System.in);
        String str = scanner.nextLine();
        String[] strArray = str.split(" ");
        System.out.println("Before reverse: ");
        for (String item : strArray) {
            System.out.println(item);
        }
        System.out.println("After reverse: " + reverseStringArray(strArray));
    }
}
