#pragma once
#include "../util.h"
#include "../traversal.h"
TreeNode* createTreeNode (int data);

TreeNode* insert (TreeNode* root, int data);

TreeNode* deleteNode (TreeNode* root, int data);

TreeNode* insertRecusive(TreeNode* root, int target);

int no_of_child(TreeNode* root);

void swap(int*, int*);
