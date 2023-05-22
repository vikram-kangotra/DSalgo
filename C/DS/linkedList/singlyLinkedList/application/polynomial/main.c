#include <stdio.h>
#include <stdlib.h>
#include "node.h"
#include "polynomial.h"

int main() {
    
    int n;
    printf("Enter the polynomial1:\n");

    struct Node* head1 = NULL; 
    head1 = create (head1);

    printf("Enter the polynomial2:\n");
    struct Node* head2 = NULL;
    head2 = create(head2);

    struct Node* add_head = add(head1, head2);
    struct Node* subtract_head = subtract(head1, head2);
    struct Node* multiply_head = multiply(head1, head2);
    
    printf("polynomial1: ");
    display_polynomial (head1);
    printf("polynomial2: ");
    display_polynomial (head2);
    printf("polynomial1 + polynomial2: ");
    display_polynomial (add_head);
    printf("polynomial1 - polynomial2: ");
    display_polynomial (subtract_head);
    printf("polynomial1 * polynomial2 : ");
    display_polynomial (multiply_head);

    return 0;
}

