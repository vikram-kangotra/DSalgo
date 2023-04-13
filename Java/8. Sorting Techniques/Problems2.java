public class Problems2 {
    
    /*
     * Sorting an array with two types of elements
     * Different forms of such arrays are:
     * 1. 0s and 1s 
     * 2. Negative numbers on left side and positive numbers on right side
     * 3. Even numbers on left side and odd numbers on right side
     * 4. Numbers less than a given number on left side and numbers greater than the given number on right side
     * 5. Numbers less than or equal to a given number on left side and numbers greater than the given number on right side
     * 
     */

    /*
     * These types of arrays can be sorted using the variation of Lomanuto Partitioning technique or Hoare Partitioning technique
     */

    public void segregatePositiveAndNegative(int[] arr){
        int i = -1;
        int j = arr.length;
        while(true){
            do{
                i++;
            }while(arr[i] < 0);
            do{
                j--;
            }while(arr[j] >= 0);
            if(i >= j){
                return;
            }
            int temp = arr[i];
            arr[i] = arr[j];
            arr[j] = temp;
        }
    }

    
}
