#include <bits/stdc++.h>
using namespace std;
void printArray(int *arr, int size)
{
    for (int i = 0; i < size; i++)
    {
        cout << arr[i] << " ";
    }
    cout << endl;
}
int partition(int *arr, int s, int e)
{
    int pivot = arr[s];
    int count = 0;
    for (int i = s + 1; i <= e; i++)
    {
        if (pivot >= arr[i])
            count += 1;
    }
    int pivotIndex = s + count;
    swap(arr[s], arr[pivotIndex]);
    int i = s, j = e;
    while (i < pivotIndex && j > pivotIndex)
    {

        while (arr[i] <= arr[pivotIndex])
        {
            i++;
        }
        while (arr[j] > arr[pivotIndex])
        {
            j--;
        }
        if (i < pivotIndex && j > pivotIndex)
        {
            swap(arr[i++], arr[j--]);
        }
    }
    return pivotIndex;
}
void quickSort(int arr[], int s, int e)
{
    if (s >= e)
        return;
    int p = partition(arr, s, e);
    quickSort(arr, s, p - 1);
    quickSort(arr, p + 1, e);
}
int main()
{
    int arr[] = {5, 2, 4, 1, 8, 3};
    int n = sizeof(arr) / sizeof(int);
    cout << "after sorting \n";
    quickSort(arr, 0, n - 1);
    printArray(arr, n);
}
