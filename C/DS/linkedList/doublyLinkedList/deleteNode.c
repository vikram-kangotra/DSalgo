#include "doublelinkedlist.h"

Node* deleteNode (Node* head, size_t index) {

    if (head == NULL);
    else if(head->next == NULL) {
        free(head);
        head = NULL;
    }
    else if (index == 0) {
        head = head->next;
        free(head->prev);
        head->prev = NULL;
    }
    else {
        Node* prevNode = NULL;
        Node* delNode = head;
        Node* nextNode = head->next;

        while (index > 0 && delNode->next != NULL) {
            prevNode = delNode;
            delNode = nextNode;
            nextNode = delNode->next;
            index--;
        }

        if (nextNode == NULL) {
            prevNode->next = NULL;    
            free(delNode);
        }
        else {
            prevNode->next = nextNode;
            nextNode->prev = prevNode;
            free(delNode);
        } 
    }
    return head;

}
