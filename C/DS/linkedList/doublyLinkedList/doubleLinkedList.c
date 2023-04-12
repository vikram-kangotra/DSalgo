#include "doublelinkedlist.h"
#include <stdio.h>

void  doubleLinkedList()
{
    Node* head = NULL;
    int data, choice, flag = 1;
    size_t index;

    while(flag) {

        printf("\n 1. Insert data in list.\n");
        printf("\n 2. Delete data from list.\n");
        printf("\n 3. Reverse list.\n");
        printf("\n 4. Delete list.\n");
        printf("\n 5. Display  list.\n");
        printf("\n 6. Display reversed list.\n");
        printf("\n 7. Quit.\n");

        printf("\nEnter your choice: ");
        scanf("%d", &choice);

        switch (choice) {
            case 1:
                printf("\nEnter the data to be inserted in List: ");
                scanf("%d", &data);
                printf("\nEnter the index at which data has to be inserted in List: ");
                scanf("%zu", &index);
                head = insertNode(head, data,  index);
                break;

            case 2:
               
                printf("\nEnter the index from  where data has to be deleted from List: ");
                scanf("%zu", &index);
                head = deleteNode(head, index);
                break;

            case 3:
                head = reverseList(head);
                break;
                
            case 4:
                head = deleteList(head);
                break;
            case 5:
                displayList(head);
                break;

            case 6:
                displayReversedList(head);
                break;

            case 7:
                flag = 0;
                break;
        }

    }
}
