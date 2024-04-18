// Write a program to compute Single Source Shortest Path using Greedy Method
import java.util.*;
public class singlesourceshortestpath {
    public static void shortestPath(int v, double[][] cost, double[] dist, int n) {
        boolean[] s = new boolean[n];
        for (int i = 0; i < n; i++) {
            s[i] = false;
            dist[i] = cost[v][i];
        }
        s[v] = true;
        dist[v] = 0.0;
        for (int num = 2; num <= n; num++) {
            int u = -1;
            double minDist = Double.MAX_VALUE;
            for (int w = 0; w < n; w++) {
                if (!s[w] && dist[w] < minDist) {
                    u = w;
                    minDist = dist[w];
                }
            }
            s[u] = true;
            for (int w = 0; w < n; w++) {
                if (!s[w] && dist[w] > dist[u] + cost[u][w]) {
                    dist[w] = dist[u] + cost[u][w];
                }
            }
        }
    }
    public static void main(String[] args) {
        double[][] graph = {
                {0, 2, 4, 0, 0},
                {0, 0, 1, 7, 0},
                {0, 0, 0, 3, 2},
                {0, 0, 0, 0, 1},
                {0, 0, 0, 0, 0}
        };
        int sourceVertex = 0;
        int numVertices = graph.length;
        double[] distances = new double[numVertices];
        singlesourceshortestpath.shortestPath(sourceVertex, graph, distances, numVertices);
        for (int i = 0; i < numVertices; i++) {
            System.out.println("Shortest distance from vertex " + sourceVertex + " to vertex " + i + " is " + distances[i]);
        }
    }    
}