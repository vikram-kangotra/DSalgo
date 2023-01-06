#include <iostream>
#include <cassert>
#include "linear.h"

void test_linear_search() {
    int arr[] = {5, 4, 9, 5, 7, 2, 6, 0, 7};
    int n = sizeof(arr) / sizeof(arr[0]);
    int x = 7;
    auto result = linear_search(arr, n, x);
    assert(result == std::vector<int>({4, 8}) && "linear_search failed");
}

int main() {

    test_linear_search();

    return 0;
}
