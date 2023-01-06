#include <iostream>
#include <vector>

// is only able to sort a vector of comparable 
// elements
template <class T>
std::vector<T> BubbleSort(std::vector<T>& arr){
    int n = arr.size();
    for(int i=n-1; i>0; i--)
    {
        for(int j=0; j<i; j++)
        {
            if(arr[j]>arr[j+1])
            {
                int temp = arr[j];
                arr[j] = arr[j+1];
                arr[j+1] = temp;
            }
                
        }
    }
    return arr;
}
