#include <vector>

template <typename T>
void insertionSort(std::vector<T>& arr) {
    for (int i = 1; i < arr.size(); i++) {
        int current = arr[i];
        int prev = i-1;

        //loop to find the right index where the element current should be inserted
        while(prev>=0 and arr[prev] > current)
        {
            arr[prev+1] = arr[prev];
            prev--;
        }

        arr[prev+1] = current;
    }
}
