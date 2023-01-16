#include <vector>

void swap(int *a, int *b){
    int temp;
    temp = *a;
    *a = *b;
    *b = temp;
}

template <typename T>
std::vector<T> selectionSort(std::vector<T>& arr){
    int min_index;
    for(int i=0; i<arr.size()-1; i++){
        min_index = i;
        for(int j=i; j<arr.size(); j++){
            if(arr[j]<arr[min_index]){
                min_index = j;
            }
        }
        if(min_index != i){
            swap(&arr[min_index], &arr[i]);
        }
    }
    return arr;
}