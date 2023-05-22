#include "Stack.h"

void reverseStack(Node **top) {

    Node* top1 = NULL;
    Node* top2 = NULL;
    
    //pushing on temporary stack1
    while (*(top) != NULL) {
        push(&top1, pop(top));
    }
    
    //pushing on temporary stack2
    while (top1 != NULL) {
        push(&top2, pop(&top1));
    }

    //pushing on orginal stack.
    while (top2 != NULL) {
        push(top, pop(&top2));
    }
    printf("Stack is reversed.\n");
    
}


