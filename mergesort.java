//Write a program to sort the given list of merge sort using divide and conquer.
public class mergesort {
    public static void printArr(int arr[]) {     //to print the array
        for(int i=0; i<arr.length; i++) {
            System.out.println(arr[i] + " ");
        }
        System.out.println();
    }
    public static void merge(int arr[], int si, int ei) {
        if(si >= ei) {         // base case
            return;
        }
        int mid = si + (ei - si) / 2;   
        merge(arr, si, mid); //left part
        merge(arr, mid+1, ei); //right part
        mergearray(arr, si, mid, ei);
    }
    public static void mergearray(int arr[], int si, int mid, int ei) {
        int temp[] = new int[ei-si+1];
        int i = si; //iterator for left part
        int j = mid + 1; //iterator for right part
        int k = 0; //iterator for temp array
        while(i <= mid && j <= ei) {         //comparing the elements and copying them
            if(arr[i] < arr[j]) {
                temp[k] = arr[i];
                i++; 
            }
            else {
                temp[k] = arr[j];
                j++;
            }
            k++;
        }
        while(i <= mid) {         
            temp[k++] = arr[i++]; 
        }
        while(j <= ei) {      
            temp[k++] = arr[j++]; 
        }
        for(k = 0, i = si; k < temp.length; k++, i++) {         //copy temp to original array
            arr[i] = temp[k];
        }
    }
    public static void main(String[] args) {
        int arr[] = {6, 3, 9, 5, 2, 8};
        merge(arr, 0, arr.length-1);
        printArr(arr);
    }
}