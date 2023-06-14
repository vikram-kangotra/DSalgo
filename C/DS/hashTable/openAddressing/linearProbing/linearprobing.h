#pragma once

#include <limits.h>
#include <stdlib.h>
#include <stdbool.h>

void createHashTable(int size);
void initTable();
void insertElement(int element);
void deleteElement(int element);
void searchElement(int element);
void deleteTable();
void displayElements();

