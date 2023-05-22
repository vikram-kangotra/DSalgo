public class HamiltonianCycleProblem {
    int[][] graph;
    int V;

    public HamiltonianCycleProblem(int[][] graph){
        this.graph = graph;
        this.V = graph.length;
    }

    private void printSolution(int[] path){
        for (int i = 0; i < V; i++){
            System.out.print(path[i] + " ");
        }
        System.out.println(path[0]);
    }

    private boolean isSafe(int vertex, int[] path, int pos){
        if (graph[path[pos-1]][vertex] == 0){
            return false;
        }
        for (int i = 0; i < pos; i++){
            if (path[i] == vertex){
                return false;
            }
        }
        return true;
    }
    private boolean solveUtility(int[] path, int pos){
        if (pos == V){
            if (graph[path[pos-1]][path[0]] == 1){
                return true;
            } else {
                return false;
            }
        }

        for (int v = 1; v < V; v++){
            if (isSafe(v, path, pos)){
                path[pos] = v;
                if (solveUtility(path, pos+1)){
                    return true;
                }
                path[pos] = -1;
            }
        }
        return false;
    }
    public boolean solve(){
        int[] path = new int[V];
        for (int i = 0 ; i < V; i++){
            path[i] = -1;
        }
        path[0] = 0;
        if (!solveUtility(path, 1)){
            System.out.println("No solution");
            return false;
        }

        printSolution(path);
        return true;
    }
}
