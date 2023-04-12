#include "doublelinkedlist.h"

Node* deleteList (Node* head) {
    if (head == NULL);
    else {
        while(head->next != NULL) {
            head = head->next;
            free(head->prev);
        }
        free(head);

    }

    return NULL;
}
