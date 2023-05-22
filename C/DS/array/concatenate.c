#include "Array.h"
#include <stdio.h>

void concatenate(int *arr1, int size1, int *arr2, int size2, int *result, int *result_size) {
    
    *result_size = size1 + size2;
   if( *result_size > MAXSIZE) {
        printf("Size of New Array is Out of Bound!\n");
        return;
    }

    int i;
    for(i = 0; i < size1; i++) {
        result[i] = arr1[i];
    }

    for(int j = 0 ; j < size2; i++, j++) {
        result[i] = arr2[j];
    }
}

