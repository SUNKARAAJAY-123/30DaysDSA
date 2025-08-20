class MoveZeros {
    public void moveZeroes(int[] nums) {
        int left = 0; // pointer for non-zero placement

        for (int right = 0; right < nums.length; right++) {
            if (nums[right] != 0) {
                // Swap non-zero at right with element at left
                int temp = nums[left];
                nums[left] = nums[right];
                nums[right] = temp;
                left++;
            }
        }
    }

    // Main method to test the solution
    public static void main(String[] args) {
        MoveZeros sol = new MoveZeros();
        int[] nums = {0, 1, 0, 3, 12};

        sol.moveZeroes(nums);

        // Print result
        System.out.print("Output: ");
        for (int val : nums) {
            System.out.print(val + " ");
        }
    }
}
