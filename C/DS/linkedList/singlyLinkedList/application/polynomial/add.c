#include "node.h"
#include "polynomial.h"
#include <stdlib.h>
struct Node* add (struct Node* head1, struct Node* head2) {

    if (head1 == NULL || head2 == NULL)
        return NULL;


    struct Node* add_head = NULL;
    struct Node* temp1 = head1;
    struct Node* temp2 = head2;

    while (temp1 != NULL && temp2 != NULL) {
        if (temp1->exponent == temp2->exponent) { 
            add_head = insert(add_head, temp1->coefficient + temp2->coefficient, temp1->exponent);
            temp1 = temp1->next;
            temp2 = temp2->next;
        }
        else if (temp1->exponent > temp2->exponent) {
            add_head = insert(add_head, temp1->coefficient, temp1->exponent);
            temp1 = temp1->next;
        }

        else  {
            add_head = insert(add_head, temp2->coefficient, temp2->exponent);
            temp2 = temp2->next;
        }
    }

    while (temp1 != NULL) {
        add_head = insert(add_head, temp1->coefficient, temp1->exponent);
        temp1 = temp1->next;
    }

    while (temp2 != NULL) {
        add_head = insert(add_head, temp2->coefficient, temp2->exponent);
        temp2 = temp2->next;
    }

    return add_head;
}
