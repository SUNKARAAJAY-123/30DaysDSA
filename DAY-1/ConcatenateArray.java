class ConcatenateArray {
    public int[] getConcatenation(int[] nums) {
        int n = nums.length;
        int[] ans = new int[2 * n];
        
        for (int i = 0; i < n; i++) {
            ans[i] = nums[i];      // First half
            ans[i + n] = nums[i];  // Second half
        }
        
        return ans;
    }

    // Main method to test getConcatenation
    public static void main(String[] args) {
        ConcatenateArray sol = new ConcatenateArray();
        int[] nums = {1, 2, 1};
        
        int[] result = sol.getConcatenation(nums);

        System.out.print("Output: ");
        for (int val : result) {
            System.out.print(val + " ");
        }
    }
}
