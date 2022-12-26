#include "sort.hpp"
#include <iostream>
template <class T>
void displayArray(std::vector<T> arr)
{
    for(int i=0; i<arr.size(); i++)
        std::cout<<arr[i]<<' ';
    std::cout << std::endl;
}
int main()
{
    std::vector<int> vect1 = {6,3,6,2,5};
    Sort<int> SortingBy;
    displayArray(SortingBy.BubbleSort(vect1));
   
    std::vector<int > vect2 = {4,3,0,2,9}; 
    displayArray(SortingBy.SelectionSort(vect2));
    
    std::vector<int > vect3 = {5,4,3,2,1}; 
    displayArray(SortingBy.SelectionSort(vect3));
    return 0;;
}
