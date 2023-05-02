#include "Array.h"
#include <stdio.h>

//Linear search are for 1D unsorted array to find out whether a given element is present in array or not.
//Time Complexity : O(n)
//Space Complexity : O(1)

int linear_search(int *arr, int size, int target) {

    int index = -1;

    for(int i = 0; i < size; i++) {
        if (arr[i] == target) {
            index = i;
            break;
        }
    }
    if (index == -1) 
        printf("%d is not present in  given array.\n", target);
    else
     printf("%d is present in given array at index: %d.\n", target,  index);

    return index;
}
            

