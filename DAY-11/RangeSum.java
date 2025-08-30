class NumArray {
    private int[] prefix;  // stores prefix sums

    public NumArray(int[] nums) {
        prefix = new int[nums.length + 1];
        for (int i = 0; i < nums.length; i++) {
            prefix[i + 1] = prefix[i] + nums[i];
        }
    }
    
    public int sumRange(int left, int right) {
        return prefix[right + 1] - prefix[left];
    }

    // Main method to test
    public static void main(String[] args) {
        int[] nums = {-2, 0, 3, -5, 2, -1};
        NumArray obj = new NumArray(nums);

        System.out.println(obj.sumRange(0, 2)); // Output: 1  -> (-2 + 0 + 3)
        System.out.println(obj.sumRange(2, 5)); // Output: -1 -> (3 + -5 + 2 + -1)
        System.out.println(obj.sumRange(0, 5)); // Output: -3 -> (-2 + 0 + 3 - 5 + 2 -1)
    }
}
