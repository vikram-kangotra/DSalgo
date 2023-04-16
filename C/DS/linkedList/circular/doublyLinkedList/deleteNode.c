#include "circular_doubly_linked_list.h"
#include "node.h"

Node* deleteNode (Node* tail, size_t index) {

    if (tail == NULL || tail->next == tail) {
        free(tail);
        tail = NULL;
    }
    else if (index == 0) {
        Node* head = tail->next;
        tail->next = head->next;
        free(head);
        tail->next->prev = tail;
    }
    else {
        Node* temp = tail->next;
        Node* delNode;

        while (index > 1) {
            temp = temp->next;
            index--;
        }

        delNode = temp->next;
        if(delNode == tail)
            tail = delNode;
        temp->next = delNode->next;
        delNode->next->prev = temp;
        free(delNode);
        delNode = NULL;

    }
    return tail;

}
