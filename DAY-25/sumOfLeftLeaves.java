// Definition for a binary tree node.
class TreeNode {
    int val;
    TreeNode left, right;

    TreeNode(int val) {
        this.val = val;
        this.left = this.right = null;
    }
}

class Solution {
    public int sumOfLeftLeaves(TreeNode root) {
        if (root == null) return 0;
        return helper(root, false);
    }

    private int helper(TreeNode node, boolean isLeft) {
        if (node == null) return 0;

        // If it's a left leaf
        if (isLeft && node.left == null && node.right == null) {
            return node.val;
        }

        // Recurse on both sides
        return helper(node.left, true) + helper(node.right, false);
    }

    public static void main(String[] args) {
        /*
              3
             / \
            9  20
               / \
              15  7
         Left leaves = 9 + 15 = 24
        */

        TreeNode root = new TreeNode(3);
        root.left = new TreeNode(9);
        root.right = new TreeNode(20);
        root.right.left = new TreeNode(15);
        root.right.right = new TreeNode(7);

        Solution sol = new Solution();
        System.out.println("Sum of left leaves: " + sol.sumOfLeftLeaves(root));
    }
}
