#include "linear_queue.h"
#include <stdio.h>
#include <stdlib.h>
#include <sys/types.h>
#include <limits.h>

void createLinearQueue(LinearQueue* lq) {
    lq->front = NULL;
    lq->rear = NULL;
}

Node* createNewNode(int data) {
    Node* newNode = malloc(sizeof(Node));
    newNode->data = data;
    newNode->next = NULL;
    return newNode;
}

void enqueue(LinearQueue *lq, int data) {
    Node* newNode = createNewNode(data);
    if(newNode == NULL) {
        printf("Queue overflow!\n");
        return;
    }


    if(lq->front == NULL) {
        lq->front = newNode;
        lq->rear = lq->front;
        return;
    }

   
    lq->rear->next = newNode;
    lq->rear = lq->rear->next;
}

int dequeue(LinearQueue *lq) {
    if(lq->front == NULL) {
        printf("Queue underflow!\n");
        return INT_MIN;
    }
    
    int ret = lq->front->data;
    if(lq->front == lq->rear) {
        free(lq->front);
        lq->front = lq->rear = NULL;
        return ret;
    } 
    
    Node* delNode = lq->front;
    lq->front = lq->front->next;
    free(delNode);
    delNode = NULL;
    return  ret;
}

int peek(LinearQueue* lq) {
    if(lq->front == NULL) {
        printf("Queue Empty!\n");
        return INT_MIN;
    }

    if(lq->front == NULL) 
        return INT_MIN;
    return lq->front->data;
}

void display(LinearQueue* lq) {
    if(lq->front == NULL) {
        printf("Queue Empty!\n");
    }

    Node* itterator = lq->front;
    while(itterator != NULL) { 
        printf("%d ", itterator->data);
        itterator =itterator->next;
    }
    printf("\n");
}

void delQueue(LinearQueue* lq) {
    Node* delNode;
    while(lq->front != NULL) {
        delNode = lq->front;
        lq->front =lq->front->next;
        free(delNode);
    }
    lq->front = lq->rear = NULL;
}
