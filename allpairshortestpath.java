// Write a program to compute All Pair Shortest Path using Dynamic Programming
public class allpairshortestpath {
    void calculate(int arr[][], int noofVertices) {
        for (int k = 0; k < noofVertices; k++) {
            for (int i = 0; i < noofVertices; i++) {
                for (int j = 0; j < noofVertices; j++) {
                    arr[i][j] = Math.min(arr[i][j], arr[i][k] + arr[k][j]);
                }
            }
        }
        for (int i = 0; i < noofVertices; i++) {
            for (int j = 0; j < noofVertices; j++) {
                System.out.print(arr[i][j] + " ");
            }
            System.out.println();
        }
    }
    public static void main(String args[]) {
        allpairshortestpath sc = new allpairshortestpath();
        int graphMatrix[][] = {
                { 0, 4, 11 },
                { 6, 0, 2 },
                { 3, 100000, 0 }
        };
        sc.calculate(graphMatrix, 3);
    }
}
