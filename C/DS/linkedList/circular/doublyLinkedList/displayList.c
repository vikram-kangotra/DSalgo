#include "circular_doubly_linked_list.h"
#include <stdio.h>

void displayList(Node* tail)
{
    if(tail == NULL){
        printf("List is empty!\n");
        return;
    }

    Node* temp = tail->next;
    do {
        printf("%d ", temp->data);
        temp = temp->next;
    } while(temp != tail->next);
    
    printf("\n");
    
}
