#include "Array.h"
#include <stdio.h>

void insert(int *arr, int* size, int data, int index) {
    
    if(*size >= MAXSIZE) {
        printf("Array is Full!\n");
    } else if (index < 0 || index > *size) {
        printf("Invalid Index!\n");
    } else {
        for(int i = *size - 1; i >= index; i--) {
            arr[i + 1] = arr[i];
        }
        arr[index] = data;
        (*size)++;
    }   
}
