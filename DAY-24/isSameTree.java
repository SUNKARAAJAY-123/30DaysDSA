// Definition for a binary tree node.
class TreeNode {
    int val;
    TreeNode left;
    TreeNode right;
    TreeNode(int val) {
        this.val = val;
        this.left = null;
        this.right = null;
    }
}

class Solution {
    public boolean isSameTree(TreeNode p, TreeNode q) {
        // If both are null, they are same
        if (p == null && q == null) return true;

        // If one is null and other is not, not same
        if (p == null || q == null) return false;

        // Check current node value and both subtrees
        return (p.val == q.val) &&
               isSameTree(p.left, q.left) &&
               isSameTree(p.right, q.right);
    }

    public static void main(String[] args) {
        // First tree
        TreeNode p = new TreeNode(1);
        p.left = new TreeNode(2);
        p.right = new TreeNode(3);

        // Second tree
        TreeNode q = new TreeNode(1);
        q.left = new TreeNode(2);
        q.right = new TreeNode(3);

        Solution sol = new Solution();
        boolean result = sol.isSameTree(p, q);
        System.out.println("Are the two trees the same? " + result);
    }
}
