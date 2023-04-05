#include <stdio.h>
#include <stdlib.h>
#include "polynomial.h"

int main() {
    
    int n;
    printf("Enter the polynomial:\n");

    struct Node* head = NULL; 
    head = create (head);

    display_polynomial (head);

    return 0;
}

