#include<iostream>
#include "linear.h"
#include "binary.h"
using namespace std;

int main(){
    int size = 8;
    int arr[8] = {5, 4, 9, 5, 7, 2, 6, 0};
    int x;
    cout<<"Enter the item to be searched"<<endl;
    cin>>x;
    linearSearch(arr, size, x);
}