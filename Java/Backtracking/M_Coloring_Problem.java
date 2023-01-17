public class M_Coloring_Problem {
    private int[][] graph;
    private int V;
    private int M;

    public M_Coloring_Problem(int[][] graph, int M){
        this.graph = graph;
        this.V = graph.length;
        this.M = M;
    }

    private void printSolution(int[] colors){
        for (int i = 0; i < V; i++){
            System.out.print(colors[i] + " ");
        }
        System.out.println();
    }
    private boolean isSafe(int vertex, int color, int[] colors){
        for (int i = 0; i < V; i++){
            if (graph[vertex][i] == 1 && color == colors[i]){
                return false;
            }
        }
        return true;
    }

    private boolean graphColoringUtility(int[] colors, int vertex){
        if (vertex == V) return true;
        for (int color = 1; color <= M; color++){
            if (isSafe(vertex, color, colors)){
                colors[vertex] = color;
                if (graphColoringUtility(colors, vertex+1)){
                    return true;
                }
                colors[vertex] = 0;
            }
        }
        return false;
    }
    public boolean graphColoring(){
        int[] colors = new int[V];
        for (int i = 0; i < V; i++){
            colors[i] = 0;
        }
        if (graphColoringUtility(colors, 0)){
            printSolution(colors);
            return true;
        }
        System.out.println("No solution");
        return false;
    }
}
