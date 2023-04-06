#include "linkedList.h"
#include <stdio.h>
#include <stdlib.h>

int main() {
    
    struct Node* head = NULL;
    head = ( struct Node* ) malloc(sizeof(struct Node*));

    int data = 3;
    head->data = data;

    head->next = NULL;

    head = insert ( head, 0, 45 );
    head = insert(head, 1, 55);
    head = insert ( head, 2, 5 );
    head = insert(head, 11, 100);
    head = insert(head, 3, 23);
    head = deleteNode(head, 10000);
    head = deleteNode(head, 2);

    displayList(head);

    displayReversedList(head);
    printf("\n");//it is required to break the line, it cann't be included in recursive-fuction.
    
    return 0;
}
