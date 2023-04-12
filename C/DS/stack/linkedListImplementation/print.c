#include "Stack.h"
#include <stdio.h>

void print(Node *top) {
    
    if (top == NULL) {
        printf("Stack is Empty.\n");
        return;
    }
    while(top != NULL) {
        printf("%d ", top->data);
        top = top->next;
    }

    printf("\n");
}
