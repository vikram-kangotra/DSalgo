#include <stdio.h>

/*
 * Queue is data structute which follows FIFO principle that is first in first out.
 * This is program  is related to linear array based implementation of Queue.
 * This program have some inconsistency like it shows queue is full even it is not the case to overcome it we
 * can either shift all value by one step toward left in deque which will be O(n) and inefficient or we 
 * can use circular queue 
 *  
 */

//data members and fuction related to Queue

#define  MAXSIZE  5
int Q[MAXSIZE];
int front = -1;
int rear = -1;

int isEmpty();
int isFull();
void dequeue();
void enqueue(int data);
void reverseQueue();
void deleteQueue();
void print();

//main fuction
int main() {

    int choice, data, flag = 1;
    while(flag) {
        printf("\n1. Enqueue\n");
        printf("2. Dequeue\n");
        printf("3. Print the  elements of the queue.\n");
        printf("4. Reverse the queue.\n");
        printf("5. Delete queue.\n");
        printf("6. Quit.\n");
        printf("Please enter your choice: ");
        scanf("%d", &choice);

        switch(choice) {

            case 1:
                printf("Enter the element to be enqueued: ");
                scanf("%d", &data);
                getchar();
                enqueue(data);
                break;

            case 2: 
                dequeue();
                break;

            case 3:
                print();
                break;

            case 4:
                reverseQueue();
                break;
                
            case 5:
                deleteQueue();
                break;

            case 6:
                flag = 0;
                break;

            default:
                printf("Invalid Input!\n");
                getchar();
        }
    }

}

//implementation of queue fuctions.
int isFull() {
    if(rear == MAXSIZE - 1)
        return 1;
    return 0;
}

int isEmpty() {
    if(front == -1)
        return 1;
    return 0;
}

void enqueue(int data) {
    if(isFull()) {
        printf("Queue is Full.\n");
    } else {
        if(front == -1) {
            front++;
        }
        rear++;
        Q[rear] = data;
    }
}

void dequeue() {
    if (isEmpty()) {
        printf("Queue is Empty.\n");
    } else {
        int temp = Q[front];
        if(front == rear)
            front = rear = -1;
        else
            front++;
    printf("%d is deleted.\n", temp);
    }
}
void reverseQueue() {
    int i = front;
    int j = rear;
    while(i<j) {
        int temp = Q[i];
        Q[i] = Q[j];
        Q[j] = temp;
        i++;
        j--;
    }
}

void deleteQueue() {
    front = rear = -1;
}
void print() {
    if(isEmpty()) {
        printf("Queue is empty.\n");
        return;
    }
    for(int i=front; i<=rear; i++)
        printf("%d ", Q[i]);
    printf("\n");
}
        
