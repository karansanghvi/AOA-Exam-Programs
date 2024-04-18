//Write a program to sort the given list using quick sort.
public class quicksort {
    public static void printArr(int arr[]) { //to print the array
        for(int i=0; i<arr.length; i++) {
            System.out.println(arr[i] + " ");
        }
        System.out.println();
    }
    public static void quickSort(int arr[], int si, int ei) {
        if(si >= ei) {  // base case
            return;
        }
        int pidx = partition(arr, si, ei);        // last element
        quickSort(arr, si, pidx-1);        // left part
        quickSort(arr, pidx+1, ei);         // right part
    }
    public static int partition(int arr[], int si, int ei) {     // partiton
        int pivot = arr[ei];   
        int i = si-1; 
        for(int j=si; j<ei; j++) {
            if(arr[j] <= pivot) {
                i++;
                int temp = arr[j];                // swap
                arr[j] = arr[i];
                arr[i] = temp;
            }
        }
        i++;
        int temp = pivot;        // swap
        arr[ei] = arr[i];
        arr[i] = temp;
        return i;
    }
    public static void main(String[] args) {
        int arr[] = {6, 3, 9, 8, 2, 5};
        quickSort(arr, 0, arr.length-1);
        printArr(arr);
    }
}

