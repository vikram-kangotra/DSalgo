#include "doublelinkedlist.h"
#include <stdio.h>

void displayReversedList(Node *head) {
    if (head == NULL) {
        printf("Empty List!\n");
        return;
    }
    while (head->next != NULL) 
        head = head->next;

    while(head->prev != NULL){
        printf("%d ", head->data);
        head = head->prev;
    }
    printf("%d\n", head->data);

}
