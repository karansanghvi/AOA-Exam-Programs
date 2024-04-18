// Write a program to sort the given list using Randomized quick sort
import java.util.*;
public class RandomizedQuickSort {
    public static void randomizedQuickSort(int[] arr, int p, int q) {
        if(p < q) {
            if((q-p) > 5) {
                int randomIndex = new Random().nextInt(q-p+1) + p;
                swap(arr, randomIndex, p);
            }
            int j = partition(arr, p, q+1);
            randomizedQuickSort(arr, p, j-1);
            randomizedQuickSort(arr, j+1, q);
        }
    }
    private static int partition(int[] arr, int p, int r) {
        int pivot = arr[p];
        int i = p;
        int j = r;
        while(i < j) {
            do {
                i++;
            } while(i < j && arr[i] <= pivot);
            
            do {
                j--;
            } while(j >= i && arr[j] > pivot);
            
            if(i < j) {
                swap(arr, i, j);
            }
        }
        swap(arr, p, j);
        return j;
    }
    private static void swap(int[] arr, int i, int j) {
        int temp = arr[i];
        arr[i] = arr[j];
        arr[j] = temp;
    }
    public static void main(String[] args) {
        int[] arr = {5, 2, 9, 1, 5, 6, 3};
        System.out.println("Original Array: " + Arrays.toString(arr));
        randomizedQuickSort(arr, 0, arr.length-1);
        System.out.println("Sorted Array: " + Arrays.toString(arr));
    }
}
