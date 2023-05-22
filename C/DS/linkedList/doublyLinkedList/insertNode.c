#include"doublelinkedlist.h"

Node* insertNode(Node* head, int data, size_t index) {    
    Node* newNode = malloc(sizeof(Node));
    newNode->data = data;
    if (head == NULL) {
        newNode->prev = NULL;
        newNode->next = NULL;
        head = newNode;
    } else if (index == 0) {
        newNode->next = head;
        newNode->prev = NULL;
        head->prev = newNode;
        head = newNode;
    } else {
       Node* temp = head;
       while(index > 1 && temp->next != NULL) {
           temp = temp->next;
           index--;
       }
       newNode->prev = temp;
       newNode->next = temp->next;
       if(temp->next != NULL)
           temp->next->prev = newNode;
       temp->next = newNode;
    }

    return head;
}
