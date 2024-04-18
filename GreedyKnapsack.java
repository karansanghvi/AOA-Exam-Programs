// Write a program to solve knapsack problem using Greedy method
public class GreedyKnapsack {
    public static void knapsack(double[] w, double[] p, double m) {
        int n = w.length;
        double[] x = new double[n];
        double U = m;
        int i; // declare i before loop
        for (i = 0; i < n; i++) {
            if (w[i] > U) {
                break;
            }
            x[i] = 1.0;
            U -= w[i];
        }
        if (U > 0 && i < n) {
            x[i] = U / w[i];
        }
        double totalProfit = 0.0;
        for (i = 0; i < n; i++) {
            totalProfit += x[i] * p[i];
        }
        System.out.println("Total profit: " + totalProfit);
    }
    public static void main(String[] args) {
        double[] weights = {10, 20, 30};
        double[] profits = {60, 100, 120};
        double maxWeight = 50;
        knapsack(weights, profits, maxWeight);
    }
}
