// Write a program to solve Longest Common Subsequent problem using dynamic programming method.
public class longestcommonsubsequence {
    public static void lcsPrint(String X, int[][] C, int m, int n) {
        if (C[m][n] == 0) {
            return;
        }
        if (C[m][n] == C[m-1][n]) {
            lcsPrint(X, C, m-1, n);
        } else if (C[m][n] == C[m][n-1]) {
            lcsPrint(X, C, m, n-1);
        } else {
            lcsPrint(X, C, m-1, n-1);
            System.out.print(X.charAt(m-1) + " ");
        }
    }
    public static void main(String[] args) {
        String X = "AGGTAB";
        String Y = "GXTXAYB";
        int m = X.length();
        int n = Y.length();
        int[][] C = new int[m+1][n+1];
        for (int i = 0; i <= m; i++) {
            C[i][0] = 0;
        }
        for (int j = 0; j <= n; j++) {
            C[0][j] = 0;
        }
        for (int i = 1; i <= m; i++) {
            for (int j = 1; j <= n; j++) {
                if (X.charAt(i-1) == Y.charAt(j-1)) {
                    C[i][j] = C[i-1][j-1] + 1;
                } else {
                    C[i][j] = Math.max(C[i-1][j], C[i][j-1]);
                }
            }
        }
        System.out.println("Length of longest common subsequence: " + C[m][n]);
        System.out.print("Longest common subsequence: ");
        lcsPrint(X, C, m, n);
    }
}
