#include "circular_doubly_linked_list.h"
#include <stdio.h>

void  circularDoubleLinkedList(){
    Node* tail = NULL;
    int data, choice, flag = 1;
    size_t index;

    while(flag) {

        printf("\n 1. Insert data in list.\n");
        printf("\n 2. Delete data from list.\n");
        printf("\n 3. Display  list.\n");
        printf("\n 4. Delete list.\n");
        printf("\n 5. Reverse the  list.\n");
        printf("\n 6. Quit.\n");

        printf("\nEnter your choice: ");
        scanf("%d", &choice);

        switch (choice) {
            case 1:
                printf("\nEnter the data to be inserted in List: ");
                scanf("%d", &data);
                printf("\nEnter the index at which data has to be inserted in List: ");
                scanf("%zu", &index);
                tail = insertNode(tail, data,  index);
                break;

            case 2:
                if(tail != NULL) { 
                printf("\nEnter the index from  where data has to be deleted from List: ");
                scanf("%zu", &index);
                tail = deleteNode(tail, index);
                } else {
                    printf("List is empty!\n");
                }
                break;

            case 3:
                displayList(tail);
                break;
            case 4:
                tail = deleteList(tail);
                break;

            case 5:
                tail = reverseList(tail);
                break;

            case 6:
                flag = 0;
                break;
             
            default:
                printf("Invalid Entry!\n");
        }
        getchar();

    }
}
