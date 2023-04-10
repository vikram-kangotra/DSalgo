#include <stdio.h>
#include <stdlib.h>
#define MAXSIZE 5

int stack_arr[MAXSIZE];
int top = -1;

int isEmpty();
void push(int data);
int pop();
int peek();

int main() {
    int choice, data, flag = 1;
    while(flag) {
        printf("\n1. Push\n");
        printf("2. Pop\n");
        printf("3. Print Top element of the stack\n");
        printf("4. Quit\n");
        printf("Please enter your choice: ");
        scanf("%d", &choice);

        switch(choice) {

            case 1:
                printf("Enter the element to be pushed: ");
                scanf("%d", &data);
                push(data);
                break;

            case 2: 
                data = pop();
                if(data >= 0 )
                    printf("deleted element is %d\n", data);
                break;
            
            case 3:
                data = peek();
                if(data >= 0)
                    printf("top element of stack is %d\n", data);
                break;

            case 4:
                flag = 0;
                
        }
    }
}

int isEmpty() {
    if(top == -1)
        return 1;
    return 0;
}

void push(int data) {
    if(top == MAXSIZE - 1)
        printf("Stack OverFlow\n");
    else 
        stack_arr[++top] = data;
}

int pop() {
    if(isEmpty()){
        printf("Stack UnderFlow\n");
        return -1 ;
    }

    int ret = stack_arr[top--];
    return ret;
}


int peek() {
    if(top != -1)
        return stack_arr[top];
    return -1;
}

