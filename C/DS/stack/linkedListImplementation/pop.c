#include "Stack.h"
#include <stdio.h>

int pop(Node **top) {

    int value = -1;

    if (*top == NULL) {
        printf("Stack Underflow!\n");
    } else {
        value = (*top)->data;
        Node* delNode = *top;
        *top = (*top)->next;
    }
    return value;
}
        
