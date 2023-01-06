#include <iostream>

size_t linear_search(int* arr, size_t size, int x){
    for(int i=0; i<size; i++){
        if(arr[i] == x){
            return i;
        }
    }
    return size;
}
