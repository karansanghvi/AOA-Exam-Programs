// Write a program to solve the given problem instance of Multistage graphs with forward Approach using Dynamic Programming.
import java.util.*;
public class forwardmultistage {
    public static double[] computeCost(int[][] graph, int k, int n) {
        double[] cost = new double[n+1];
        int[] d = new int[n+1];
        int r;
        for (int j = n-1; j >= 1; j--) {
            r = n;
            for (int i = j+1; i <= n; i++) {
                if (graph[j][i] != 0 && (r == n || cost[i]+graph[j][i] < cost[r]+graph[j][r])) {
                    r = i;
                }
            }
            cost[j] = graph[j][r] + cost[r];
            d[j] = r;
        }
        int[] p = new int[k];
        p[0] = 1;
        p[k-1] = n;
        for (int j = 1; j < k-1; j++) {
            p[j] = d[p[j-1]];
        }
        return cost;
    }
    public static void main(String[] args) {
        int[][] graph = {
            {0, 0, 0, 0, 0, 0, 0},
            {0, 0, 1, 2, 0, 0, 0},
            {0, 0, 0, 0, 2, 3, 0},
            {0, 0, 0, 0, 6, 7, 0},
            {0, 0, 0, 0, 0, 0, 2},
            {0, 0, 0, 0, 0, 0, 1},
            {0, 0, 0, 0, 0, 0, 0}
        };
        int k = 4;
        int n = 6;
        double[] cost = computeCost(graph, k, n);
        System.out.println(Arrays.toString(cost)); 
    }
}
