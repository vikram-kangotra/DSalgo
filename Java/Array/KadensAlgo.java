public class KadensAlgo {
    /*
     * What is Kaden's algorithm?
     * Kadane's algorithm is used to find the maximum sum of a contiguous subarray in an array
     * Here is short description of the algorithm
     * 1. Initialize max_so_far = 0 and max_ending_here = 0
     * 2. Loop for each element of the array
     *     a) max_ending_here = max_ending_here + a[i]
     *    b) if(max_ending_here < 0)
     *          max_ending_here = 0
     *   c) if(max_so_far < max_ending_here)
     *         max_so_far = max_ending_here
     * 3. return max_so_far
     * 
    */


    /*
     * Maximum sum of subarray
     * Kadane's algorithm
     * Time complexity: O(n)
     * Space complexity: O(1)
     
    */

    public int maxSumSubarray(int[] arr) {
        int maxSum = arr[0];
        int currSum = arr[0];
        for(int i = 1 ; i < arr.length ; i++) {
            currSum = Math.max(arr[i], currSum + arr[i]);
            maxSum = Math.max(maxSum, currSum);
        }
        return maxSum;
    }

    /*
     * Maximum sum of circular subarray
     * Kadane's algorithm
     * Time complexity: O(n)
     * Space complexity: O(1)
    */

    public int maxSumCircularSubarray(int[] arr) {
        int maxSum = arr[0];
        int currSum = arr[0];
        // Maximum sum of Normal subarray
        for(int i = 1 ; i < arr.length ; i++) {
            currSum = Math.max(arr[i], currSum + arr[i]);
            maxSum = Math.max(maxSum, currSum);
        }
        int minSum = arr[0];
        int currMin = arr[0];

        // To find maximum sum of a circular subarray,
        // we need to find minimum sum of a normal subarray
        // and subtract it from total sum of the array
        

    
        // Minimum sum of subarray
        for(int i = 1 ; i < arr.length ; i++) {
            currMin = Math.min(arr[i], currMin + arr[i]);
            minSum = Math.min(minSum, currMin);
        }
        int totalSum = 0;
        // Total sum of array
        for(int i = 0 ; i < arr.length ; i++) {
            totalSum += arr[i];
        }
        // If all elements are negative
        if(totalSum == minSum) {
            return maxSum;
        }
        // Maximum sum of circular subarray = totalSum - minSum
        return Math.max(maxSum, totalSum - minSum);
    }
 
    /*
     * Maximum Length Even-Odd Subarray
     * Kadane's algorithm
     * Time complexity: O(n)
     * Space complexity: O(1)
     
     */

    public int maxEvenOddSubarray(int[] arr) {
        int res = 1;
        int curr = 1;
        for(int i = 1 ; i < arr.length ; i++) {
            if((arr[i] % 2 == 0 && arr[i-1] % 2 != 0) || (arr[i] % 2 != 0 && arr[i-1] % 2 == 0)) {
                curr++;
                res = Math.max(res, curr);
            } else {
                curr = 1;
            }
        }
        return res;
    }

}
