import java.util.*;

public class TreeTraversals {

    /**
     * In-order traversal using recursion.
     * Time complexity: O(n), where n is the number of nodes in the tree.
     * Auxiliary space: O(h), where h is the height of the tree.
     */

    public void inorderRecursive(TreeNode root) {
        if (root != null) {
            inorderRecursive(root.getLeft());
            System.out.print(root.getData() + " ");
            inorderRecursive(root.getRight());
        }
    }

    /**
     * Pre-order traversal using recursion.
     * Time complexity: O(n), where n is the number of nodes in the tree.
     * Auxiliary space: O(h), where h is the height of the tree.
     */

    public void preorderRecursive(TreeNode root) {
        if (root != null) {
            System.out.print(root.getData() + " ");
            preorderRecursive(root.getLeft());
            preorderRecursive(root.getRight());
        }
    }

    /**
     * Post-order traversal using recursion.
     * Time complexity: O(n), where n is the number of nodes in the tree.
     * Auxiliary space: O(h), where h is the height of the tree.
     */

    public void postorderRecursive(TreeNode root) {
        if (root != null) {
            postorderRecursive(root.getLeft());
            postorderRecursive(root.getRight());
            System.out.print(root.getData() + " ");
        }
    }

    /**
     * In-order traversal using iteration and a stack.
     * Time complexity: O(n), where n is the number of nodes in the tree.
     * Auxiliary space: O(h), where h is the height of the tree.
     */

    public void inorderIterative(TreeNode root) {
        Stack<TreeNode> stack = new Stack<>();
        TreeNode current = root;
        while (current != null || !stack.isEmpty()) {
            while (current != null) {
                stack.push(current);
                current = current.getLeft();
            }
            current = stack.pop();
            System.out.print(current.getData() + " ");
            current = current.getRight();
        }
    }

    /**
     * Pre-order traversal using iteration and a stack.
     * Time complexity: O(n), where n is the number of nodes in the tree.
     * Auxiliary space: O(h), where h is the height of the tree.
     */

    public void preorderIterative(TreeNode root) {
        Stack<TreeNode> stack = new Stack<>();
        stack.push(root);
        while (!stack.isEmpty()) {
            TreeNode current = stack.pop();
            System.out.print(current.getData() + " ");
            if (current.getRight() != null) {
                stack.push(current.getRight());
            }
            if (current.getLeft() != null) {
                stack.push(current.getLeft());
            }
        }
    }

    /**
     * Post-order traversal using iteration and two stacks.
     * Time complexity: O(n), where n is the number of nodes in the tree.
     * Auxiliary space: O(n), where n is the number of nodes in the tree.
     */

    public void postorderIterative(TreeNode root) {
        Stack<TreeNode> stack1 = new Stack<>();
        Stack<TreeNode> stack2 = new Stack<>();
        stack1.push(root);
        while (!stack1.isEmpty()) {
            TreeNode current = stack1.pop();
            stack2.push(current);
            if (current.getLeft() != null) {
                stack1.push(current.getLeft());
            }
            if (current.getRight() != null) {
                stack1.push(current.getRight());
            }
        }
        while (!stack2.isEmpty()) {
            System.out.print(stack2.pop().getData() + " ");
        }
    }

    /**
     * Level-order traversal using a queue.
     * Time complexity: O(n), where n is the number of nodes in the tree.
     * Auxiliary space: O(w), where w is the maximum width of the tree.
     */

    public void levelOrderTraversal(TreeNode root) {
        if (root == null) {
            return;
        }
        Queue<TreeNode> queue = new LinkedList<>();
        queue.add(root);
        while (!queue.isEmpty()) {
            TreeNode current = queue.remove();
            System.out.print(current.getData() + " ");
            if (current.getLeft() != null) {
                queue.add(current.getLeft());
            }
            if (current.getRight() != null) {
                queue.add(current.getRight());
            }
        }
    }

    public void levelOrderTraversalLineByLine1(TreeNode root) {
        if (root == null) {
            return;
        }
        Queue<TreeNode> queue = new LinkedList<>();
        queue.add(root);
        queue.add(null);
        while (queue.size() > 1) {
            TreeNode current = queue.remove();
            if (current == null) {
                System.out.println();
                queue.add(null);
                continue;
            }
            System.out.print(current.getData() + " ");
            if (current.getLeft() != null) {
                queue.add(current.getLeft());
            }
            if (current.getRight() != null) {
                queue.add(current.getRight());
            }
        }
    }

    public void levelOrderTraversalLineByLine2(TreeNode root) {
        if (root == null) {
            return;
        }
        Queue<TreeNode> queue = new LinkedList<>();
        queue.add(root);
        while (!queue.isEmpty()) {
            int n = queue.size();
            for (int i = 1; i <= n; i++) {
                TreeNode current = queue.remove();
                System.out.print(current.getData() + " ");
                if (current.getLeft() != null) {
                    queue.add(current.getLeft());
                }
                if (current.getRight() != null) {
                    queue.add(current.getRight());
                }
            }
            System.out.println();
        }
    }

    public void spiralLevelOrderTraversal1(TreeNode root) {
        if (root == null) {
            return;
        }
        Stack<TreeNode> stack1 = new Stack<>();
        Stack<TreeNode> stack2 = new Stack<>();
        stack1.push(root);
        while (!stack1.isEmpty() || !stack2.isEmpty()) {
            while (!stack1.isEmpty()) {
                TreeNode current = stack1.pop();
                System.out.print(current.getData() + " ");
                if (current.getRight() != null) {
                    stack2.push(current.getRight());
                }
                if (current.getLeft() != null) {
                    stack2.push(current.getLeft());
                }
            }
            while (!stack2.isEmpty()) {
                TreeNode current = stack2.pop();
                System.out.print(current.getData() + " ");
                if (current.getLeft() != null) {
                    stack1.push(current.getLeft());
                }
                if (current.getRight() != null) {
                    stack1.push(current.getRight());
                }
            }
        }
    }

    public void spiralLevelOrderTraversal2(TreeNode root) {
        if (root == null) {
            return;
        }
        Queue<TreeNode> queue = new LinkedList<>();
        boolean reverse = false;
        queue.add(root);
        while (!queue.isEmpty()) {
            int n = queue.size();
            Stack<TreeNode> stack = new Stack<>();
            for (int i = 1; i <= n; i++) {
                TreeNode current = queue.remove();
                if (reverse) {
                    stack.push(current);
                } else {
                    System.out.print(current.getData() + " ");
                }
                if (current.getLeft() != null) {
                    queue.add(current.getLeft());
                }
                if (current.getRight() != null) {
                    queue.add(current.getRight());
                }
            }
            if (reverse) {
                while (!stack.isEmpty()) {
                    System.out.print(stack.pop().getData() + " ");
                }
            }
            reverse = !reverse;
        }
    }

}

