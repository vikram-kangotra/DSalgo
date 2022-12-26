#include <iostream>
#include <vector>
template <class T>
class Sort{
    void Swap(T& a, T& b)
    {      T temp = a;
        a = b;
        b = temp;
    }

    public:
    std::vector<T> BubbleSort(std::vector<T>& arr)
    {
        int n = arr.size();
        for(int i=n-1; i>0; i--)
            for(int j=0; j<i; j++)
                if(arr[j]>arr[j+1])
                    Swap(arr[j], arr[j+1]);

        return arr;
    }

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
                Swap(arr[min_idx],arr[i]);    
        }
        return arr;
    }

    std::vector<T> InsertionSort(std::vector<T>& arr)
    {
        int n = arr.size();
        for(int i=0; i<n-1; i++)
        {
            int j = i+1;
            while(j>0) 
            {
                if(arr[j-1] > arr[j])
                    swap(arr[j-1],arr[j]);
                else
                 break;
                j--;
            }
        }
        return arr;
    }



};


