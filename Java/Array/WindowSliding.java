public class WindowSliding {
    /*
     * Window Sliding Technique:
     * Given an array of integers of size n,
     * calculate the maximum sum of k consecutive elements in the array.
     * Algorithm:
     * 1. Initialize max_sum as first k elements sum
     * 2. Iterate from k to n-1
     *   a) Calculate the sum of current k elements
     *  b) If the current sum is greater than max_sum, update max_sum
     * 3. Return max_sum
     * 
     * Elements of the array are non-negative (necessary condition for this algorithm)
     * Time complexity: O(n)
     * Space complexity: O(1)
    */

    public int maxSumKConsecutive(int[] arr, int k) {
        int maxSum = 0;
        for(int i = 0 ; i < k ; i++) {
            maxSum += arr[i];
        }
        int currSum = maxSum;
        for(int i = k ; i < arr.length ; i++) {
            currSum += arr[i] - arr[i-k];
            maxSum = Math.max(maxSum, currSum);
        }
        return maxSum;
    }

    /*
     * Given an unsorted array of non-negative integers, find a continuous subarray which adds to a given number.
     * Window sliding technique
     * Time complexity: O(n)
     * Space complexity: O(1)
     */

    public void subarraySum(int[] arr, int sum) {
        int currSum = arr[0];
        int start = 0;
        for(int i = 1 ; i <= arr.length ; i++) {
            while(currSum > sum && start < i-1) {
                currSum -= arr[start];
                start++;
            }
            if(currSum == sum) {
                System.out.println("Sum found between indexes " + start + " and " + (i-1));
                return;
            }
            if(i < arr.length) {
                currSum += arr[i];
            }
        }
        System.out.println("No subarray found");
    }

    
    /*
    * N-bonacci numbers problem
    * Given a number m and a number n, print first m N-bonacci numbers.
    * N-bonacci numbers are generalization of Fibonacci numbers.
    * Uses sliding window technique
    * Time complexity: O(m)

    */   

    public void nBonacci(int m, int n) {
        int[] arr = new int[m];
        for(int i = 0 ; i < n-1 ; i++) {
            arr[i] = 0;
        }
        arr[n-1] = 1;
        int sum = 1;
        for(int i = n ; i < m ; i++) {
            arr[i] = sum;
            sum += arr[i] - arr[i-n];
        }
        for(int i = 0 ; i < m ; i++) {
            System.out.print(arr[i] + " ");
        }
    }
}
