#pragma once
#include <stdlib.h>
#include <stdio.h>

typedef struct Node Node;
struct Node{
    int data;
    struct Node* next;
};

typedef struct {
    Node* front;
    Node* rear;
} LinearQueue;

void createLinearQueue(LinearQueue* lq);

void enqueue(LinearQueue* lq, int data);

int dequeue(LinearQueue* lq);

int peek(LinearQueue* lq);

void display(LinearQueue* lq);

void delQueue(LinearQueue*);


