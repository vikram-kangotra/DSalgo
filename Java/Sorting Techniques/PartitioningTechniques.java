public class PartitioningTechniques {
    
    /*
     * What is partitioning?
     * Partitioning is a process of rearranging the elements of an array such that all elements less than or equal to a given value x come before all elements greater than x.
     * Naive Partitioning
     * Time Complexity: O(n)
     * Space Complexity: O(n)
     */
    public void naivePartioning(int[] arr, int pivot){
        int n = arr.length;
        int[] temp = new int[n];
        int index = 0;
        for(int i = 0; i < n; i++){
            if (arr[i] <= arr[pivot]){
                temp[index] = arr[i];
                index++;
            }
        }
        for(int i = 0; i < n; i++){
            if (arr[i] > arr[pivot]){
                temp[index] = arr[i];
                index++;
            }
        }
        for(int i = 0; i < n; i++){
            arr[i] = temp[i];
        }
    }

    /*
     * Lomuto Partitioning
     * Pivot is the last element of the array 
     * If pivot is some element other than the last element, swap it with the last element
     * Time Complexity: O(n)
     * Space Complexity: O(1)
     */

    public void lomutoPartitioning(int[] arr){
        int pivot = arr[arr.length - 1];
        int i = -1;
        for(int j = 0; j < arr.length - 1; j++){
            if(arr[j] < pivot){
                i++;
                int temp = arr[i];
                arr[i] = arr[j];
                arr[j] = temp;
            }
        }
        int temp = arr[i + 1];
        arr[i + 1] = arr[arr.length - 1];
        arr[arr.length - 1] = temp;
    }

    /*
     * Hoare Partitioning
     * Pivot is the first element of the array
     * If pivot is some element other than the first element, swap it with the first element
     * Time Complexity: O(n)
     * Space Complexity: O(1)
     */

    public void hoarePartitioning(int[] arr){
        int pivot = arr[0];
        int i = -1;
        int j = arr.length;
        while(true){
            do {
                i++;
            }
            while(arr[i] < pivot);

            do {
                j--;
            }
            while(arr[j] > pivot);
            if (i >= j){
                return;
            }
            
                int temp = arr[i];
                arr[i] = arr[j];
                arr[j] = temp;
            
        }
    }
}
