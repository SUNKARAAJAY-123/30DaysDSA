import java.util.*;

class Solution {
    public int findTargetSumWays(int[] nums, int target) {
        int total = 0;
        for (int n : nums) total += n;

        // If target is outside possible sum range or (target+total) is odd => no ways
        if (target > total || target < -total || (target + total) % 2 != 0) return 0;

        int sum = (target + total) / 2;  // convert to subset sum problem

        int[] dp = new int[sum + 1];
        dp[0] = 1;

        for (int num : nums) {
            for (int i = sum; i >= num; i--) {
                dp[i] += dp[i - num];
            }
        }

        return dp[sum];
    }

    public static void main(String[] args) {
        Solution sol = new Solution();
        int[] nums = {1, 1, 1, 1, 1};
        int target = 3;
        System.out.println(sol.findTargetSumWays(nums, target));  // Output: 5
    }
}

