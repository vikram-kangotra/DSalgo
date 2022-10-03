int binary_search(int arr[], int n, int x)
{
    //'x' is the element that is to be searched
    int low = 0, mid, high;
    high = n-1;
    while(low <= high){
        mid = low + (high-low)/2;
        if(arr[mid]==x){
            return mid;
            break;
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
