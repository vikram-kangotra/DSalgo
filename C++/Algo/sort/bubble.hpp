#include <iostream>
#include <vector>

template <class T>  
std::vector<T> BubbleSort(std::vector<T>& arr)
{
    int n = arr.size();
    for(int i=n-1; i>0; i--)
        for(int j=0; j<i; j++)
            if(arr[j]>arr[j+1])
                std::swap(arr[j], arr[j+1]);
    return arr;
}
