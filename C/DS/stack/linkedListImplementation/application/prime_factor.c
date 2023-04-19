#include "../Stack.h"
#include <stdio.h>

Node* top = NULL;

void prime_fact (int number) {

    int i = 2;
    while (number != 1) {
        while (number % i == 0) {
            push(&top, i);
            number = number / i;
        }
        i++;
    }
    
    printf("Prime factors of given number are: ");
    while (top != NULL) 
        printf("%d ", pop(&top));

    printf("\n");
}


int main() {
    
    int number;
    printf("Enter the number whose prime factor is required: ");
    scanf("%d", &number);
    
    prime_fact(number);


    return 0;
}


