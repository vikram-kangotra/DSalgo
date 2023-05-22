
import java.util.*;
public class Problems {
    // Height of Binary Tree

    public int height(TreeNode root) {
        if (root == null) {
            return 0;
        }
        return 1 + Math.max(height(root.getLeft()), height(root.getRight()));
    }

    // Diameter of Binary Tree : The diameter of a tree (sometimes called the width) is the number of nodes on the longest path between two end nodes.

    public int diameter(TreeNode root) {
        if (root == null) {
            return 0;
        }
        int d1 = 1 + height(root.getLeft()) + height(root.getRight());
        int d2 = diameter(root.getLeft());
        int d3 = diameter(root.getRight());
        return Math.max(d1, Math.max(d2, d3));
    }

    // Print nodes at distance k from root

    public void printNodesAtDistanceK(TreeNode root, int k) {
        if (root == null) {
            return;
        }
        if (k == 0) {
            System.out.print(root.getData() + " ");
        } else {
            printNodesAtDistanceK(root.getLeft(), k - 1);
            printNodesAtDistanceK(root.getRight(), k - 1);
        }
    }

    // Size of Binary Tree : Number of nodes

    public int size(TreeNode root) {
        if (root == null) {
            return 0;
        }
        return 1 + size(root.getLeft()) + size(root.getRight());
    }

    // Maximum element in Binary Tree

    public int maximum(TreeNode root) {
        if (root == null) {
            return Integer.MIN_VALUE;
        }
        return Math.max(root.getData(), Math.max(maximum(root.getLeft()), maximum(root.getRight())));
    }

    // Print left view of Binary Tree

    public void printLeftIteratively(TreeNode root){
        if (root == null) {
            return;
        }
        Queue<TreeNode> queue = new LinkedList<>();
        queue.add(root);
        while (!queue.isEmpty()) {
            int n = queue.size();
            for (int i = 1; i <= n; i++) {
                TreeNode current = queue.remove();
                if (i == 1) {
                    System.out.print(current.getData() + " ");
                }
                if (current.getLeft() != null) {
                    queue.add(current.getLeft());
                }
                if (current.getRight() != null) {
                    queue.add(current.getRight());
                }
            }
        }
    }

    // Print right view of Binary Tree

    public void printRightIteratively(TreeNode root){
        if (root == null) {
            return;
        }
        Queue<TreeNode> queue = new LinkedList<>();
        queue.add(root);
        while (!queue.isEmpty()) {
            int n = queue.size();
            for (int i = 1; i <= n; i++) {
                TreeNode current = queue.remove();
                if (i == n) {
                    System.out.print(current.getData() + " ");
                }
                if (current.getLeft() != null) {
                    queue.add(current.getLeft());
                }
                if (current.getRight() != null) {
                    queue.add(current.getRight());
                }
            }
        }
    }

    // Children Sum Property

    public boolean childrenSumProperty(TreeNode root) {
        if (root == null) {
            return true;
        }
        if (root.getLeft() == null && root.getRight() == null) {
            return true;
        }
        int sum = 0;
        if (root.getLeft() != null) {
            sum += root.getLeft().getData();
        }
        if (root.getRight() != null) {
            sum += root.getRight().getData();
        }
        return (root.getData() == sum && childrenSumProperty(root.getLeft()) && childrenSumProperty(root.getRight()));
    }
    
    // Check for Balanced Tree : A tree is balanced if the difference between the heights of left subtree and right subtree is not more than 1 for all nodes of the tree.

    public boolean isBalanced1(TreeNode root) {
        if (root == null) {
            return true;
        }
        int leftHeight = height(root.getLeft());
        int rightHeight = height(root.getRight());
        return (Math.abs(leftHeight - rightHeight) <= 1 && isBalanced1(root.getLeft()) && isBalanced1(root.getRight()));
    } /*This will take O(n^2) time */

    public int isBalanced2(TreeNode root) {
        if (root == null) {
            return 0;
        }
        int leftHeight = isBalanced2(root.getLeft());
        if (leftHeight == -1) {
            return -1;
        }
        int rightHeight = isBalanced2(root.getRight());
        if (rightHeight == -1) {
            return -1;
        }
        if (Math.abs(leftHeight - rightHeight) > 1) {
            return -1;
        }
        return 1 + Math.max(leftHeight, rightHeight);
    } /*This will take O(n) time */

    // Check for Symmetric Tree

    public boolean isSymmetric(TreeNode root) {
        if (root == null) {
            return true;
        }
        return isSymmetric(root.getLeft(), root.getRight());
    }

    public boolean isSymmetric(TreeNode root1, TreeNode root2) {
        if (root1 == null && root2 == null) {
            return true;
        }
        if ((root1 == null && root2 != null) || (root1 != null && root2 == null) || (root1.getData() != root2.getData())) {
            return false;
        }
        return isSymmetric(root1.getLeft(), root2.getRight()) && isSymmetric(root1.getRight(), root2.getLeft());
    }

