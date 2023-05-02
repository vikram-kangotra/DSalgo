#include "Array.h"
#include <stdio.h>

void delete_element(int *arr, int* size, int index) {
    if(*size < 0) {
        printf("Array is empty!\n");
    } else if (index < 0 || index >= *size) {
        printf("Invalid Index!\n");
    } else {
        for(int i = index; i< *size - 1; i++) {
            arr[i] = arr[i + 1];
        }
        (*size)--;
    }
}


