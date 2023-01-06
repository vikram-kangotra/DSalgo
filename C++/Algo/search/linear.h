#include <iostream>
#include <vector>

std::vector<int> linear_search(int* arr, size_t size, int x){
    std::vector<int> result;
    for(int i=0; i<size; i++){
        if(arr[i] == x){
            result.push_back(i);
        }
    }
    return result;
}
