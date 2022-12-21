import java.util.Arrays;
import java.util.Collection;
import java.util.Collections;

public class sortAlgo {

    // stable O(n^2) in place
    public static void bubble_sort(int[] arr){
        boolean swapped;
        for (int i=0; i< arr.length-1; i++){
             swapped = false;
            for(int j=0; j< arr.length-i-1;j++){
                if(arr[j] > arr[j+1]) {
                    int temp = arr[j];
                    arr[j] = arr[j+1];
                    arr[j+1] = temp;
                    swapped = true;
                }
            }
            if(swapped == false) break;
        }
    }

    // O(n^2)  Does less memory writes compared to Quicksort, Mergesort, Insertion sort etc
    // But cycle sort is optimal in memory write terms. Basic idea for heap sort. Not stable. In place

    public static  void selection_sort(int[] arr){
        int min_index;
         for (int i = 0 ; i < arr.length -1 ; i++){
             min_index = i;
             for (int j = i+1; j < arr.length; j++){
                 if(arr[j] < arr[min_index]) min_index = j;
                 int temp = arr[min_index];
                 arr[min_index] = arr[i];
                 arr[i] = temp;
             }
         }
    }

    //O(n^2) worst case O(n) best case ; in place; stable
    /*
    MergeSort(arr[], l,  r)

If r > l

Find the middle point to divide the array into two halves:
middle m = l + (r – l)/2
Call mergeSort for first half:
Call mergeSort(arr, l, m)
Call mergeSort for second half:
Call mergeSort(arr, m + 1, r)
Merge the two halves sorted in step 2 and 3:
Call merge(arr, l, m, r)
     */

    public static  void insertion_sort(int[] arr){
         for (int i = 1 ; i < arr.length; i++){
            int key = arr[i];
            int j = i-1;
            while (j>=0 && arr[j] > key){
                arr[j+1] = arr[j];
                j--;
            }
            arr[j+1] = key;
             }
         }

    public static void merge_sort(int[] arr,int l, int r) {
        if (r > l) {
            int m = l + (r-l)/2;
            merge_sort(arr,l,m);
            merge_sort(arr,m+1,r);
            merge(arr,l,m,r);
        }
    }

    private static void merge(int[] arr, int l, int m, int r) {
        int n1 = m-l+1 , n2 = r - m;
        int[] left = new int[n1];
        int[] right = new int[n2];
        for (int i = 0 ; i < n1 ; i++){
            left[i] = arr[l+i];
        }
        for (int i = 0 ; i < n2 ; i++){
            right[i] = arr[m+1+i];
        }
        int i = 0, j = 0, k = l;
        while (i < n1 && j< n2) {
            if (left[i] <= right[j]) {
                arr[k] = left[i];
                i++;
               // k++;
            } else {
                arr[k] = right[j];
                j++;
                //k++;
            }
            k++;
        }
        while (i < n1 ){arr[k] = left[i] ; i++ ; k++;}
        while (j < n2 ){arr[k] = right[j] ; j++ ; k++;}
    }

}

