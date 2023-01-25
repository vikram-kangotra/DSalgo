public class PrefixSumTechnique {
    
    /*
     * Prefix sum technique:
     * Given an array of integers, find the sum of elements between given two indices in O(1) time.
     * However, it takes O(n) time to build the prefix sum array.
     */

    public int[] prefixSum(int[] arr) {
        int[] prefixSum = new int[arr.length];
        prefixSum[0] = arr[0];
        for(int i = 1 ; i < arr.length ; i++) {
            prefixSum[i] = prefixSum[i-1] + arr[i];
        }
        return prefixSum;
    }

    public int sumBetweenIndices(int[] prefixSum, int start, int end) {
        if(start == 0) {
            return prefixSum[end];
        }
        return prefixSum[end] - prefixSum[start-1];
    }

    /*
     * Given an array of integers, find if it has an equilibrium point or not.
     * Equilibrium point is an index such that the sum of elements before it is equal to the sum of elements after it.
     * Time complexity: O(n)
     * Space complexity: O(1)
     
    */

    public int equilibriumPoint(int[] arr) {
        int sum = 0;
        for(int i = 0 ; i < arr.length ; i++) {
            sum += arr[i];
        }
        int leftSum = 0;
        for(int i = 0 ; i < arr.length ; i++) {
            if(leftSum == sum - leftSum - arr[i]) {
                return i;
            }
            leftSum += arr[i];
        }
        return -1;
    }
    
    /*
     * Given n ranges, find the maximum occurring integer in these ranges.
     * Time complexity: O(n)
     * Space complexity: O(n)
     */

    public int maxOccuringInteger(int[] leftRanges, int[] rightRanges){
        int[] prefixSum = new int[1000];
        for(int i = 0 ; i < leftRanges.length ; i++) {
            prefixSum[leftRanges[i]]++;
            prefixSum[rightRanges[i]+1]--;
        }
        int maxIndex = 0;
        int max = prefixSum[0];
        for(int i = 1 ; i < prefixSum.length ; i++) {
            prefixSum[i] += prefixSum[i-1];
            if(prefixSum[i] > max) {
                max = prefixSum[i];
                maxIndex = i;
            }
        }
        return maxIndex;
    }

    /*
     * To Do::
     * 1. Check if a given array can be divided into three parts with equal sum
     * 2. Check if there is a subarray with 0 sum
     * 3. Find the longest subarray with equal 0s and 1s.
     */
    


    
}
