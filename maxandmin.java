// Write a program to find maximum and minimum element from the given list, using Divide and conquer and straightforward approach
public class maxandmin {
    private static int[] A;
    public static void getMaxMain(int i, int j, int[] result) {
        if(i==j) {
            result[0] = A[i];
            result[1] = A[i];
        }
        else if(i==j-1) {
            if(A[i]<A[j]) {
                result[0] = A[j];
                result[1] = A[i];
            } 
            else {
                result[0] = A[i];
                result[1] = A[j];
            }
        }
        else {
            int[] leftResult = new int[2];
            int[] rightResult = new int[2];
            int mid = (i+j)/2;
            getMaxMain(i, mid, leftResult);
            getMaxMain(mid+1, j, rightResult);
            result[0] = Math.max(leftResult[0], rightResult[0]);
            result[1] = Math.min(leftResult[1], rightResult[1]);
        }
    }
    public static void main(String[] args) {
        A = new int[] {5,2,7,3,9,1,8,4,6};
        int[] result = new int[2];
        getMaxMain(0, A.length-1, result);
        System.out.println("Max: " + result[0]);
        System.out.println("Min: " + result[1]);
    }
}