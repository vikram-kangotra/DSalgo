#include <iostream>
#include <cassert>
#include "binary.h"
#include "linear.h"

void test_linear_search() {
    int arr[] = {5, 4, 9, 5, 7, 2, 6, 0, 7};
    int n = sizeof(arr) / sizeof(arr[0]);
    int x = 7;
    auto result = linear_search(arr, n, x);
    assert(result == 4 && "linear_search failed");
}

void test_binary_search(){
    int arr[] = {2, 5, 6, 8, 9, 11, 12, 13, 15};
    int x = 8;
    auto result = binary_search(arr, x, 0, 8);
    assert(result == 3  && "binary search failed");
}

int main() {

    test_linear_search();
    test_binary_search();

    return 0;
}
