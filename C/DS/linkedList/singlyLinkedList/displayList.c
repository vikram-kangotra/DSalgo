#include <stdio.h>
#include "node.h"

void displayList(struct Node* head){
    if(head == NULL)
        printf("List is empty\n");
    
       
    while(head != NULL )
    {
        printf("%d ",head->data);
        head = head->next;
    }
    printf("\n");
}

