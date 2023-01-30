import java.util.Arrays;

public class Problems {
    
    public void intersectionOfTwoSortedArrays(int[] arr1, int[] arr2){
        int n1 = arr1.length;
        int n2 = arr2.length;
        int i = 0, j = 0;
        while(i < n1 && j < n2){

            if(i > 0 && arr1[i] == arr1[i - 1]){
                i++;
                continue;
            }
            if(arr1[i] == arr2[j]){
                System.out.print(arr1[i] + " ");
                i++;
                j++;
            }else if(arr1[i] < arr2[j]){
                i++;
            }else{
                j++;
            }
        }
    }

    public void unionOfTwoSortedArrays(int[] arr1, int[] arr2){
        int n1 = arr1.length;
        int n2 = arr2.length;
        int i = 0, j = 0;
        while(i < n1 && j < n2){
            if(i > 0 && arr1[i] == arr1[i - 1]){
                i++;
                continue;
            }
            if(j > 0 && arr2[j] == arr2[j - 1]){
                j++;
                continue;
            }
            if(arr1[i] == arr2[j]){
                System.out.print(arr1[i] + " ");
                i++;
                j++;
            }else if(arr1[i] < arr2[j]){
                System.out.print(arr1[i] + " ");
                i++;
            }else{
                System.out.print(arr2[j] + " ");
                j++;
            }
        }
        while(i < n1){
            if(i > 0 && arr1[i] == arr1[i - 1]){
                i++;
                continue;
            }
            System.out.print(arr1[i] + " ");
            i++;
        }
        while(j < n2){
            if(j > 0 && arr2[j] == arr2[j - 1]){
                j++;
                continue;
            }
            System.out.print(arr2[j] + " ");
            j++;
        }
    }

    /*
     * Count Inversions in an array
     * An inversion occurs when a[i] > a[j] and i < j
     * mergeFunction based algorithm
     * Time Complexity: O(nlogn)
     * Space Complexity: O(n)
     */

    public int countInversion(int[] arr, int l, int r){
        int count = 0;
        if(l < r){
            int mid = l + (r - l) / 2;
            count += countInversion(arr, l, mid);
            count += countInversion(arr, mid + 1, r);
            count += countAndMerge(arr, l, mid, r);
        }
        return count;
    }

    public int countAndMerge(int[] arr, int l, int mid, int r){
        int n1 = mid - l + 1;
        int n2 = r - mid;
        int[] left = new int[n1];
        int[] right = new int[n2];
        for(int i = 0; i < n1; i++){
            left[i] = arr[l + i];
        }
        for(int i = 0; i < n2; i++){
            right[i] = arr[mid + 1 + i];
        }
        int i = 0, j = 0, k = l, swaps = 0;
        while(i < n1 && j < n2){
            if(left[i] <= right[j]){
                arr[k] = left[i];
                i++;
            }else{
                arr[k] = right[j];
                j++;
                swaps += (mid + 1) - (l + i); // this is the main logic
                // if left[i] > right[j] then all the elements in left array from i to n1 will be greater than right[j]
            }
            k++;
        }
        while(i < n1){
            arr[k] = left[i];
            i++;
            k++;
        }
        while(j < n2){
            arr[k] = right[j];
            j++;
            k++;
        }
        return swaps;
    }

    /*
     * kth smallest element in an array
     * using quick select algorithm (Lomuto Partition technique)
     */

    public int kthSmallest(int[] arr, int k){
        int l = 0;
        int r = arr.length - 1;
        while(l <= r){
            int p = Sort.lomutoPartitioning(arr, l, r);
            if(p == k - 1){
                return arr[p];
            }else if(p > k - 1){
                r = p - 1;
            }else{
                l = p + 1;
            }
        }
        return -1;
    }

    /*
     * kth largest element in an array
     * using quick select algorithm (Lomuto Partition technique)
     */

    public int kthLargest(int[] arr, int k){
        int l = 0;
        int r = arr.length - 1;
        while(l <= r){
            int p = Sort.lomutoPartitioning(arr, l, r);
            if(p == arr.length - k){
                return arr[p];
            }else if(p > arr.length - k){
                r = p - 1;
            }else{
                l = p + 1;
            }
        }
        return -1;
    }

    /*
     * Chocolate Distribution Problem
     * Given an array of n integers where each value represents the number of chocolates in a packet.
     * Each packet can have a variable number of chocolates. There are m students, the task is to distribute
     * chocolate packets such that:
     * 1. Each student gets one packet.
     * 2. The difference between the number of chocolates in the packet with maximum chocolates and
     *   packet with minimum chocolates given to the students is minimum.
     * Time Complexity: O(nlogn)
     * Space Complexity: O(1) 
     */

    public int chocolateDistribution(int[] arr, int m){
        Arrays.sort(arr);
        int min = Integer.MAX_VALUE;
        for(int i = 0; i + m - 1 < arr.length; i++){
            min = Math.min(min, arr[i + m - 1] - arr[i]);
        }
        return min;
    }

    public static void main(String[] args) {
        
        Problems p = new Problems();
        int[] arr1 = {1, 2, 2, 3, 4, 5, 5, 6, 7, 8, 9};
        int[] arr2 = {2, 2, 3, 4, 5, 5, 6, 7, 8, 9, 10};
        p.intersectionOfTwoSortedArrays(arr1, arr2);
        System.out.println();
        p.unionOfTwoSortedArrays(arr1, arr2);
        System.out.println();
        int[] arr = {2, 4, 1, 3, 5};
        System.out.println(p.countInversion(arr, 0, arr.length - 1));
        System.out.println(p.kthSmallest(arr, 3));
        System.out.println(p.kthLargest(arr, 3));
    }

}
