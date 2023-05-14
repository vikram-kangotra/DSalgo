#include "linkedList.h"
#include "node.h"

struct Node* sort(struct Node* head) {

    if(head == NULL || head->next == NULL)
        return head;

    struct Node* temp1 = head;
    struct Node* temp2;
    struct Node* min;
    while(temp1->next != NULL) {
        min = temp1;
        temp2 = temp1->next;
        while(temp2 != NULL) {
            if(min->data > temp2->data)
                min = temp2;
            temp2 = temp2->next;
        }
        
        if(temp1 != min) {
            int tp = temp1->data;
            temp1->data = min->data;
            min->data = tp;
        }

        temp1 = temp1->next;
    }

    return head;
}





            
