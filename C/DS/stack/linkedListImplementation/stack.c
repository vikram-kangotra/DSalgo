#include <stdio.h>
#include "Stack.h"

void stack() {
    Node* top = NULL;

    int choice, data, flag = 1;
    while(flag) {
        printf("\n1. Push\n");
        printf("2. Pop\n");
        printf("3. Print Top element of the stack\n");
        printf("4. Reverse the stack.\n");
        printf("5. Print all Element on stack.\n");
        printf("6. Delete stack.\n");
        printf("7. Quit.\n");
        printf("Please enter your choice: ");
        scanf("%d", &choice);

        switch(choice) {

            case 1:
                printf("Enter the element to be pushed: ");
                scanf("%d", &data);
                push(&top, data);
                break;

            case 2: 
                data = pop(&top);
                printf("deleted element is %d\n", data);
                break;

            case 3:
                data = peek(top);
                if(data >= 0)
                    printf("top element of stack is %d\n", data);
                break;

            case 4:
                reverseStack(&top);
                break;
                
            case 5:
                print(top);
                break;

            case 6:
                deleteStack(&top);
                break;

            case 7:
                flag = 0;
                break;

            default:
                printf("Invalid Input!\nTry again.\n");
                getchar();

        }
    }
}

