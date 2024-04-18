// WAP to sort a program using insertion sort and selection sort
import java.util.*;
public class insertionandselectionsort {
    public static void insertionSort(int[] arr) {
        int n = arr.length;
        for (int k = 1; k < n; k++) {
            int temp = arr[k];
            int j = k - 1;
            while (j >= 0 && temp < arr[j]) {
                arr[j + 1] = arr[j];
                j--;
            }
            arr[j + 1] = temp;
        }
    }
    public static void selectionSort(int[] arr) {
        int n = arr.length;
        for (int k = 0; k < n - 1; k++) {
            int pos = k;
            for (int j = k + 1; j < n; j++) {
                if (arr[j] < arr[pos]) {
                    pos = j;
                }
            }
            int temp = arr[k];
            arr[k] = arr[pos];
            arr[pos] = temp;
        }
    }
    public static void main(String[] args) {
        int[] arr = {3, 7, 1, 8, 2, 5, 6, 4};
        System.out.println("Original Array: " + Arrays.toString(arr));
        insertionSort(arr); // Sorting using Insertion Sort
        System.out.println("Array after Insertion Sort: " + Arrays.toString(arr));
        int[] arr2 = {3, 7, 1, 8, 2, 5, 6, 4}; // Re-initialize the array
        selectionSort(arr2); // Sorting using Selection Sort
        System.out.println("Array after Selection Sort: " + Arrays.toString(arr2));
    }
}
