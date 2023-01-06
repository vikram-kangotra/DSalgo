#include<iostream>
using namespace std;
void linearSearch(int *arr, int size, int x){
    int *a = new int[size];
    int pos=0;
    for(int i=0; i<size; i++){
        if(arr[i] == x){
            a[pos] = i;
            pos++;
        }
    }
    if(pos==0){
        cout<<"Number not present";
    }
    else{
        cout<<"Number present at location(s):"<<endl;
        cout<<a[0]<<endl;
        for(int i=1; i<sizeof(a); i++){
            if(a[i-1]<a[i]){
                cout<<a[i]<<endl;
            }
            else{
                break;
            }
        }
    }
}