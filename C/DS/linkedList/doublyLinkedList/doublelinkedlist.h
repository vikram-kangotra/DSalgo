#include <stdlib.h>
#include "node.h"

void doubleLinkedList();

Node* insertNode (Node* head, int data, size_t index);

Node* deleteNode (Node* head, size_t index);

Node* reverseList (Node* head);

Node* deleteList (Node* head);

void displayList (Node* head);

void displayReversedList (Node* head);
