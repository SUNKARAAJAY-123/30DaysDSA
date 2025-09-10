import java.util.*;

// Definition for a binary tree node.
class TreeNode {
    int val;
    TreeNode left;
    TreeNode right;
    TreeNode(int val) { this.val = val; }
    TreeNode(int val, TreeNode left, TreeNode right) {
        this.val = val;
        this.left = left;
        this.right = right;
    }
}

class Solution {
    // Recursive preorder traversal
    public List<Integer> preorderTraversalRecursive(TreeNode root) {
        List<Integer> result = new ArrayList<>();
        preorder(root, result);
        return result;
    }

    private void preorder(TreeNode node, List<Integer> result) {
        if (node == null) return;
        result.add(node.val);        // Node
        preorder(node.left, result); // Left
        preorder(node.right, result); // Right
    }

    // Iterative preorder traversal using stack
    public List<Integer> preorderTraversalIterative(TreeNode root) {
        List<Integer> result = new ArrayList<>();
        if (root == null) return result;

        Stack<TreeNode> stack = new Stack<>();
        stack.push(root);

        while (!stack.isEmpty()) {
            TreeNode node = stack.pop();
            result.add(node.val);

            // Push right first so left is processed first
            if (node.right != null) stack.push(node.right);
            if (node.left != null) stack.push(node.left);
        }
        return result;
    }
}

public class Main {
    public static void main(String[] args) {
        // Create a sample tree:
        //        1
        //         \
        //          2
        //         /
        //        3
        TreeNode root = new TreeNode(1);
        root.right = new TreeNode(2);
        root.right.left = new TreeNode(3);

        Solution sol = new Solution();

        // Recursive preorder
        System.out.println("Recursive preorder: " + sol.preorderTraversalRecursive(root));

        // Iterative preorder
        System.out.println("Iterative preorder: " + sol.preorderTraversalIterative(root));
    }
}
