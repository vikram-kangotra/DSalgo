int binary_search(int* arr, int x, int low, int high){
    int mid; 

    if(arr[low] == x)
        return low;
    else if(arr[high] == x)
        return high;

    while(low<=high){
        mid = (high+low)/2;
        if (arr[mid] == x){
            return mid;
        }
        else if(arr[mid]>x){
            high = mid-1;
        }
        else{
            low = mid+1;
        }
    }
    return -1;
}