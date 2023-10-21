#include <stdio.h>
#include <stdlib.h>
#include "node.h"

Node* createNode(int data);

void circularDoubleLinkedList();

Node* insertNode (Node* tail, int data, size_t index);

Node* deleteNode (Node* tail, size_t index);

Node* deleteList (Node* tail);

void displayList (Node* tail);

Node* reverseList (Node* tail);
