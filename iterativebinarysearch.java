// WAP to impelement iterative binary search algorithm using divide and conquer approach
public class iterativebinarysearch {
    public static int search(int[] a, int n, int x) {
        int low = 0;
        int high = n-1;
        while(low <= high) {
            int mid = (low+high)/2;
            if (x<a[mid]) {
                high = mid - 1;
            }
            else if (x>a[mid]) {
                low = mid + 1;
            }
            else {
                return mid;
            }
        }
        return -1; //if not found then return -1
    }
    public static void main(String[] args) {
        int[] a = {1,3,5,7,9};
        int n = a.length;
        int x = 5;
        int index = iterativebinarysearch.search(a, n, x);
        if(index == -1) {
            System.out.println("Value not found!!");
        }
        else {
            System.out.println("Value found at index: " + index);
        }
    }
}
