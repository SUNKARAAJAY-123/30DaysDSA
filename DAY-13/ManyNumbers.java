import java.util.Arrays;
class Solution {
    public int[] smallerNumbersThanCurrent(int[] nums) {
        int[] count = new int[101]; // since nums[i] is in [0,100]
        
        // Count frequency of each number
        for (int num : nums) {
            count[num]++;
        }
        
        // Build prefix sum: count[i] will hold how many numbers <= i
        for (int i = 1; i < 101; i++) {
            count[i] += count[i - 1];
        }
        
        // Build result
        int[] result = new int[nums.length];
        for (int i = 0; i < nums.length; i++) {
            result[i] = nums[i] == 0 ? 0 : count[nums[i] - 1];
        }
        
        return result;
    }

    // main method to test
    public static void main(String[] args) {
        Solution sol = new Solution();

        int[] nums = {8, 1, 2, 2, 3};
        int[] result = sol.smallerNumbersThanCurrent(nums);

        System.out.println(Arrays.toString(result)); 
        // Expected output: [4, 0, 1, 1, 3]
    }
}
