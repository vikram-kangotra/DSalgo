
import java.util.*;
public class Problems {
    // Height of Binary Tree

    public int height(TreeNode root) {
        if (root == null) {
            return 0;
        }
        return 1 + Math.max(height(root.getLeft()), height(root.getRight()));
    }

    // Diameter of Binary Tree

    public int diameter(TreeNode root) {
        if (root == null) {
            return 0;
        }
        int leftHeight = height(root.getLeft());
        int rightHeight = height(root.getRight());
        int leftDiameter = diameter(root.getLeft());
        int rightDiameter = diameter(root.getRight());
        return Math.max(leftHeight + rightHeight + 1, Math.max(leftDiameter, rightDiameter));
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

    
}
