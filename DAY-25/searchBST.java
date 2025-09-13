class TreeNode {
    int val;
    TreeNode left, right;
    TreeNode(int val) {
        this.val = val;
        this.left = this.right = null;
    }
}

class Solution {
    public TreeNode searchBST(TreeNode root, int val) {
        if (root == null || root.val == val) return root;

        if (val < root.val) return searchBST(root.left, val);
        else return searchBST(root.right, val);
    }

    public static void main(String[] args) {
        /*
                4
               / \
              2   7
             / \
            1   3

        search val = 2  → subtree [2,1,3]
        */

        TreeNode root = new TreeNode(4);
        root.left = new TreeNode(2);
        root.right = new TreeNode(7);
        root.left.left = new TreeNode(1);
        root.left.right = new TreeNode(3);

        Solution sol = new Solution();
        TreeNode result = sol.searchBST(root, 2);

        if (result != null)
            System.out.println("Found node with value: " + result.val);
        else
            System.out.println("Value not found");
    }
}
