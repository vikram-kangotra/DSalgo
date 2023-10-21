#include "bst.h"
int main() {
    TreeNode* root = NULL;

    int choice;
    int flag = 1;
    int data;
    while(flag) {
        printf("1. Insert. \n2. Deleted. \n3. Traverse. \n4. Exit. \nEnter your choice: ");
        scanf("%d", &choice);
        switch (choice) {
            case 1:
                printf("\nEnter element to be inserted:");
                scanf("%d", &data);
                root = insert(root, data);
                break;

            case 2:
                printf("\nEnter element to be Deleted:");
                scanf("%d", &data);
                root = deleteNode(root, data);
                break;

            case 3:
                printf("\nInorder Traversal:\n");
                inorder(root);
                printf("\n");
                break;

            case 4:
                flag = 0;
                break;

            default:
                printf("Invalid entry!\n");
        }
    }
    return 0;
}
