package b3_array_method_java.bai_tap;

import java.util.Scanner;

public class ArrayMinElement {
    public static int minElement(int[] arr) {
        int min = arr[0];
        int index = -1;
        for (int i = 0; i < arr.length; i++) {
            if (arr[i] < min) {
                min = arr[i];
                index = i;
            }
        }
        return index;
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Enter number of elements: ");
        int countElement = scanner.nextInt();
        int[] arr = new int[countElement];
        for (int i = 0; i < arr.length; i++) {
            System.out.println("Enter arr[" + i + "]: ");
            arr[i] = scanner.nextInt();
        }
        for (int element : arr) {
            System.out.print(element + " ");
        }
        int index = minElement(arr);
        System.out.println("The smallest element in the array is: " + arr[index]);
    }
}
