public class Problems {
    
   /*
   * Search in a row wise and column wise sorted matrix
   * Given an n x n matrix and a number x, find the position of x in the matrix if it is present in it.
   * Otherwise, print “Not Found”. In the given matrix, every row and column is sorted in increasing order.
   * Time Complexity: O(m+n)
   
   */ 
    public void searchInSortedMatrix(int[][] matrix, int x){
        int rows = matrix.length;
        int cols = matrix[0].length;
        int i=0;
        int j=cols-1;
        while(i<rows && j>=0){
            if(matrix[i][j] == x){
                System.out.println("Found at: " + i + " " + j);
                return;
            }
            if(matrix[i][j] > x){
                j--;
            }else{
                i++;
            }
        }
        System.out.println("Not Found");
    }


    public static void main(String[] args) {
        int[][] matrix = {{1,2,3,4},
                          {5,6,7,8},
                          {9,10,11,12},
                          {13,14,15,16}};
        Problems p = new Problems();
        p.searchInSortedMatrix(matrix, 16);
        
    }
}
