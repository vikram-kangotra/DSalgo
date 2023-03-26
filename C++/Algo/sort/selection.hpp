#include <iostream>
#include <vector>
template <class T>

std::vector<T> SelectionSort(std::vector<T>& arr)
{
    int n = arr.size();
    T min_idx;
    for(int i=0; i<n-1; i++)
    {
        min_idx = i;
        for(int j=i+1; j<n; j++)
            if(arr[j]<arr[min_idx])
                min_idx = j;

        if(min_idx != i)   
            std::swap(arr[min_idx],arr[i]);    
    }
    return arr;
}
