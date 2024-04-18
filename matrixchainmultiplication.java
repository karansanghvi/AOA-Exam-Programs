// Write a program to compute Matrix Chain Multiplication using Dynamic Programming.
public class matrixchainmultiplication {
    public static int matrix(int p[], int n) {
        int m[][] = new int [n][n];
        int i,j,k,L,q;
        for(i = 1; i < n; i++) {         // cost is zero when matrix one
            m[i][i] = 0;
        }
        for(L = 2; L < n; L++) {         // L is the chain length
            for(i = 1; i < n-L+1; i++)
            {
                j = i+L-1;
                if(i==n)
                continue;
                m[i][j] = Integer.MAX_VALUE;
                for(k=i; k<=j-1; k++) {
                    q = m[i][k] + m[k+1][j] + p[i-1] * p[k] * p[j]; // formula for matrix chain
                    if(q < m[i][j])
                    m[i][j] = q; 
                }
            }
        }
        return m[1][n-1];
    }
    public static void main(String[] args) {
        int arr[] = new int[] {5,7,8,4,3};
        int size = arr.length;
        System.out.println("Minimum cost is: " + matrix(arr, size));
    } 
}
