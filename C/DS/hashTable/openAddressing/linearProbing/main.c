#include "linearprobing.h"
#include <stdbool.h>
#include <stdio.h>

int main() {
    int data;
    int choice;
    bool flag = true;
    createHashTable(7);
    initTable();
    while(flag == true) {
        printf("\n1. Insert Element. \n2. Delete Element. \n3. Search Element. \n4. Display Element. \n5. Reset Table.  \n6. Exit. \nEnter your choice:");
        scanf("%d", &choice);
        switch(choice) {
            case 1:
                printf("Enter Element to be inserted:");
                scanf("%d", &data);
                insertElement(data);
                break;

            case 2:
                printf("Enter Element to be inserted:");
                scanf("%d", &data);
                deleteElement(data);
                break;

            case 3:
                printf("Enter Element to be Searched:");
                scanf("%d", &data);
                searchElement(data);
                break;

            case 4:
                printf("Hash table:\n");
                displayElements();
                break;

            case 5:
                initTable();
                break;

            case 6:
                flag = false;
                deleteTable();
                break;



            default:
                printf("Invalid Input!\n");
        }
        getchar();
    }
}
