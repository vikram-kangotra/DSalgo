#include"circular_doubly_linked_list.h"

Node* insertNode(Node* tail, int data, size_t index) {    
    Node* newNode = malloc(sizeof(Node));
    newNode->data = data;
    if (tail == NULL) {
        newNode->prev = newNode;
        newNode->next = newNode;
        tail = newNode;
    } else if (index == 0) {
        newNode->prev = tail;
        newNode->next = tail->next;
        tail->next->prev = newNode;
        tail->next = newNode;
        tail = newNode;
    } else {
       Node* temp = tail->next;
       while(index > 1) {
           temp = temp->next;
           index--;
       }
       newNode->prev = temp;
       newNode->next = temp->next;
       temp->next->prev = newNode;
       temp->next = newNode;
    }

    return tail;
}