    // Maximum width of Binary Tree

    public int maxWidth(TreeNode root) {
        if (root == null) {
            return 0;
        }
        Queue<TreeNode> queue = new LinkedList<>();
        queue.add(root);
        int max = 0;
        while (!queue.isEmpty()) {
            int n = queue.size();
            max = Math.max(max, n);
            for (int i = 1; i <= n; i++) {
                TreeNode current = queue.remove();
                if (current.getLeft() != null) {
                    queue.add(current.getLeft());
                }
                if (current.getRight() != null) {
                    queue.add(current.getRight());
                }
            }
        }
        return max;
    }

    // Convert a Binary Tree to Doubly Linked List


    // Convert Binary Tree from Inorder and Preorder Traversal

    int preIndex = 0;

    public TreeNode buildTree(int[] preorder, int[] inorder) {
        return buildTree(preorder, inorder, 0, inorder.length - 1);
    }

    public TreeNode buildTree(int[] preorder, int[] inorder, int start, int end) {
        if (start > end) {
            return null;
        }
        TreeNode root = new TreeNode(preorder[preIndex++]);
        if (start == end) {
            return root;
        }
        int index = search(inorder, start, end, root.getData());
        root.setLeft(buildTree(preorder, inorder, start, index - 1));
        root.setRight(buildTree(preorder, inorder, index + 1, end));
        return root;
    }

    public int search(int[] inorder, int start, int end, int data) {
        int i;
        for (i = start; i <= end; i++) {
            if (inorder[i] == data) {
                return i;
            }
        }
        return i;
    }

    // Convert Binary Tree from Inorder and Postorder Traversal

    int postIndex = 0;

    public TreeNode buildTree2(int[] inorder, int[] postorder) {
        return buildTree2(inorder, postorder, 0, inorder.length - 1);
    }

    public TreeNode buildTree2(int[] inorder, int[] postorder, int start, int end) {
        if (start > end) {
            return null;
        }
        TreeNode root = new TreeNode(postorder[postIndex--]);
        if (start == end) {
            return root;
        }
        int index = search(inorder, start, end, root.getData());
        root.setRight(buildTree2(inorder, postorder, index + 1, end));
        root.setLeft(buildTree2(inorder, postorder, start, index - 1));
        return root;
    }

    // Construct Binary Tree from Preorder and Postorder Traversal

    int preIndex2 = 0;

    public TreeNode constructFromPrePost(int[] pre, int[] post) {
        return constructFromPrePost(pre, post, 0, post.length - 1);
    }

    public TreeNode constructFromPrePost(int[] pre, int[] post, int start, int end) {
        if (start > end) {
            return null;
        }
        TreeNode root = new TreeNode(pre[preIndex2++]);
        if (start == end) {
            return root;
        }
        int index = search(post, start, end, pre[preIndex2]);
        root.setLeft(constructFromPrePost(pre, post, start, index));
        root.setRight(constructFromPrePost(pre, post, index + 1, end - 1));
        return root;
    }

    // Construct Binary Tree from Inorder and Level Order Traversal

    public TreeNode buildTree3(int[] inorder, int[] levelOrder) {
        return buildTree3(inorder, levelOrder, 0, inorder.length - 1);
    }

    public TreeNode buildTree3(int[] inorder, int[] levelOrder, int start, int end) {
        if (start > end) {
            return null;
        }
        TreeNode root = new TreeNode(levelOrder[0]);
        if (start == end) {
            return root;
        }
        int index = search(inorder, start, end, root.getData());
        int[] leftLevelOrder = new int[index - start];
        int[] rightLevelOrder = new int[end - index];
        int li = 0, ri = 0;
        for (int i = 1; i < levelOrder.length; i++) {
            if (search(inorder, start, index - 1, levelOrder[i]) != -1) {
                leftLevelOrder[li++] = levelOrder[i];
            } else {
                rightLevelOrder[ri++] = levelOrder[i];
            }
        }
        root.setLeft(buildTree3(inorder, leftLevelOrder, start, index - 1));
        root.setRight(buildTree3(inorder, rightLevelOrder, index + 1, end));
        return root;
    }

    // Lowest Common Ancestor in a Binary Tree: The lowest common ancestor between two nodes n1 and n2 is defined as the lowest node in T that has both n1 and n2 as descendants.

    public TreeNode lca(TreeNode root, int n1, int n2) {
        if (root == null) {
            return null;
        }
        if (root.getData() == n1 || root.getData() == n2) {
            return root;
        }
        TreeNode leftLca = lca(root.getLeft(), n1, n2);
        TreeNode rightLca = lca(root.getRight(), n1, n2);
        if (leftLca != null && rightLca != null) {
            return root;
        }
        return (leftLca != null) ? leftLca : rightLca;
    }

    


}
