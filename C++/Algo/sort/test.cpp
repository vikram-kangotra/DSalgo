#include <iostream>
#include "bubbleSort.h"
#include "insertionSort.h"
#include "selectionSort.h"
#include <cassert>

void test_bubble_sort() {
    auto vec = std::vector<int>{6, 5, 3, 2, 8, 1, 7, 4};
    auto sorted = std::vector<int>{1, 2, 3, 4, 5, 6, 7, 8};
    bubbleSort(vec);
    assert(vec == sorted && "bubble sort failed");
}

void test_insertion_sort() {
    auto vec = std::vector<int>{6, 5, 3, 2, 8, 1, 7, 4};
    auto sorted = std::vector<int>{1, 2, 3, 4, 5, 6, 7, 8};
    insertionSort(vec);
    assert(vec == sorted && "insertion sort failed");
}

void test_selection_sort(){
    auto vec = std::vector<int>{6, 5, 3, 2, 8, 1, 7, 4};
    auto sorted = std::vector<int>{1, 2, 3, 4, 5, 6, 7, 8};
    selectionSort(vec);
    assert(vec == sorted && "selection sort failed");
}

int main() {

    test_bubble_sort();
    test_insertion_sort();
    test_selection_sort();

    return 0;
}
