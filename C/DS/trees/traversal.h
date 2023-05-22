#include "util.h"
#include "newTree.h"


void inorder(struct Tree* root) {

    if(root == NULL) {
        return ;
    }

    inorder(root->left);
    printf("%d ", root->data);
    inorder(root->right);

}

void preorder(struct Tree* root) {
    
    if(root == NULL) {
        return ;
    }

    printf("%d ", root->data);
    preorder(root->left);
    preorder(root->right);
}

void postorder(struct Tree* root) {

    if(root == NULL) {
        return ;
    }

    postorder(root->left);
    postorder(root->right);
    printf("%d ", root->data);
    
}
