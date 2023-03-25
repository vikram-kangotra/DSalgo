public class MatrixPatterns{

    public void printSnakePattern(int[][] matrix){
        int cols = matrix[0].length;
        int rows = matrix.length;
            for(int i=0; i<rows; i++){
                if(i%2 == 0){
                    for(int j=0; j<cols; j++){
                         System.out.print(matrix[i][j] + " ");
                    }
                }else{
                    for(int j=cols-1; j>=0; j--){
                         System.out.print(matrix[i][j] + " ");
                    }
                }
            }
    }

    public void boundaryTraversal(int[][] matrix){
        int cols = matrix[0].length;
        int rows = matrix.length;
        if(rows == 1){
            for(int i=0; i<cols; i++){
                System.out.print(matrix[0][i] + " ");
            }
            return;
        }
        if(cols == 1){
            for(int i=0; i<rows; i++){
                System.out.print(matrix[i][0] + " ");
            }
            return;
        }

        for(int i=0; i<cols; i++){
            System.out.print(matrix[0][i] + " ");
        }
        for(int i=1; i<rows; i++){
            System.out.print(matrix[i][cols-1] + " ");
        }
        for(int i=cols-2; i>=0; i--){
            System.out.print(matrix[rows-1][i] + " ");
        }
        for(int i=rows-2; i>=1; i--){
            System.out.print(matrix[i][0] + " ");
        }
    }

    /*
     * Given a matrix of m x m elements (m rows, m columns), return its transpose.
     * The transpose of a matrix is the matrix flipped over its main diagonal, switching the matrix's row and column indices.
     * In place solution
    
    */

    public void transpose(int[][] matrix){
        int cols = matrix[0].length;
        int rows = matrix.length;
        for(int i=0; i<rows; i++){
            for(int j= i+1; j<cols; j++){
                int temp = matrix[i][j];
                matrix[i][j] = matrix[j][i];
                matrix[j][i] = temp;
            }
        }
    }

    /* Rotate the matrix by 90 degrees
    * In place solution
    * 1. Transpose the matrix
    * 2. Reverse each column
    
    * Time Complexity: O(n^2)
    * Space Complexity: O(1)
    
    */

    public void rotateBy90(int[][] matrix){
        transpose(matrix);
        int cols = matrix[0].length;
        int rows = matrix.length;
        for(int i=0; i<cols; i++){
            int start = 0;
            int end = rows-1;
            while(start < end){
                int temp = matrix[start][i];
                matrix[start][i] = matrix[end][i];
                matrix[end][i] = temp;
                start++;
                end--;
            }
        }
    }

    /*
     * Spiral Traversal of a matrix
     * 
     * Time Complexity: O(n^2)
     * Space Complexity: O(1)
     */

    public void spiralTraversal(int[][] matrix){
        int cols = matrix[0].length;
        int rows = matrix.length;
        int top = 0;
        int bottom = rows-1;
        int left = 0;
        int right = cols-1;
        while(top <= bottom && left <= right){
            for(int i=left; i<=right; i++){
                System.out.print(matrix[top][i] + " ");
            }
            top++;
            for(int i=top; i<=bottom; i++){
                System.out.print(matrix[i][right] + " ");
            }
            right--;
            if(top <= bottom){
                for(int i=right; i>=left; i--){
                    System.out.print(matrix[bottom][i] + " ");
                }
                bottom--;
            }
            if(left <= right){
                for(int i=bottom; i>=top; i--){
                    System.out.print(matrix[i][left] + " ");
                }
                left++;
            }
        }
    }

    public void printMatrix(int[][] matrix){
        int cols = matrix[0].length;
        int rows = matrix.length;
        for(int i=0; i<rows; i++){
            for(int j=0; j<cols; j++){
                System.out.print(matrix[i][j] + " ");
            }
            System.out.println();
        }
    }

    public static void main(String[] args) {
        MatrixPatterns mp = new MatrixPatterns();
        int[][] matrix = {{1,2,3,4},{5,6,7,8},{9,10,11,12},{13,14,15,16}};
        mp.printSnakePattern(matrix);
        System.out.println();
        mp.boundaryTraversal(matrix);
        System.out.println();
        mp.rotateBy90(matrix);
        mp.printMatrix(matrix);
        System.out.println();
        mp.spiralTraversal(matrix);
        mp.printMatrix(matrix);
        System.out.println();
    }
    


}