#include "linkedList.h"
#include "node.h"

struct Node* reverse(struct Node* head){

    if (head == NULL || head->next == NULL) 
        return head;

    struct Node* prevNode;
    struct Node* currentNode;
    struct Node* nextNode;

    prevNode = NULL;
    currentNode = head;

    while (currentNode != NULL) {
        nextNode = currentNode->next;
        currentNode->next = prevNode;
        prevNode = currentNode;
        currentNode = nextNode;
    }

    head = prevNode;

    return  head;
}
