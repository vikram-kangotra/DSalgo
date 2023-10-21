#include <stdio.h>
#include <stdlib.h>
#include <time.h>

//helper function
void swap(int*, int*);
void fillArr(int*, int);
void printArr(int*, int);

//heapSort fuctions
void heapSort(int*, int);
void buildMaxHeap(int*, int);
void heapify(int*, int, int);

int main(){
    int size = 50;
    int arr[size];
    fillArr(arr, size);
    printf("Array before heapSort:\n");
    printArr(arr, size);
    heapSort(arr, size);
    printf("Array after heapSort:\n");
    printArr(arr, size);     
}

void swap(int* a, int* b) {
    int t = *a;
    *a = *b;
    *b = t;
}

void fillArr(int arr[], int size) {
    srand(time(NULL));
    int mod = size ;
    for(int i = 0; i < size; i++) 
        arr[i] = rand() % mod;
}

void printArr(int arr[], int size) {
    for(int i = 0; i < size; i++) 
        printf("%d ", arr[i]);
    printf("\n");
}

//heapsort functions
void heapSort(int arr[], int size) {
    buildMaxHeap(arr, size);

    for(int i = size - 1; i > 0; i--) {
        swap(&arr[0], &arr[i]);
        heapify(arr, i , 0);
    }
}

void buildMaxHeap(int arr[], int size) {
    for(int i = size / 2 - 1; i >= 0; i--) {
        heapify(arr, size, i);
    }
}

void heapify(int arr[], int size, int root) {
    int largest = root;
    int leftChild = 2 * root + 1;
    int rightChild = 2 * root + 2;

    if(leftChild < size && arr[leftChild] > arr[largest])
        largest = leftChild;

    if(rightChild < size && arr[rightChild] > arr[largest])
        largest = rightChild;

    if(largest != root) {
        swap(&arr[largest], &arr[root]);
        heapify(arr, size, largest);
    }
}
   


