#include <stdio.h>
#include <stdlib.h>
#include <time.h>
#define SIZE 50

void swap(int* a, int* b) {
    int t = *a;
    *a = *b;
    *b = t;
}

int partition(int arr[], int start, int end) {
    int pivot = arr[end];
    int i = start - 1;

    for(int j = start; j <= end - 1; j++) {
        if(arr[j] < pivot) {
            i++;
            swap(&arr[i], &arr[j]);
        }
    }

    swap(&arr[i + 1], &arr[end]);
    return i + 1;
}

void quickSort(int arr[], int start, int end) {
    if(start < end) {
        int q = partition(arr ,start, end);
        quickSort(arr, start, q -1);
        quickSort(arr,q +1, end);
    }
}

void fillArr(int arr[]) {
    srand(time(NULL));
    int mod = SIZE ;
    for(int i = 0; i < SIZE; i++) 
        arr[i] = rand() % mod;
}

void printArr(int arr[]) {
    for(int i = 0; i < SIZE; i++) 
        printf("%d ", arr[i]);
    printf("\n");
}
    
int main() {
    int arr[SIZE];
    fillArr(arr);
    printf("Array before quickSort:\n");
    printArr(arr);
    quickSort(arr, 0, SIZE - 1);
    printf("Array after quickSort:\n");
    printArr(arr); 
}
