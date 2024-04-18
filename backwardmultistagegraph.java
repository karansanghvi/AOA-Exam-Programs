// Write a program to solve the given problem instance of Multistage graphs with backward Approach using Dynamic Programming.
public class backwardmultistagegraph {
    public static void bgraph(int[][] graph, int k, int n, double[] bcost, int[] p) {
        double[] cost = new double[n+1];
        int[] d = new int[n+1];
        bcost[1] = 0.0;         // initialization
        for (int j = 2; j <= n; j++) {
            bcost[j] = bcost[d[j]] + graph[d[j]][j];
            d[j] = 1;
            for (int r = 2; r <= k; r++) {
                if (bcost[j] > bcost[d[j]] + graph[d[j]][j]) {
                    bcost[j] = bcost[d[j]] + graph[d[j]][j];
                    d[j] = r;
                }
            }
        }
        p[1] = 1;         // backward pass
        p[k] = n;
        for (int j = k-1; j >= 2; j--) {
            p[j] = d[p[j+1]];
        }
    }
    public static void main(String[] args) {
        int[][] graph = {{0, 0, 0, 0, 0, 0},
                         {0, 0, 2, 1, 3, 0},
                         {0, 0, 0, 0, 0, 2},
                         {0, 0, 0, 0, 0, 1},
                         {0, 0, 0, 0, 0, 5},
                         {0, 0, 0, 0, 0, 0}};
        int k = 3;
        int n = 5;
        double[] bcost = new double[n+1];
        int[] p = new int[k+1];
        bgraph(graph, k, n, bcost, p);
        System.out.println("Minimum cost: " + bcost[n]);         // print results
        System.out.print("Shortest path: ");
        for (int i = 1; i <= k; i++) {
            System.out.print(p[i] + " ");
        }
        System.out.println();
    }
}
