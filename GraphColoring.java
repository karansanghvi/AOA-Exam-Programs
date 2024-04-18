/* Write a program to solve given graph coloring problem For the given graph, compute the minimum chromatic number to color the graph
such that no two adjacent vertices have the same color. Give all possible combinations of such color assignments. */
public class GraphColoring {
    private int[][] graph; // adjacency matrix representation of the graph
    private int numColors; // number of colors available
    private int[] color; // current coloring of the graph
    public GraphColoring(int[][] graph, int numColors) {
        this.graph = graph;
        this.numColors = numColors;
        this.color = new int[graph.length];
    }
    public void mColoring() {
        mColoring(0);
    }
    private void mColoring(int k) {
        do {
            nextValue(k);
            if (color[k] == 0) {
                return; // all colors have been tried
            }
            if (k == graph.length - 1) {
                printColoring();
            } else {
                mColoring(k + 1);
            }
        } while (true);
    }
    private void nextValue(int k) {
        do {
            color[k] = (color[k] + 1) % (numColors + 1);
            if (color[k] == 0) {
                return; // all colors have been tried
            }
            int j;
            for (j = 0; j < graph.length; j++) {
                if (graph[k][j] != 0 && color[k] == color[j]) {
                    break; // conflict with adjacent vertex
                }
            }
            if (j == graph.length) {
                return; // no conflict found
            }
        } while (true);
    }
    private void printColoring() {
        for (int i = 0; i < graph.length; i++) {
            System.out.println("Vertex " + i + " is colored with " + color[i]);
        }
        System.out.println();
    }
    public static void main(String[] args) {
        int[][] graph = {
            {0, 1, 1, 0},
            {1, 0, 1, 1},
            {1, 1, 0, 1},
            {0, 1, 1, 0}
        };
        int numColors = 3;
        GraphColoring gc = new GraphColoring(graph, numColors);
        gc.mColoring();        
    }
}

