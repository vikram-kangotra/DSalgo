
#include "polynomial.h"
#include <stdio.h>

struct Node* create (struct Node* head) {

     int n;// number of terms
     int i;//iterator
     float coeff;
     int exponent;

     printf("Enter the number of terms:\n");
     scanf("%d", &n);

     for(i = 0; i<n; i++) {
         printf("Enter the coefficient for term %d:", i+1);
         scanf("%f", &coeff);
     
         printf("Enter the exponent for term %d:", i+1);
         scanf("%d", &exponent);

         head = insert(head, coeff, exponent);
     }

     return head;
}
