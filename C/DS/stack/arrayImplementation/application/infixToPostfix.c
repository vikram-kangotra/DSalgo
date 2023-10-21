#include <stdio.h>
#include <stdlib.h>
#include <string.h>
#include <sys/types.h>
#define MAXSIZE 100

int  stack[MAXSIZE];// works for both char and int
char infix[MAXSIZE];
char postfix[MAXSIZE];

void intoPost();
int top = -1;
int isEmpty();
void push(int );
int  pop();
int precedenceOf(char);
int evaluate_post();
int power(int base, int expo);

int main() {
    printf("Enter the infix expression: ");
    fgets(infix, MAXSIZE, stdin);

    //removing enter from infix which has entered from stdin stream
    infix[strlen(infix) - 1] = '\0';

    intoPost();
    printf("Postfix Expression: %s", postfix);

    int result = evaluate_post();
    printf("\nResult of Postfix = %d\n", result);
    return 0;
}

void intoPost() {
    int i = 0;
    int j = 0;
    int n = strlen(infix);
    char symbol, next;
    for(i = 0; i<n; i++) {

        symbol = infix[i];
        switch (symbol) {
            case ' ':
            case '\t':
                break;

            case '(':
                push(symbol);
                break;

            case ')':
                if(isEmpty()) {
                    printf("\nInvalid Expression!");
                    exit(1);
                }
                while((next = pop()) != '(') {
                    postfix[j++] = next;
                }
                break;

            case '+':
            case '-':
            case '*':
            case '/':
            case '^':
                while (!isEmpty() && precedenceOf(stack[top]) >= precedenceOf(symbol)) 
                    postfix[j++] = pop();
                push(symbol);
                break;

            default:
                postfix[j++] = symbol;


        }
    }

    while (!isEmpty()) 
        postfix[j++] = pop();
    postfix[j] = '\0';

}

int isEmpty() {
    return (top == -1) ? 1 : 0;
}

void push(int symbol) {
    if(top == MAXSIZE - 1) {
        printf("\nStack overflow!");
        return;
    }
    stack[++top] = symbol;
}

int pop(){
    if(top == -1) {
        printf("\nStack Underflow!");
        return '\0';
    }
    return stack[top--];
}

int precedenceOf(char op) {
    switch (op) {
        case '^':
            return 3;

        case '*':
        case '/':
            return 2;

        case '+':
        case '-':
            return 1;

        default:
            return 0;
    }
    return -1;
}

int evaluate_post() {
    int a;
    int b;
    for(int i = 0; i<strlen(postfix); i++) {
        if( '0' <= postfix[i] && postfix[i] <= '9') {
            push(postfix[i] - '0');
        } else {
            a = pop();
            b = pop();
            switch (postfix[i]) {
                case '+':
                    push(b + a);
                    break;
                             
                case '-':
                    push(b - a);
                    break;

                case '*':
                    push(b * a);
                    break;

                case '/':
                    push(b / a);
                    break;

                case '^':
                    push(power(b,a));
                    break;

            }


        }

    }
        
    return  stack[top];

}
int power(int base, int expo) {
    if(expo == 0) return 1;
    
    if(expo % 2 == 0)
        return power(base, expo/2) * power(base, expo/2);
    return base * power(base, expo/2) * power(base,  expo/2);
}
  
