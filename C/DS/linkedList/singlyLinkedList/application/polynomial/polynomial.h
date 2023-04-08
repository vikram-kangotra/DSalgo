#include "node.h"

struct Node* create(struct Node* head);

struct Node* insert(struct Node* head, float coefficient, int exponent);

void display_polynomial (struct Node* head);

struct Node* add (struct Node* head1, struct Node* head2);

struct Node* subtract (struct Node* head1, struct Node* head2);

struct Node* multiply (struct Node* head1, struct Node* head2);
