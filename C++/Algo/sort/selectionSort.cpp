void selectionSort(int arr[], int n)
{
    for(int i=0; i<n-1; i++)
    {
        int current = arr[i];
        int min_pos = i;

        //finding the min element
        for(int j=i; j<n;j++)
        {
            if(arr[j]<arr[min_pos])
            {
                min_pos = j;
            }
        }
        //swaping
        swap(arr[i], arr[min_pos]);
    }
}
