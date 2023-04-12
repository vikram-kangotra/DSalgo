#include "doublelinkedlist.h"
#include <stdio.h>

void displayList(Node* head)
{
    if(head == NULL){
        printf("List is empty!\n");
        return;
    }

    while(head != NULL){
        printf("%d ",head->data);
        head = head->next;
    }
    
    printf("\n");
    
}
