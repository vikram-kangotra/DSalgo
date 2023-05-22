#include<stdlib.h>
#include<stdio.h>
#include"node.h"

Node* reverseList(Node* head)
{
    if (head != NULL && head->next != NULL) {
        Node* temp = NULL;
        Node* currNode = head;

        while (currNode != NULL) {
            temp = currNode->prev;
            currNode->prev = currNode->next;
            currNode->next = temp;
            currNode = currNode->prev; //because the address of next node to currNode is stored in currNode->prev.
        }

        head = temp->prev; //because temp points to second last node and this node have address of last node in prev part.
    }


    return head;

}
