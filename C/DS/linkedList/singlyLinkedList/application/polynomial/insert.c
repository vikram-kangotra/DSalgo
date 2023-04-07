#include <stdlib.h>
#include <stdio.h>
#include "polynomial.h"

struct Node* insert(struct Node* head, float coefficient, int exponent) {
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
        while(temp->next != NULL && temp->next->exponent > exponent) 
            temp = temp->next;
        newNode->next = temp->next;
        temp->next = newNode;
    }

    return head;
}

