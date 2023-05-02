#include "Array.h"
#include <stdio.h>

//Binary search is applicable only on sorted array.
//So we find out a given element is present in given array sorted array or not.
//Time Complexity: O(log2(n))
//Space Complexity: O(1)

int binary_search(int *arr, int size, int target) {

    int index = -1;
    int left = 0;
    int right = size - 1;

    while (left <= right) {
    int mid = left/2 + right/2;
        if(arr[mid] == target) {
            index = mid;
            break;
        } else if (arr[mid] < target) {
            left = mid + 1;
        } else {
            right = mid - 1;
        }
    }

    if (index == -1) 
        printf("%d is not present in  given array.\n", target);
    else
     printf("%d is present in given array at index: %d.\n", target,  index);
    

    return index;
}


