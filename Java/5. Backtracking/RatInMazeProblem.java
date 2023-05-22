public class RatInMazeProblem{
    private int[][] maze;
    private int N;

    public RatInMazeProblem(int[][] maze){
        this.maze = maze;
        this.N = maze.length;
    }

    private void printSolution(int[][] sol){
        for (int i = 0; i < N; i++){
            for (int j = 0; j < N; j++){
                System.out.print(sol[i][j] + " ");
            }
            System.out.println();
        }
    }

    private boolean isSafe(int row, int col){
        return (row >= 0 && row < N && col >= 0 && col < N && maze[row][col] == 1);
    }

    private boolean solveMazeUtility(int[][] board, int row, int col,int[][] sol){
        if (row == N - 1 && col == N - 1 && board[row][col] == 1) {
            sol[row][col] = 1;
            return true;
        }
        if (isSafe(row,col)){
            if (sol[row][col] == 1) return false;
            sol[row][col] = 1;
            if (solveMazeUtility(board, row+1, col,sol)){
                return true;
            }
            if (solveMazeUtility(board, row, col+1,sol)){
                return true;
            }
            sol[row][col] = 0;
        }
        return false;
    }

    public boolean solveMaze(){
        
        int sol[][] = new int[N][N];
        if (solveMazeUtility(maze, 0, 0,sol)){
            printSolution(sol);
            return true;
        }

        System.out.println("No solution");
        return false;
    }
}
