#include "Array.h"
#include <stdio.h>

int main() {
    int arr1[MAXSIZE] = {1,2,3,4,5,4};
    int size1 = 6;

    traverse_1D_array(arr1, size1);

    insert(arr1, &size1, 3, 3);
    traverse_1D_array(arr1, size1);
    insert(arr1, &size1, -3, -1);
    insert(arr1, &size1, 3, 23);

    delete_element(arr1, &size1,23);
    delete_element(arr1, &size1,3);
    traverse_1D_array(arr1, size1);

    
    int arr2[MAXSIZE] = {10,22,12,44,23,67};  
    int size2 = 6;
    int arr3[MAXSIZE] = {};
    int size3 = 0;

    concatenate(arr1, size1, arr2, size2, arr3, &size3);
    traverse_1D_array(arr3, size3);

    reverse(arr3, size3);
    traverse_1D_array(arr3, size3);

    sort(arr1, size1);
    traverse_1D_array(arr1, size1);
    sort(arr3, size3);
    traverse_1D_array(arr3, size3);

    int arr4[MAXSIZE] = {};
    int size4 = 0;
    merge(arr1, size1, arr3, size3, arr4, &size4);
    traverse_1D_array(arr4, size4);

    linear_search(arr4, size4, 100);

    binary_search(arr4, size4, 5);

    return 0;
}

/* to compile write on terminal.
 * gcc *.c -o array_main
 *
 * to run write
 * ./array_main
 */
