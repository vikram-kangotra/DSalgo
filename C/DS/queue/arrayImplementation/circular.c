#include <stdio.h>
#include <stdbool.h>
#include <limits.h>
#define MAXSIZE 5

//circular queue functions and data members
int cq[MAXSIZE];
int front = -1;
int rear = -1;
void enQueue(int);
int deQueue();
bool isEmpty() { return front == -1; }
bool  isFull() { return ( (front == 0 && rear == (MAXSIZE - 1) ) || rear == (front - 1) % (MAXSIZE - 1) ) ? true : false; }
//print element of queue
void printQ();

int main() {
    int choice;
    int Element;
    bool flag = true;
    while(flag) {
        printf("\n1. EnQueue \n2. DeQueue \n3. Display Element. \n4. Exit \nEnter your choice:");
        scanf("%d", &choice);
        getchar();
        switch (choice) {
            case 1:
                printf("Enter Element to be Enqueued:");
                scanf("%d", &Element);
                enQueue(Element);
                break;

           case 2:
                Element = deQueue();
                printf("Element Dequeued: %d\n",Element);
                break;

           case 3:
                printQ();
                break;

          case 4:
                flag = false;
                break;

           default:
                printf("Invalid Input!\n\n");
        }
    }
    return 0;
}

void enQueue(int d) {
    if(isFull()) {
        printf("Queue is full!\n");
        return;
    } 

    if(isEmpty()) {
        front = 0;
        rear = 0;
    } else if(rear == MAXSIZE - 1  && front != 0) {
        rear = 0;
    } else {
        rear++;
    }
    cq[rear] = d;
}

int deQueue() {
    if(isEmpty()) {
        printf("Queue is empty!\n");
        return INT_MIN;
    }
    
    int ret = cq[front];
    if(rear == front) {
        rear = front = -1;
    } else if(front == MAXSIZE - 1) {
        front = 0;
    } else {
        front++;
    }

    return ret;
}

void printQ() {
    if(front == -1) {
        printf("Queue is empty!\n");
        return;
    }
    
    printf("Element of Queue:\n");
    if(front <= rear) {
        for(int i = front; i<=rear; i++)
            printf("%d ", cq[i]);
    } else {
        for(int i = front; i<MAXSIZE; i++)
            printf("%d ", cq[i]);

        for(int i = 0; i <= rear; i++)
            printf("%d ", cq[i]);
    }
}

