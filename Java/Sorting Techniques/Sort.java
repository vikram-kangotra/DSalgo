public class Sort{

    /*
     * What is Stability in Sorting?
     * Stability in sorting means that if two objects with equal keys appear in the same order in the input array, they will appear in the same order in the output array.
     * Examples of stable sorting algorithms are Merge Sort, Bubble Sort, Insertion Sort, etc.
     * Examples of unstable sorting algorithms are Selection Sort, Heap Sort, Quick Sort, etc.
     */


    /*
     * Bubble Sort
     * Time Complexity: O(n^2)
     * Space Complexity: O(1)
     */
    public void  bubbleSort(int[] arr){
        int n = arr.length;
        for(int i = 0; i < n; i++){
            boolean swapped = false;
            for(int j = 0; j < n - i - 1; j++){
                if(arr[j] > arr[j + 1]){
                    int temp = arr[j];
                    arr[j] = arr[j + 1];
                    arr[j + 1] = temp;
                    swapped = true;
                }
            }
            if(!swapped){
                break;
            }
        }
    }

    /*
     * Selection Sort
     * Time Complexity: O(n^2)
     * Space Complexity: O(1)
     * Adavantages:
     * 1. It is in-place sorting algorithm.
     * 2. Does less memory writes than Bubble Sort.
     * 3. Basic idea for heapsort.
     * Disadvantages:
     * 1. It is not a stable sorting algorithm.
     * 2. It is not adaptive sorting algorithm.
     */

    public void selectionSort(int[] arr){
        int n = arr.length;
        for(int i = 0; i < n-1; i++){
            int minIndex = i;
            for(int j = i + 1; j < n; j++){
                if(arr[j] < arr[minIndex]){
                    minIndex = j;
                }
            }
            int temp = arr[i];
            arr[i] = arr[minIndex];
            arr[minIndex] = temp;
        }
    }

    /*
     * Insertion Sort
     * Time Complexity: O(n^2)
     * Space Complexity: O(1)
     * Adavantages:
     * 1. It is in-place sorting algorithm.
     * 2. It is adaptive sorting algorithm.
     * 3. It is stable sorting algorithm.
     * 4. It is efficient for small data sets.
     * Disadvantages:
     * 1. It is not a good sorting algorithm for large data sets.
     */

    public void insertionSort(int[] arr){
        int n = arr.length;
        for(int i = 1; i < n; i++){
            int key = arr[i];
            int j = i - 1;
            while(j >= 0 && arr[j] > key){ // Here it is not >= because we want to keep the order of equal elements to achieve stability.
                arr[j + 1] = arr[j];
                j--;
            }
            arr[j + 1] = key;
        }
    }
    
    /*
     * Merge Sort
     *  Time Complexity: O(nlogn)
     * Space Complexity: O(n)
     * Adavantages:
     * 1. It is a stable sorting algorithm.
     * 2. It is a divide and conquer algorithm.
     * 3. It is not in-place sorting algorithm.
     * 4. Well suited for sorting linked lists.
     * 5. Used in external sorting.
     * Disadvantages:
     * 1. It is not adaptive sorting algorithm.
     * 2. It is not efficient for small data sets.
     * 3. For arrays, Quick Sort is more efficient than Merge Sort.
     */
     
    public void mergeSort(int[] arr, int l, int r){
        if(l < r){
            // Find the middle point
            int m = (l + r) / 2;
            // Sort first and second halves
            mergeSort(arr, l, m);
            mergeSort(arr, m + 1, r);
            // Merge the sorted halves
            merge(arr, l, m, r);
        }
    }

    private void merge(int[] arr, int l, int m, int r){
        // Find sizes of two subarrays to be merged
        int n1 = m - l + 1;
        int n2 = r - m;
        // Create temp arrays
        int[] L = new int[n1];
        int[] R = new int[n2];
        // Copy data to temp arrays
        for(int i = 0; i < n1; i++){
            L[i] = arr[l + i];
        }
        for(int j = 0; j < n2; j++){
            R[j] = arr[m + 1 + j];
        }
        // Merge the temp arrays
        // Initial indexes of first and second subarrays
        int i = 0, j = 0;
        // Initial index of merged subarray array
        int k = l;
        while(i < n1 && j < n2){
            if(L[i] <= R[j]){
                arr[k] = L[i];
                i++;
            }else{
                arr[k] = R[j];
                j++;
            }
            k++;
        }
        // Copy remaining elements of L[] if any
        while(i < n1){
            arr[k] = L[i];
            i++;
            k++;
        }
        // Copy remaining elements of R[] if any
        while(j < n2){
            arr[k] = R[j];
            j++;
            k++;
        }
    }

     
     
     public static void main(String[] args) {
        
        Sort sort = new Sort();
        int[] arr = {64, 34, 25, 12, 22, 11, 90};
        sort.mergeSort(arr, 0, arr.length - 1);
        for(int i = 0; i < arr.length; i++){
            System.out.print(arr[i] + " ");
        }

        int[] arr2 = {64, 34, 25, 12, 22, 11, 90};
        sort.insertionSort(arr2);
        for(int i = 0; i < arr2.length; i++){
            System.out.print(arr2[i] + " ");
        }

        int[] arr3 = {64, 34, 25, 12, 22, 11, 90};
        sort.selectionSort(arr3);
        for(int i = 0; i < arr3.length; i++){
            System.out.print(arr3[i] + " ");
        }

        int[] arr4 = {64, 34, 25, 12, 22, 11, 90};
        sort.bubbleSort(arr4);
        for(int i = 0; i < arr4.length; i++){
            System.out.print(arr4[i] + " ");
        }
        

     }
}