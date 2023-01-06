#include <iostream>
#include <vector>
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
template<class T>
void display(const std::vector<T>& arr)
{
    int size = arr.size();
    for(int i=0; i<size; i++)
        std::cout<<arr[i] << ' ' ;
    std::cout<<std::endl;
}
int main(){
    std::vector<int> arri = { 1 , 3 , 3 ,7,4};
    display<int>(arri);
    BubbleSort<int>(arri);
    display<int>(arri);
    std::vector<float> arrf = { 1.3 , 3.3 , 3.44 ,3.43,3.44};
    display<float>(arrf);
    std::vector<float> test = BubbleSort<float>(arrf);
    display<float>(arrf);
    display<float>(test);

}
