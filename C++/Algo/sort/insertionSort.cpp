#include <iostream>
using namespace std;

void insertionSort(int arr[], int n)
{
    for(int i=1; i<n; i++)
    {
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

int main()
{
    int arr[]= {7,4,3,6,-9,5};
    int n = sizeof(arr)/sizeof(int);

    insertionSort(arr, n);
    for(int i=0; i<n; i++)
    {
        cout << arr[i] << " ";
    }
}
Footer
