public class Problems {

    public int getSecondLargestElement(int[] arr) {
        int largest = 0;
        int secondLargest = -1;
        for (int i = 0; i < arr.length; i++) {
            if (arr[i] > arr[largest]) {
                secondLargest = largest;
                largest = i;
            } else if (arr[i] != arr[largest]) {
                if (secondLargest == -1 || arr[i] > arr[secondLargest]) {
                    secondLargest = i;
                }
            }
        }
        return secondLargest;
    }

    public boolean isArraySorted(int[] arr) {
        for (int i = 1; i < arr.length - 1; i++) {
            if (arr[i] < arr[i - 1]) {
                return false;
            }
        }
        return true;
    }

    public void reverseArray(int[] arr) {
        int low = 0;
        int high = arr.length - 1;
        while (low < high) {
            int temp = arr[low];
            arr[low] = arr[high];
            arr[high] = temp;
            low++;
            high--;
        }
    }

    /*
     * Remove duplicates from a sorted array
     * Move all the unique elements to the front of the array
     * Return the number of unique elements
     * Time complexity: O(n)
     * Space complexity: O(1)
     */

    public int removeDuplicates(int[] arr) {
        int unique = 1;
        for(int i = 1 ; i < arr.length ; i++) {
            if(arr[i] != arr[unique-1]) {
                arr[unique] = arr[i];
                unique++;
            }
        }
        return unique;
    }

    /*
     * Move all the zeroes to the end of the array
     * Order of non-zero elements should not change
     * Time complexity: O(n)
     * Space complexity: O(1)
     */

    public void moveZeroesToEnd(int[] arr) {
        int nonZero = 0;
        for(int i = 0 ; i < arr.length ; i++) {
            if(arr[i] != 0) {
                arr[nonZero] = arr[i];
                nonZero++;
            }
        }
        for(int i = nonZero ; i < arr.length ; i++) {
            arr[i] = 0;
        }

        /*
         * Another way to do this:
         * int nonZero = 0;
         * for(int i = 0 ; i < arr.length ; i++) {
         *    if(arr[i] != 0) {
         *       int temp = arr[i];
         *      arr[i] = arr[nonZero];
         *     arr[nonZero] = temp;
         *    nonZero++;
         * }
         * }
        
         */
    }

    public void leftRotateByOne(int[] arr) {
        int temp = arr[0];
        for(int i = 1 ; i < arr.length ; i++) {
            arr[i-1] = arr[i];
        }
        arr[arr.length-1] = temp;
        /*
         * Time complexity: O(n)
         * Space complexity: O(1)
         */
    }
    
    public void leftRotate(int[] arr, int k) {
        k = k % arr.length;
        reverse(arr, 0, k-1);
        reverse(arr, k, arr.length-1);
        reverse(arr, 0, arr.length-1);
        /*
         * Time complexity: O(n)
         * Space complexity: O(1)
         */
    }

    public void reverse(int[] arr, int start, int end) {
        while(start < end) {
            int temp = arr[start];
            arr[start] = arr[end];
            arr[end] = temp;
            start++;
            end--;
        }
    }

    public void intersectionOfTwoSortedArrays(int[] arr1, int[] arr2) {
        int i = 0;
        int j = 0;
        while(i < arr1.length && j < arr2.length) {
            if (i > 0 && arr1[i] == arr1[i - 1]) {
                i++;
                continue;
            }
            if(arr1[i] == arr2[j]) {
                System.out.print(arr1[i] + " ");
                i++;
                j++;
            } else if(arr1[i] < arr2[j]) {
                i++;
            } else {
                j++;
            }
        }
        /*
         * Time complexity: O(n)
         * Space complexity: O(1)
         */
    }

    public void leadearsInAnArray(int[] arr) {
        int curr_leader = arr[arr.length-1];
        System.out.print(curr_leader + " ");
        for(int i = arr.length-2 ; i >= 0 ; i--) {
            if(arr[i] > curr_leader) {
                curr_leader = arr[i];
                System.out.print(curr_leader + " ");
            }
        }
        /*  
         * Leaders are the elements which are greater than all the elements to its right
         * Time complexity: O(n)
         * Space complexity: O(1)
         */
    }

    public void printFrequencyOfElementsOfSortedArray(int[] arr) {
        int count = 1;
        for(int i = 1 ; i < arr.length ; i++) {
            if(arr[i] == arr[i-1]) {
                count++;
            } else {
                System.out.println(arr[i-1] + " " + count);
                count = 1;
            }
        }
        System.out.println(arr[arr.length-1] + " " + count);
        /*
         * Time complexity: O(n)
         * Space complexity: O(1)
         */
    }

    /*
     * Stock buy and sell problem
     * Return the maximum profit that can be made by buying and selling stocks
     * Time complexity: O(n)
     * Space complexity: O(1)
     * Valley peak approach
     * Plot of stock prices on a graph
     * Buy at valley and sell at peak
     
     */

    public int maxProfit(int[] price){
        int profit = 0;
        for (int i = 0; i < price.length; i++){
            if (price[i] > price[i-1]){
                profit += (price[i] - price[i-1]);
            }
        }
        return profit;
    }

    /*
     * Trapping water problem
     * Return the maximum amount of water that can be trapped
     * Time complexity: O(n)
     * Space complexity: O(1)
     */

    public int maxWater(int[] arr) {
        int water = 0;
        int[] leftMax = new int[arr.length];
        int[] rightMax = new int[arr.length];

        leftMax[0] = arr[0];
        for(int i = 1 ; i < arr.length ; i++) {
            leftMax[i] = Math.max(leftMax[i-1], arr[i]);
        }

        rightMax[arr.length-1] = arr[arr.length-1];
        for(int i = arr.length-2 ; i >= 0 ; i--) {
            rightMax[i] = Math.max(rightMax[i+1], arr[i]);
        }

        for(int i = 0 ; i < arr.length ; i++) {
            water += Math.min(leftMax[i], rightMax[i]) - arr[i];
        }

        return water;
    }  

    public int maxConsecutiveOnes(int[] arr) {
        int res = 0;
        int curr = 0;
        for(int i = 0 ; i < arr.length ; i++) {
            if(arr[i] == 0) {
                curr = 0;
            } else {
                curr++;
                res = Math.max(res, curr);
            }
        }
        return res;
    }


    
    /*
     * Minimum group flips to make all elements of binary array same
     * Print the indices of the element to be flipped
     * Time complexity: O(n)
     * Space complexity: O(1)
     
     
    */

    public void minGroupFlips(int[] arr) {
        for(int i = 1 ; i < arr.length ; i++) {
            if(arr[i] != arr[i-1]) {
                if(arr[i] != arr[0]) {
                    System.out.print("From " + i + " to ");
                } else {
                    System.out.println(i-1);
                }
            }
        }
        if(arr[arr.length-1] != arr[0]) {
            System.out.println(arr.length-1);
        }
    }

    

}