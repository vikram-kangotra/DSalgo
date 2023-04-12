#include "Stack.h"

void push(Node** top, int data) {
    Node* newNode = malloc(sizeof(Node));
    newNode->data = data;
    newNode->next = *top;
    *top = newNode;
}
