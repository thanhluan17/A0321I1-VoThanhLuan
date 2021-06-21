package b3_array_method_java.bai_tap;

import java.util.Scanner;

public class MergeArray {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("1st array, enter number of elements: ");
        int countElement = scanner.nextInt();
        int[] arrayA = new int[countElement];
        for (int i = 0; i < arrayA.length; i++) {
            System.out.println("Enter element at " + (i + 1) + ": ");
            arrayA[i] = scanner.nextInt();
        }
        System.out.println("Array A: ");
        for (int element : arrayA) {
            System.out.print(element + " ");
        }

        System.out.println("\n2nd array, enter number of elements: ");
        countElement = scanner.nextInt();
        int[] arrayB = new int[countElement];
        for (int i = 0; i < arrayB.length; i++) {
            System.out.println("Enter element at " + (i + 1) + ": ");
            arrayB[i] = scanner.nextInt();
        }
        System.out.println("Array B: ");
        for (int element : arrayB) {
            System.out.print(element + " ");
        }

        int[] arrayC = new int[arrayA.length + arrayB.length];
        for (int i = 0; i < arrayA.length; i++) {
            arrayC[i] = arrayA[i];
        }
        for (int j = 0; j < arrayB.length; j++) {
            arrayC[arrayA.length + j] = arrayB[j];
        }

        System.out.println("\nArray after merge two array:");
        for (int element : arrayC) {
            System.out.print(element + " ");
        }
    }
}
