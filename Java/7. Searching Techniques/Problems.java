public class Problems {
    /* Array size, n>=2
     All the elements from 0 to max(array) are present
     Only one elemnt is repeated any number of times
     Find the repeated element */

    public int findRepeatedElement(int[] arr){
        // create links and find the first element of the cycle.
        // Two step algorithm
        // 1. Find the first element of the cycle
        // 2. Find the length of the cycle
        // 3. Find the first element of the cycle
        // 4. Find the repeated element
        int slow = arr[0] + 1;
        int fast = arr[0] + 1;
        do{
            slow = arr[slow] + 1;
            fast = arr[arr[fast] + 1] + 1;
        }while(slow != fast);
        
        
        slow = arr[0] + 1;
        while(slow != fast){
            slow = arr[slow] + 1;
            fast = arr[fast] + 1;
        }
        return slow - 1;
    }

    /* 
    Given an array of integers, find the minimum number of pages 
    that can be allocated to each student such that the maximum number of pages allocated to a student is minimum.
    Allocate minimum number of pages problem:

    */ 
    public int findMinPages(int[] arr, int students){
        int sum = 0;
        int max = 0;
        for(int i = 0; i < arr.length; i++){
            sum += arr[i];
            max = Math.max(max, arr[i]);
        }
        int low = max;
        int high = sum;
        int result = -1;
        while(low <= high){
            int mid = (low + high)/2;
            if(isValid(arr, students, mid)){
                result = mid;
                high = mid - 1;
            }else{
                low = mid + 1;
            }
        }
        return result;
    }

    private boolean isValid(int[] arr, int students, int mid){
        int count = 1;
        int sum = 0;
        for(int i = 0; i < arr.length; i++){
            sum += arr[i];
            if(sum > mid){
                count++;
                sum = arr[i];
            }
        }
        return count <= students;
    } 

    /*
     * Given an unsorted array of size n. Array elements are in the range of 1 to n. 
     * One number from set {1, 2, …n} is missing and one number occurs twice in the array. 
     * Find these two numbers.
     * 
     * (Using elements as index and marking the visited places)
     * Time Complexity: O(n)
     * Space Complexity: O(1)
     */
    public int[] findMissingAndRepeating(int[] arr){
        int[] result = new int[2];
        // Repeating element
        for(int i = 0; i < arr.length; i++){
            if(arr[Math.abs(arr[i]) - 1] > 0){
                arr[Math.abs(arr[i]) - 1] = -arr[Math.abs(arr[i]) - 1];
            }else{
                result[0] = Math.abs(arr[i]);
            }
        }

        // Missing element
        for(int i = 0; i < arr.length; i++){
            if(arr[i] > 0){
                result[1] = i + 1;
            }
        }
        return result;
    }

    /*
     * Print common elements in three sorted arrays
     * Time Complexity: O(n1(log(n2 * n3)))
     * Space Complexity: O(1)
     */
    public void printCommonElements(int[] arr1, int[] arr2, int[] arr3){
        // Iterate through the first array and search for the element in the other two arrays
        for(int i = 0; i < arr1.length; i++){
            if(i > 0 && arr1[i] == arr1[i-1]){
                continue;
            }
            if(binarySearch(arr2, arr1[i]) && binarySearch(arr3, arr1[i])){
                System.out.println(arr1[i]);
            }
        }
    }

    private boolean binarySearch(int[] arr, int key){
        int low = 0;
        int high = arr.length - 1;
        while(low <= high){
            int mid = (low + high)/2;
            if(arr[mid] == key){
                return true;
            }else if(arr[mid] < key){
                low = mid + 1;
            }else{
                high = mid - 1;
            }
        }
        return false;
    }
    
}
