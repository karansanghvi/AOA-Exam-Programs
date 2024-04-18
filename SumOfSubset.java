// Write a program to compute sum of subsets using Backtracking
public class SumOfSubset {
    static int[] w;
    static int m;
    static int[] x;
    public static void sumOfSub(int s, int k, int r) {
        x[k] = 1;
        if (s + w[k] == m) {
            for (int i = 1; i <= k; i++) { 
                System.out.print(x[i] + " ");
            }
            System.out.println();
        } else if (s + w[k] + w[k + 1] <= m) {
            sumOfSub(s + w[k], k + 1, r - w[k]);
        }

        if (s + r - w[k] >= m && s + w[k + 1] <= m) {
            x[k] = 0;
            sumOfSub(s, k + 1, r - w[k]);
        }
    }
    public static void main(String[] args) {
        w = new int[]{0, 2, 5, 7, 8, 10};
        m = 10;
        x = new int[w.length];
        int r = 0;
        for (int i = 1; i < w.length; i++) {
            r += w[i];
        }
        sumOfSub(0, 1, r);
    }
}
