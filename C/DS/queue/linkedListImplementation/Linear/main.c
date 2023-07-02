#include "linear_queue.h"
#include <limits.h>
#include <stdio.h>

int main() {
    LinearQueue lq;
    createLinearQueue(&lq);

    int data;
    int choice;
    while(1) {
        printf("1. Enqueue. \n2. Dequeue. \n3. Front. \n4. Display. \n5. Delete Queue.  \n6. Exit. \nEnter your choice: ");
        scanf("%d", &choice);
        switch (choice) {
            case 1:
                printf("data = ");
                scanf("%d", &data);
                enqueue(&lq, data);
                break;

            case 2:
                data = dequeue(&lq);
                if(data != INT_MIN) 
                    printf("Dequeued element = %d\n", data);
                break;

            case 3:
                data = peek(&lq);
                if(data != INT_MIN) 
                    printf("Front element = %d\n", data);
                break;

            case 4:
                display(&lq);
                break;

            case 5:
                delQueue(&lq);
                break;
                
            case 6:
                return 0;

            default:
                printf("Invalid Entry\n");    
        }
        getchar();
    }

}
