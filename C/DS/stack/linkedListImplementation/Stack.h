#include "node.h"
#include <stdlib.h>
#include <stdio.h>
void stack();

int isEmpty(Node* top);

void push(Node** top, int data);

int pop(Node** top);

int peek(Node* top);

void print(Node* top);

void deleteStack(Node** top);
