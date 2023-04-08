#include "polynomial.h"
#include <stdlib.h>
#include <sys/types.h>
struct Node* multiply (struct Node* head1, struct Node* head2) {

    if (head1 == NULL || head2 == NULL)
        return NULL;
    
    struct Node* temp1 = head1;
    struct Node* temp2 = head2;
    struct Node* mul_head = NULL;

    while (temp1 != NULL) {
        while (temp2 != NULL) {
            mul_head = insert(mul_head, temp1->coefficient * temp2->coefficient, temp1->exponent + temp2->exponent);
            temp2 = temp2->next;
        }
        temp1 = temp1->next;
        temp2 = head2;
     }

    return mul_head;
}
