#include "../Stack.h"
#include <stdio.h>

Node* top = NULL;

void decimal_to_binary(int number) {

    while (number != 0) {
        push(&top, number % 8);
        number = number / 8;
    }
    while (top != NULL) 
        printf("%d", pop(&top));
    printf("\n");
}

int main(int argc, char* argv[]) {
    if(argc != 2) {
        printf("Enter the number whose binary is required.\n");
        return 1;
    }

    decimal_to_binary(atoi(argv[1]));

    return 0;
}

