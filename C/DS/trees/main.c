#include "traversal.h"

TreeNode* insertData(int data) {

    TreeNode * root = malloc(sizeof(TreeNode));
    root->data = data;
    root->left = NULL;
    root->right = NULL;
    return root;

}

int main() {

    TreeNode* root = malloc(sizeof(TreeNode));

    root = insertData(0);
    root->left = insertData(2);
    root->right = insertData(5);
    root->left->left = insertData(51);
    root->left->right = insertData(49);
    root->right->right = insertData(12);

    //traversal

    printf("\nINORDER TRAVERSAL \n");
    inorder(root);     //LNR

    printf("\nPREORDER TRAVERSAL \n");
    preorder(root);    //NLR
    
    printf("\nPOSTORDER TRAVERSAL \n");
    postorder(root);   //LRN

}
