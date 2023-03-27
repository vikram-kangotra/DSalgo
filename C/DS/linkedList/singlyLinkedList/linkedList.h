#include "node.h"
#include <stdlib.h>

struct Node* insert (struct Node* head, size_t index, int data);

struct Node* deleteNode (struct Node* head, size_t index);

void displayList (struct Node*);
