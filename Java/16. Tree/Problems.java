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

    // 
}
