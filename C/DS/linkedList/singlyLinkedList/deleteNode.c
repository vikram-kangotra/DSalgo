#include "linkedList.h"
#include <sys/types.h>

struct Node* deleteNode (struct Node* head, size_t index) {
    
    struct Node* temp = head;
    if (index == 0) {
        temp = head->next;
        free(head);
        return temp;
    }
    else if(head->next == NULL) {
        free(head);
        return NULL;
    }

    
    while (index > 1 && temp->next->next != NULL) {
        temp = temp->next;
        index--;
    }
    struct Node* temp2 = temp->next;
    temp->next = temp2->next;
    free(temp2);
    temp2 = NULL;
    

    return head;
}
