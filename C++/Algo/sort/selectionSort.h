#include <vector>

template <typename T>
void selectionSort(std::vector<T>& arr){
    int min_index;
    for(int i=0; i<arr.size()-1; i++){
        min_index = i;
        for(int j=i; j<arr.size(); j++){
            if(arr[j]<arr[min_index]){
                min_index = j;
            }
        }
        if(min_index != i){
            int temp ;
            temp = arr[min_index];
            arr[min_index] = arr[i];
            arr[i] = temp; 
        }
    }
}