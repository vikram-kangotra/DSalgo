#include <stdio.h>
#include "polynomial.h"

void display_polynomial(struct Node *head) {
    
    if (head == NULL)
        printf("No Polynomial.\n");
    else{
        struct Node* temp = head;
        while (temp != NULL) {
            printf("%0.1fX^%d", temp->coefficient, temp->exponent);
            temp = temp->next;
            if(temp != NULL)
                printf(" + ");
            else
             printf("\n");
        }
    }
}
