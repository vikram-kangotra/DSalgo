#include "Array.h"

//helper function
void swap(int* a, int* b){
    int temp = *a;
    *a = *b;
    *b = temp; 
}

void sort(int arr[], int size) {

    //bubble sort is used.
    for(int i = 0; i < size - 1; i++) {
        for(int j = 0; j < size - i - 1; j++) {
            if(arr[j] > arr[j + 1]) {
                swap(&arr[j], &arr[j + 1]);
            }


        }
    }
}
