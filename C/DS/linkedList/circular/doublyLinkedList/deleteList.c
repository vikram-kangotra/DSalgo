#include "circular_doubly_linked_list.h"

Node* deleteList (Node* tail) {
    if (tail != NULL){
        Node* temp = tail->next;
        while (temp != tail) {
            temp = temp->next;
            free(temp->prev);
        }
        free(tail);
    }
    printf("List is deleted!\n");

    return NULL;
}
