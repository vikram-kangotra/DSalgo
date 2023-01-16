public class Knights_tour_problem {
    private int N;

    public Knights_tour_problem(int N){
        this.N = N;
    }

    private void printSolution(int[][] board){
        for (int i = 0; i < N; i++){
            for (int j = 0; j < N; j++){
                System.out.print(board[i][j] + " ");
            }
            System.out.println();
        }
    }

    private boolean isSafe(int x, int y, int[][] board){
        return (x >= 0 && x < N && y >= 0 && y < N && board[x][y] == -1);
    }
    private boolean solveUtility(int[][] board, int x, int y, int move, int[] xMoves, int[] yMoves){
        if (move == N*N){
            return true;
        }
        for (int i = 0; i < 8; i++){
            int nextX = x + xMoves[i];
            int nextY = y + yMoves[i];
            if (isSafe(nextX, nextY, board)){
                board[nextX][nextY] = move;
                if (solveUtility(board, nextX, nextY, move+1, xMoves, yMoves)){
                    return true;
                }
                board[nextX][nextY] = -1;
            }
        }
        return false;
    }

    public boolean solve(){
        int[][] board = new int[N][N];
        for (int i = 0; i < N; i++){
            for (int j = 0; j < N; j++){
                board[i][j] = -1;
            }
        }

        int[] xMoves = {2, 1, -1, -2, -2, -1, 1, 2};
        int[] yMoves = {1, 2, 2, 1, -1, -2, -2, -1};

        board[0][0] = 0;

        if(!solveUtility(board, 0, 0, 1, xMoves, yMoves)){
            System.out.println("No solution");
            return false;
        }
        printSolution(board);
        return true;
    }
}
