public class SudokuProblem {
    private int[][] board;
    private int N;
    public SudokuProblem(int[][] board){
        this.board = board;
        this.N = board.length;
    }

    private void printSolution(){
        for (int i = 0; i < N; i++){
            for (int j = 0; j < N; j++){
                System.out.print(board[i][j] + " ");
            }
            System.out.println();
        }
    }

    private boolean isSafe(int[][] board, int row, int col, int num){
        for (int i = 0; i < N; i++){
            if (board[row][i] == num){
                return false;
            }
            if (board[i][col] == num){
                return false;
            }
        }
        int sqrt = (int) Math.sqrt(N);
        int boxRowStart = row - row % sqrt;
        int boxColStart = col - col % sqrt;
        for (int i = boxRowStart; i < boxRowStart + sqrt; i++){
            for (int j = boxColStart; j < boxColStart + sqrt; j++){
                if (board[i][j] == num){
                    return false;
                }
            }
        }
        return true;
    }
    private boolean solveSudokuUtility(int[][] board, int N){
        int row = -1;
        int col = -1;
        boolean isEmpty = true;
        for (int i = 0 ; i < N; i++){
            for (int j = 0 ; j < N; j++){
                if (board[i][j] == 0){
                    row = i;
                    col = j;
                    isEmpty = false;
                    break;
                }
            }
            if (!isEmpty){
                break;
            }
        }

        if (isEmpty){
            return true;
        }

        for (int num = 1; num <= N; num++){
            if (isSafe(board,row,col,num)){
                board[row][col] = num;
                if (solveSudokuUtility(board,N)){
                    return true;
                }
                else{
                    board[row][col] = 0;
                }
            }
        }
        return false;
    }


    public boolean solve(){
        if (!solveSudokuUtility(board,N)){
            System.out.println("Solution doesn't exist!");
            return false;
        }
        printSolution();
        return true;
    }


}
