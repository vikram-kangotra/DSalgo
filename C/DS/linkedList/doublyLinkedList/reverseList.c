#include<stdlib.h>
#include<stdio.h>
#include"node.h"

Node* reverseList(Node* head)
{
    if(head == NULL ) {
        printf("List is empty\n");
    } else if(head->next != NULL) {
        Node* currNode = head;
        Node* nextNode = head->next;

        currNode->next = NULL;
        currNode->prev = nextNode;

        while(nextNode != NULL)
        {
            nextNode->prev = nextNode->next;
            nextNode->next = currNode;
            currNode = nextNode;
            nextNode = nextNode->prev;
        }
        head = currNode;
    }

    return head;

}
