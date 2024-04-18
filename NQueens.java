// WAP to implement n queen problem using backtracking
public class NQueens {
    int[] x;
    int n;
    public NQueens(int n) {
        this.n = n;
        x = new int[n+1];
    }
    public boolean place(int k, int i) {
        for (int j = 1; j < k; j++) {
            if (x[j] == i || Math.abs(x[j] - i) == Math.abs(j - k)) {
                return false;
            }
        }
        return true;
    }
    public void nQueens(int k) {
        for (int i = 1; i <= n; i++) {
            if (place(k, i)) {
                x[k] = i;
                if (k == n) {
                    printBoard(); // solution found, print the board
                } else {
                    nQueens(k+1);
                }
            }
        }
    }
    private void printBoard() {
        for (int i = 1; i <= n; i++) {
            for (int j = 1; j <= n; j++) {
                if (x[i] == j) {
                    System.out.print("Q ");
                } else {
                    System.out.print(". ");
                }
            }
            System.out.println();
        }
        System.out.println();
    }
    public static void main(String[] args) {
        NQueens nq = new NQueens(4);
        nq.nQueens(1);
    }
}
