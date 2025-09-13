class TreeNode {
    int val;
    TreeNode left, right;
    TreeNode(int val) {
        this.val = val;
        this.left = this.right = null;
    }
}

class Solution {
    public int rangeSumBST(TreeNode root, int low, int high) {
        if (root == null) return 0;

        int sum = 0;
        if (root.val >= low && root.val <= high) sum += root.val;

        if (root.val > low) sum += rangeSumBST(root.left, low, high);
        if (root.val < high) sum += rangeSumBST(root.right, low, high);

        return sum;
    }

    public static void main(String[] args) {
        /*
                10
               /  \
              5   15
             / \    \
            3   7    18

         low = 7, high = 15
         nodes in range = 7 + 10 + 15 = 32
        */

        TreeNode root = new TreeNode(10);
        root.left = new TreeNode(5);
        root.right = new TreeNode(15);
        root.left.left = new TreeNode(3);
        root.left.right = new TreeNode(7);
        root.right.right = new TreeNode(18);

        Solution sol = new Solution();
        System.out.println("Range sum: " + sol.rangeSumBST(root, 7, 15));
    }
}
