package b3_array_method_java.bai_tap;

import java.util.Scanner;

public class ArrayDeleteElement {
    public static int isExist(int number, int[] arr) {
        int index = -1;
        for (int i = 0; i < arr.length; i++) {
            if (arr[i] == number) {
                index = i;
                break;
            }
        }
        return index;
    }

    public static void deleteElement(int index, int[] arr) {
        int[] newArr = new int[arr.length - 1];
        for (int i = 0; i < index; i++) {
            newArr[i] = arr[i];
        }
        for (int j = index + 1; j < arr.length; j++) {
            newArr[j - 1] = arr[j];
        }
        System.out.println("Array after delete: ");
        for (int element : newArr) {
            System.out.print(element + " ");
        }
    }

    public static void main(String[] args) {
        int[] array = {1, 3, 9, 6, 7, 5};
        Scanner scanner = new Scanner(System.in);
        int num, index;
        do {
            System.out.println("Enter element to delete: ");
            num = scanner.nextInt();
            if (isExist(num, array) == -1) {
                System.out.println(num + " not exist in this array!");
            }
            index = isExist(num, array);
        } while (isExist(num, array) == -1);
        System.out.println("\nArray before delete: ");
        for (int element : array) {
            System.out.print(element + " ");
        }
        deleteElement(index, array);

    }
}
