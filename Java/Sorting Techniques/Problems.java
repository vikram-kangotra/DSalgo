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


}
