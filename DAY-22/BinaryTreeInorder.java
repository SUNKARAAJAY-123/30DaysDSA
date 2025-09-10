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
    // Recursive inorder traversal
    public List<Integer> inorderTraversalRecursive(TreeNode root) {
        List<Integer> result = new ArrayList<>();
        inorder(root, result);
        return result;
    }

    private void inorder(TreeNode node, List<Integer> result) {
        if (node == null) return;
        inorder(node.left, result);     // Left
        result.add(node.val);           // Node
        inorder(node.right, result);    // Right
    }

    // Iterative inorder traversal using stack
    public List<Integer> inorderTraversalIterative(TreeNode root) {
        List<Integer> result = new ArrayList<>();
        Stack<TreeNode> stack = new Stack<>();
        TreeNode curr = root;

        while (curr != null || !stack.isEmpty()) {
            while (curr != null) {
                stack.push(curr);
                curr = curr.left;
            }
            curr = stack.pop();
            result.add(curr.val);
            curr = curr.right;
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

        // Recursive inorder
        System.out.println("Recursive inorder: " + sol.inorderTraversalRecursive(root));

        // Iterative inorder
        System.out.println("Iterative inorder: " + sol.inorderTraversalIterative(root));
    }
}
