

public class BinarySearch {
    public int iterativeSearch(int[] arr, int target){
        int start = 0;
        int end = arr.length - 1;
        boolean isAsc = arr[start] < arr[end];
        while(start <= end){
            int mid = start + (end - start) / 2;
            if(arr[mid] == target){
                return mid;
            }
            if(isAsc){
                if(target < arr[mid]){
                    end = mid - 1;
                }else{
                    start = mid + 1;
                }
            }else{
                if(target > arr[mid]){
                    end = mid - 1;
                }else{
                    start = mid + 1;
                }
            }
        }
        return -1;
    }

    public int recursiveSearch(int[] arr, int target, int low, int high){
        if (low > high) return -1;
        int mid = low + (high - low) / 2;
        if (arr[mid] == target) return mid;
        if (arr[low] < arr[high]) {
            if (target < arr[mid]) {
                return recursiveSearch(arr, target, low, mid - 1);
            } else {
                return recursiveSearch(arr, target, mid + 1, high);
            }
        } else {
            if (target > arr[mid]) {
                return recursiveSearch(arr, target, low, mid - 1);
            } else {
                return recursiveSearch(arr, target, mid + 1, high);
            }
        }
    }

    public int findFirstOccurrence(int[] arr, int target){
        int start = 0;
        int end = arr.length - 1;
        int result = -1;
        while(start <= end){
            int mid = start + (end - start) / 2;
            if (arr[mid] > target) end = mid - 1;
            else if (arr[mid] < target) start = mid + 1;
            else {
                if (mid == 0 || arr[mid - 1] != target) return mid;
                else end = mid - 1;
            }

        }
        return result;
    }

    public int findLastOccurrence(int[] arr, int target){
        int start = 0;
        int end = arr.length - 1;
        int result = -1;
        while(start <= end){
            int mid = start + (end - start) / 2;
            if (arr[mid] > target) end = mid - 1;
            else if (arr[mid] < target) start = mid + 1;
            else {
                if (mid == arr.length - 1 || arr[mid + 1] != target) return mid;
                else start = mid + 1;
            }

        }
        return result;
    }

    public int countOccurrence(int[] arr, int target){
        int first = findFirstOccurrence(arr, target);
        int last = findLastOccurrence(arr, target);
        if (first == -1 || last == -1) return 0;
        return last - first + 1;
    }

    public int[] findFloorAndCeil(int[] arr, int target){
        int start = 0;
        int end = arr.length - 1;
        int floor = -1;
        int ceil = -1;
        while(start <= end){
            int mid = start + (end - start) / 2;
            if (arr[mid] == target) {
                floor = arr[mid];
                ceil = arr[mid];
                break;
            }
            if (arr[mid] > target){
                ceil = arr[mid];
                end = mid - 1;
            }else{
                floor = arr[mid];
                start = mid + 1;
            }
        }
        return new int[]{floor, ceil};
    }

    public int getSquareRoot(int num){
        int start = 0;
        int end = num;
        int result = -1;
        while(start <= end){
            int mid = start + (end - start) / 2;
            if (mid * mid == num) return mid;
            if (mid * mid > num) end = mid - 1;
            else {
                start = mid + 1;
                result = mid;
            }
        }
        return result;
    }

    public int searchInInfiniteArray(int[] arr, int target){
        int start = 0;
        int end = 1;
        while(target > arr[end]){
            int newStart = end + 1;
            end = end + (end - start + 1) * 2;
            start = newStart;
        }
        return recursiveSearch(arr, target, start, end);
    }

    public int searchInSortedRotatedArray( int[] arr, int target){
        int start = 0;
        int end = arr.length-1;
        while(start <= end){
            int mid = start + (end - start) / 2;
            if (arr[mid] == target) return mid;
            if (arr[start] < arr[mid]){ // Left half sorted
                if (target >= arr[start] && target < arr[mid])
                    end = mid - 1;
                else
                    start = mid + 1;
            }
            else { // Right half sorted
                if (target > arr[mid] && target <= arr[end])
                    start = mid + 1;
                else
                    end = mid + 1;
            }
        }
        return -1;
    }

    public int findPeakElement(int[] arr){
        int start = 0;
        int end = arr.length - 1;
        while (start <= end){
            int mid = start + (end - start) / 2;
            if ((mid == 0 || arr[mid - 1] <= arr[mid]) && (mid == (arr.length-1) || arr[mid+1] <= arr[mid]))
                return mid;
            if (mid > 0 && arr[mid-1] >= arr[mid])
                end = mid - 1;
            else
                start = mid + 1;
        }
        return -1;
    }

    public int searchInMountainArray(int[] arr, int target){
        int peak = findPeakElement(arr);
        int firstTry = recursiveSearch(arr, target,0,peak);
        if (firstTry != -1) return firstTry;
        return recursiveSearch(arr, target, peak + 1, arr.length-1);
    }

    // Given a sorted array and a sum, find if there is a pair with given sum.
    // Two pointer approach

    public boolean isPairWithSumEqualsK(int[] arr, int k, int left, int right){
        
        while (left < right){
            if (arr[left] + arr[right] == k) return true;
            else if (arr[left]+arr[right] > k) right--;
            else left++;
        }
        return false;
    }

    public boolean isTripletWithSumEqualsK(int[] arr, int k){
        for (int i = 0 ;i < arr.length;i++){
            if(isPairWithSumEqualsK(arr, k - arr[i], i+1 , arr.length - 1))
                return true;
                
        }
        return false;
    } // Similar question: check if pythagorean triplet exists or not
}
