#pragma once
#include <stdio.h>

#define MAXSIZE 50

void insert(int arr[], int* size, int data, int index);

void delete_element(int arr[], int* size, int index);

void concatenate(int arr1[], int size1, int arr2[], int size2, int result_[], int* result_size);

void reverse(int arr[], int size);

void sort(int arr[], int size);

void merge(int arr1[], int size1, int arr2[], int size2, int result[], int* result_size);

int  linear_search(int arr[], int size, int target);

int binary_search(int arr[], int size, int target);

void traverse_1D_array(int arr[], int size);

