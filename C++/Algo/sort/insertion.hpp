#include <iostream>
#include <vector>

template <class T>
std::vector<T> InsertionSort(std::vector<T>& arr)
{
    int n = arr.size();
    for(int i=0; i<n-1; i++)
    {
        int j = i+1;
        while(j>0) 
        {
            if(arr[j-1] > arr[j])
                std::swap(arr[j-1],arr[j]);
            else
                break;
            j--;
        }
    }
    return arr;
}
