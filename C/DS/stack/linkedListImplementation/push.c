#include "Stack.h"
#include <stdio.h>

void push(Node** top, int data) {
    Node* newNode = malloc(sizeof(Node));
    if (newNode == NULL) {
        printf("Stack Overflow!\n");
        return;
    }
    newNode->data = data;
    newNode->next = *top;
    *top = newNode;
}
