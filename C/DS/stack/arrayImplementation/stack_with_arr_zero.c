#include <stdio.h>
#include <stdlib.h>
#define MAXSIZE 5

//data storing and counter
int stack_arr[MAXSIZE];
int first_element = -1;

//stack's basic fuction
int isEmpty();
void push(int data);
int pop();
int peek();

//just to see element. It is not a fuction related to stack, it is just for user's help to visualise processes.
void print();

int main() {
    int choice, data, flag = 1;
    while(flag) {
        printf("\n1. Push\n");
        printf("2. Pop\n");
        printf("3. Print Top element of the stack\n");
        printf("4. Print all Element on stack.\n");
        printf("5. Quit\n");
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
                print();
                break;

            case 5:
                flag = 0;
                break;

            default:
                printf("Invalid Input!\nTry again.\n");
                getchar();
                
        }
    }
}

int isEmpty() {
    if(first_element == -1)
        return 1;
    return 0;
}

void push(int data) {
    if(first_element == MAXSIZE - 1)
        printf("Stack OverFlow!\n");
    else {
        ++first_element;
        for(int i=first_element; i>=0; i--)
            stack_arr[i+1] = stack_arr[i];
        stack_arr[0] = data;
    } 
        
}

int pop() {
    if(isEmpty()){
        printf("Stack UnderFlow!\n");
        return -1 ;
    }
    
    int ans =   stack_arr[0];
    for(int i = 0; i<first_element; i++)
        stack_arr[i] = stack_arr[i+1];
    first_element--;
    return ans;
}


int peek() {
    if(first_element != -1)
        return stack_arr[0];

    printf("Stack is Empty!\n");
    return -1;
}

void print() {
    if(first_element < 0)
        printf("Stack is Empty!\n");

    for(int i=0; i<=first_element; i++)
        printf("%d ", stack_arr[i]);

    printf("\n");
}
