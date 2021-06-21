package b3_array_method_java.bai_tap;

import java.util.Scanner;

public class MaxElement2DimensionalArray {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Enter rows of matrix: ");
        int row = scanner.nextInt();
        System.out.println("Enter column of matrix: ");
        int column = scanner.nextInt();
        float[][] matrix = new float[row][column];
        for (int i = 0; i < row; i++) {
            for (int j = 0; j < column; j++) {
                System.out.print("Enter matrix[" + i + "][" + j + "]: ");
                matrix[i][j] = scanner.nextFloat();
            }
        }
        System.out.println("Matrix: ");
        for (int i = 0; i < row; i++) {
            for (int j = 0; j < column; j++) {
                System.out.print(matrix[i][j] + " ");
            }
            System.out.println();
        }
        float max = matrix[0][0];
        for (int i = 0; i < row; i++) {
            for (int j = 0; j < column; j++) {
                if (matrix[i][j] > max) {
                    max = matrix[i][j];
                }
            }
        }
        System.out.println("Max element in this matrix is: " + max);
    }
}
