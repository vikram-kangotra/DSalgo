#include <stdio.h>
#include <stdlib.h>
#include <time.h>
#define SIZE 2000

void mergeSort(int*, int, int);
void merge(int*, int, int, int);
void fillArr(int*);
void printArr(int*);

int main() {
    srand(time(NULL));

    int arr[SIZE];
    fillArr(arr);
    printf("Array before soring:\n");
    printArr(arr);
    mergeSort(arr, 1, SIZE - 1);
    printf("Array after merge sort:\n");
    printArr(arr);

    return 0;
}

void merge(int arr[], int left, int mid, int right) {
    int i, j, k;
    int n1 = mid - left + 1;
    int n2 = right - mid;

    int leftHalfArr[n1];
    for(int i = 0; i < n1; i++)
        leftHalfArr[i] = arr[left+i];


    int rightHalfArr[n2];
    for(int j = 0; j < n1; j++)
        rightHalfArr[j] = arr[mid + j + 1];

    i = j = 0; //reinitialize counter  variables.
    k = left;
    while(i<n1 && j<n2) {
        if(leftHalfArr[i] <= rightHalfArr[j]) { 
            arr[k] = leftHalfArr[i];
            i++;
        } else {
            arr[k] = rightHalfArr[j];
            j++;
        }
        k++;
    }
    while(i < n1) {
        arr[k] = leftHalfArr[i];
        i++;
        k++;
    }
    while(j < n2) {
        arr[k] = rightHalfArr[j];
        j++;
        k++;
    }
}
void mergeSort(int arr[], int left, int right) {
    if(left < right) {
        int mid = left + (right - left) / 2;
        mergeSort(arr,left, mid);
        mergeSort(arr, mid + 1, right);
        merge(arr, left, mid, right);
    }
}


void fillArr(int arr[]) {
    for(int i = 0; i<SIZE; i++)
        arr[i] = rand()%SIZE;
}

void printArr(int arr[]) {
    for(int i = 0; i<SIZE; i++)
        printf("%d ", arr[i]);
    printf("\n");
}



