void bubble_sort(int arr[], int n)
{
    int swap;
    for(int j=0; j<n; j++){
        for(int i=0; i<n-1-j; i++){
            if(arr[i] > arr[i+1]){
                swap = arr[i]; 
                arr[i] = arr[i+1]; 
                arr[i+1] = swap;
            }
        }
    }
}
