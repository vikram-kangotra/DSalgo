#include "linkedList.h"

struct Node* insert (struct Node* head, size_t index, int data) {

    struct Node* newNode = createNode(data);

    if (head == NULL || index == 0) {
        newNode->next = head;
        head = newNode;
        return head;
    }

    struct Node* temp = head;
    while (index > 1 && temp->next != NULL){
        temp = temp->next;
        index--;
    }

    newNode->next = temp->next;
    temp->next = newNode;

    return head;
} 
