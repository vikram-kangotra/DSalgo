#include <stdio.h>
#include <stdlib.h>
#include "linearprobing.h"

int size;
int* hashTable = NULL;
int count = 0;
int size = 1; // random init
int probe;

enum {
    EMPTY = INT_MIN,
    DELETED = INT_MAX
};

void initTable() {
    if (hashTable != NULL)
        for(int i = 0; i < size; i++) 
            hashTable[i] = EMPTY;
    else {
        printf("Memory Allocation Error for hashTable!\n");
        exit(1);
    }
}

void createHashTable(int sz) {
    size = sz;
    hashTable = malloc(sizeof(int) * sz); 
}

int calculateHash(int element) {
    return element % size;
}

void insertElement(int element) {
    if(count == size) {
        printf("table is full!\n");
        return;
    }
    probe = calculateHash(element);
    bool flag = true;
    for(int i = probe; i < size; i++) {
        if(hashTable[i] == element) {
            printf("Entry should be unique!\n");
            return;
        } else if(hashTable[i] == EMPTY || hashTable[i] == DELETED) {
            hashTable[i] = element;
            count++;
            return;
        }
    }
    if(flag == true) {
        for(int i = 0; i < probe; i++) {
            hashTable[i] = element;
            count++;
            return;
        }
    }

}

void deleteElement(int element){
    if(count == 0) {
        printf("Table is empty!\n");
        return;
    }

    bool flag = true;
    probe = calculateHash(element);
    for(int i = probe; i < size; i++) {
        if (hashTable[i] == EMPTY) {
            flag = false;
            break;
        } else if(hashTable[i] == element) {
            hashTable[i] = DELETED;
            count--;
            return;
        }
    }
    if(flag == true) {
        for(int i = 0; i < probe; i++) {
            hashTable[i] = element;
            count++;
            break;
        }
    }

}

void displayElements() {
    for(int i = 0; i < size; i++) {
        if(hashTable[i] == EMPTY) 
            printf("%d --> EMPTY\n", i);
        else if(hashTable[i] == DELETED)
            printf("%d --> DELETED\n", i);
        else
            printf("%d --> %d\n", i, hashTable[i]);
    }
}

void searchElement(int element) {
    probe = calculateHash(element);
    if(count == 0) {
        printf("Table is empty!\n");
        return;
    }

    bool flag = true; // to have a signal whether element is found in 1st loop or not.
    for(int i = probe; i < size; i++) {
        if(hashTable[i] == element) {
            printf("Element %d is at index %d\n", element, i);
            return;
        }
        if(hashTable[i] == EMPTY) {
            printf("Element %d is not present in the table\n", element);
            return;
        }        
    }

    for(int i = 0; i < probe; i++) {
        if(hashTable[i] == element) {
            printf("Element %d is at index %d\n", element, i);
            return;
        }
        if(hashTable[i] == EMPTY) {
            printf("Element %d is not present in the table\n", element);
            return;
        }        
    }

}

void resetTable() {
    initTable();
}

void deleteTable() {
    free(hashTable);
    hashTable = NULL;
}





