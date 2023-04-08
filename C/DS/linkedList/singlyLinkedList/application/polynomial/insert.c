#include <stdlib.h>
#include <stdio.h>
#include "polynomial.h"

struct Node* insert(struct Node* head, float coefficient, int exponent) {

    if (coefficient == 0)
        return head;

    struct Node* newNode = malloc(sizeof(struct Node));
    newNode->coefficient = coefficient;
    newNode->exponent = exponent;
    newNode->next = NULL;

    if (head == NULL || exponent > head->exponent) {
        newNode->next = head;
        head = newNode;
    }
    else {
        struct Node* temp = head;
        while(temp->next != NULL && temp->next->exponent >= exponent) 
            temp = temp->next;
        //if in case coefficient is same of entered or given term 
        if(temp->exponent == exponent) {
            temp->coefficient += coefficient;
            free(newNode); 
        }
        else {
            newNode->next = temp->next; //in this case we have to add new node
            temp->next = newNode;
        }
    }

    return head;
}

