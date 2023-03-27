#include "linkedList.h"
#include <stdio.h>

void displayReversedList(struct Node* head) {

    if (head == NULL) {
        return;
    }

    displayReversedList(head->next);
    printf("%d ", head->data);
}
