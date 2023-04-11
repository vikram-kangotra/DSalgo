#pragma once

typedef struct Node{
    struct Node* prev;
    int data;
    struct Node* next;
} Node;
