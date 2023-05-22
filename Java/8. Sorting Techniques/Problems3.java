public class Problems3 {
    
    /*
     * Sorting an array with three types of elements
     * Different forms of such arrays are:
     * 1. 0s, 1s and 2s
     * 2. Negative numbers, 0s and positive numbers
     * 3. Partion around a range
     * 4. Partion around a range with duplicates
     * 5. Three way partitioning 
     * 
     * Examples:
     * 1. 0 1 2 0 1 2 After sorting: 0 0 1 1 2 2
     * 2. -1 2 -3 4 5 6 -7 8 9 After sorting: -7 -3 -1 2 4 5 6 8 9
     * 3. 5 13 6 9 12 11 8 7 4 2 4 3 15 10 14 After sorting: 2 3 4 4 5 6 7 8 9 10 11 12 13 14 15
     * 4. 1 14 5 20 4 2 54 20 87 98 3 1 32 After sorting: 1 1 2 3 4 4 5 14 20 20 32 54 87 98
     * 5. 1 14 5 20 4 2 54 20 87 98 3 1 32 After sorting: 1 1 2 3 4 4 5 14 20 20 32 54 87 98
     * 
     */

     /*
      * Dutch National Flag Algorithm
      * Also known as 3-way partitioning
      * Time Complexity: O(n)
      * Space Complexity: O(1)
      */

    public void segregateZerosOnesAndTwos(int[] arr){
        int low = 0;
        int mid = 0;
        int high = arr.length - 1;
        while(mid <= high){
            if(arr[mid] == 0){
                // Swap arr[low] and arr[mid]
                int temp = arr[low];
                arr[low] = arr[mid];
                arr[mid] = temp;

                low++;
                mid++;
            }else if(arr[mid] == 1){
                mid++;
            }else{
                // Swap arr[mid] and arr[high]
                int temp = arr[mid];
                arr[mid] = arr[high];
                arr[high] = temp;
                
                high--;
            }
        }
    }
}
