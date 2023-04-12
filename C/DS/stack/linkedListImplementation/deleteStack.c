#include "Stack.h"

void deleteStack (Node** top) {
    Node* delNode = *top;

    while (*top != NULL) {
        *top = (*top)->next;
        free(delNode);
        delNode = *top;
    }
}
