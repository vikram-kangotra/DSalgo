#include "circular_doubly_linked_list.h"
#include <stdio.h>

void displayReversedList(Node *tail) {
    if (tail == NULL) {
        printf("Empty List!\n");
        return;
    }
    
    Node* ptr = tail;
    do {
       printf("%d ", ptr->data);
      ptr = ptr->prev;
    } while (ptr != tail);  

    printf("\n");

}
