// WAP to implement recursive binary search algorithm using divide and conquer approach
public class recursivebinarysearch {
    public static final int KEY_NOT_FOUND = -1;
    public static int binarySearching(int[] A, int key, int imin, int imax) {
        if(imax < imin) {
            return KEY_NOT_FOUND;
        }
        else {
            int imid = (imin + imax) /2;             // formula
            if(A[imid] > key) {            // three way comparison
                return binarySearching(A, key, imin, imid-1);                // key is in lower subset
            }
            else if(A[imid] < key) {
                return binarySearching(A, key, imid+1, imax);                // key is in higher subset
            }
            else {
                return imid;                // key found
            }
        }
    }
    public static void main(String[] args) {
        int[] A = {1,2,3,4,5,6,7,8,9};
        int key = 6;
        int index = binarySearching(A, key, 0, A.length-1);
        if(index != KEY_NOT_FOUND) {
            System.out.println("Key found at index: " + index);
        }
        else {
            System.out.println("Key not found");
        }
    }
}
