package b3_array_method_java.bai_tap;

import java.util.Scanner;

public class ArrayAddElement {
    public static void addElement(int index, int number, int[] arr) {
        int[] newArr = new int[arr.length + 1];
        for (int i = 0; i < index; i++) {
            newArr[i] = arr[i];
        }
        newArr[index] = number;
        for (int j = index + 1; j < newArr.length; j++) {
            newArr[j] = arr[j - 1];
        }
        System.out.println("Array before add: ");
        for (int element : arr) {
            System.out.print(element + " ");
        }
        System.out.println("\nArray after add: ");
        for (int element : newArr) {
            System.out.print(element + " ");
        }
    }

    public static void main(String[] args) {
        int[] array = {3, 5, 2, 7, 4, 1, 8, 0, 9, 3};
        Scanner scanner = new Scanner(System.in);
        int number, index;
        do {
            System.out.println("Enter position to add: ");
            index = scanner.nextInt();
            if (index <= 1 || index >= array.length - 1) {
                System.out.println("Invalid position!");
            }
        } while (index <= 1 || index >= array.length - 1);
        System.out.println("Enter number to add: ");
        number = scanner.nextInt();
        addElement(index, number, array);
    }
}
