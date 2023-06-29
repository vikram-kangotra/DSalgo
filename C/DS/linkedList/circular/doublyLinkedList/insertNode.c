#include"circular_doubly_linked_list.h"

Node* insertNode(Node* tail, int data, size_t index) {    
    Node* newNode = createNode(data);

    if (tail == NULL) {
        return newNode;
    } else if (index == 0) {
        newNode->prev = tail;
        newNode->next = tail->next;
        tail->next->prev = newNode;
        tail->next = newNode;
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
