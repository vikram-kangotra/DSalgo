#include "Stack.h"
#include <stdio.h>

int peek(Node* top) {
    
    int val = -1;

    if (top == NULL) {
       printf("Stack is Empty!\n");
    } else {
       val = top->data;
    }
   return val;
}
