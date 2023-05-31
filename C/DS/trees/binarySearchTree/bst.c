#include "bst.h"
#include <stdlib.h>

TreeNode* createTreeNode(int data) {
    TreeNode* root = malloc(sizeof(TreeNode));
    root->data = data;
    root->left = root->right = NULL;
    return root;
}

//recurrsive insertion
TreeNode* insertRecusive(TreeNode* root, int data){
    if (root == NULL)
        return createTreeNode(data);

    if(data == root->data) {
        printf("Dublicate entry is not allowed!\n\n");
    } else if (data < root->data){
        root->left = insertRecusive(root->left, data);
    } else{
        root->right = insertRecusive(root->right, data);
    }

    return root;
}

//iterative insertion
TreeNode* insert(TreeNode* root, int data){
    TreeNode* newNode = createTreeNode(data);
    TreeNode* dummyRoot = root;
    TreeNode* trailingPtr = NULL;
    if(root == NULL){
        root = newNode;
    } else {
        while(dummyRoot != NULL) {
            trailingPtr = dummyRoot;
            if(dummyRoot->data == data) {
                printf("Dublicate entry is not allowed!\n\n");
                return root;
            }else if(data < dummyRoot->data) {
                dummyRoot = dummyRoot->left;
            } else {
                dummyRoot = dummyRoot->right;
            }
        }
        if( data < trailingPtr->data){
            trailingPtr->left = newNode;
        } else {
            trailingPtr->right = newNode;
        }
    } 

    return root;
}

TreeNode* deleteNode(TreeNode* root, int target) {
    if(root == NULL) {
        printf("Tree is empty!\n");
        return NULL;
    }

    TreeNode* ptr1 = NULL;
    TreeNode* ptr2 = root;
    while( (ptr2->left != NULL || ptr2->right != NULL) && ptr2->data != target){
        ptr1 = ptr2;
        if(target < ptr2->data)
            ptr2 = ptr2->left;
        else
            ptr2 = ptr2->right;
    }

    if(ptr2->data != target) {
            printf("Not present in given tree.\n");
            return root;
    }

    TreeNode* preSucc = ptr2;
    TreeNode* succ = ptr2->right;
    switch (no_of_child(ptr2)) {
        case 0:
            //whenever ptr1 is null we have to delete root node.
            if(ptr1 == NULL) {
                free(ptr2);
                return NULL;
            } else {
                if(target < ptr1->data)
                    ptr1->left = NULL;
                else
                    ptr1->right = NULL;
            }
            free(ptr2);
            break;

        case 1:
            if(ptr1 == NULL){
                if(ptr2->left != NULL)
                    root = ptr2->left;
                else 
                    root = ptr2->right;
                free(ptr2);
            } else {
                if(ptr2->left != NULL) {
                    if(target < ptr1->data)
                        ptr1->left = ptr2->left;
                    else 
                        ptr1->right = ptr2->left;
                } else {
                    if(target < ptr1->data)
                        ptr1->left = ptr2->right;
                    else 
                        ptr1->right = ptr2->right;
                }
                free(ptr2);
            }
            break;

        case 2:
            while(succ->left != NULL) {
                preSucc = succ;
                succ = succ->left;
            }
            swap(&ptr2->data, &succ->data);
            if( preSucc->left == succ)
                preSucc->left = NULL;
            else 
                preSucc->right = NULL;
            free(succ);
            break;
    }
    return root;
}

int no_of_child(TreeNode *root) {
    if(root == NULL) return -1;
    if(root->left == NULL && root->right == NULL) return 0;
    if(root->left != NULL && root->right != NULL) return 2;
    return 1;
}

void swap(int* a, int* b) {
    int t = *a;
    *a = *b;
    *b = t;
}
