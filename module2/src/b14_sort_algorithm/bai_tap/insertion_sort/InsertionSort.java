package b14_sort_algorithm.bai_tap.insertion_sort;

public class InsertionSort {
    public static void insertionSort(int[] arr) {
        for (int i = 1; i < arr.length; i++) {
            int key = arr[i];
            int j = i - 1;

            while (j >= 0 && arr[j] > key) {
                arr[j + 1] = arr[j];
                j--;
            }
            System.out.println("Chèn " + key + " trước " + arr[j + 1]);
            arr[j + 1] = key;
        }
    }

    public static void main(String[] args) {
        int[] arr = {15, 9, 7, 21, 18, 3, 10};
        InsertionSort.insertionSort(arr);
        for (int i = 0; i < arr.length; i++) {
            System.out.print(arr[i] + " ");
        }
    }
}
