void selection_sort(int arr[], int n)
{
    int i, j, smallest;
    for (i=0; i<n-1; i++){
        smallest = i;

        for (j=i+1; j<n; j++){
            if (arr[j]<arr[smallest]){
                smallest = j;
            }
        }
        if(smallest != i){
            int temp = arr[smallest];
            arr[smallest] = arr[i];
            arr[i] = temp;
        }
    }
}