#include "circular_doubly_linked_list.h"

Node* reverseList(Node* tail) {
    if(tail == NULL) {
        printf("List is Empty!\n");
        return NULL;
    }

    Node* currNode = tail;
    Node* temp = NULL;
    do{
        temp = currNode->prev;
        currNode->prev = currNode->next;
        currNode->next = temp;
        currNode = currNode->prev;
    } while(currNode != tail);
    
    printf("List is reversed!\n");
    return tail->prev ;
}
