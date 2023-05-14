#include "Array.h"
#include <stdio.h>

//merge in sorted way.
//the input array must be sorted
void merge(int *arr1, int size1, int *arr2, int size2, int *result, int *result_size) {

    *result_size = size1 + size2;
    if(*result_size > MAXSIZE) {
        printf("Arrays are too large!\n");
        return;
    }

    int i = 0;
    int j = 0;
    int k = 0;
    while( i < size1 && j < size2) {
        if(arr1[i] <= arr2[j]) {
            result[k] = arr1[i];
            i++;
        } else {
            result[k] = arr2[j];
            j++;
        }
        k++;
    }
    while (i < size1) {
        result[k] = arr1[i];
        i++;
        k++;
    }
    while (j < size2) {
        result[k] = arr2[j];
        j++;
        k++;
    }
}



