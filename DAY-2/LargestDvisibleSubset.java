import java.util.*;

class LargestDvisibleSubset {
    public List<Integer> largestDivisibleSubset(int[] nums) {
        Arrays.sort(nums); // Step 1: Sort
        
        int n = nums.length;
        int[] dp = new int[n];      // dp[i] = length of largest subset ending at i
        int[] parent = new int[n];  // parent[i] = previous index in subset
        Arrays.fill(dp, 1);
        Arrays.fill(parent, -1);
        
        int maxLen = 1, maxIndex = 0;
        
        // Step 2: DP transition
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < i; j++) {
                if (nums[i] % nums[j] == 0 && dp[j] + 1 > dp[i]) {
                    dp[i] = dp[j] + 1;
                    parent[i] = j;
                }
            }
            if (dp[i] > maxLen) {
                maxLen = dp[i];
                maxIndex = i;
            }
        }
        
        // Step 3: Reconstruct subset
        List<Integer> result = new ArrayList<>();
        int k = maxIndex;
        while (k != -1) {
            result.add(nums[k]);
            k = parent[k];
        }
        
        return result; // This will be in reverse order but that's fine
    }

    public static void main(String[] args) {
        LargestDvisibleSubset sol = new LargestDvisibleSubset();
        
        int[] nums1 = {1, 2, 3};
        System.out.println(sol.largestDivisibleSubset(nums1)); // [1,2] or [1,3]
        
        int[] nums2 = {1, 2, 4, 8};
        System.out.println(sol.largestDivisibleSubset(nums2)); // [1,2,4,8]
    }
}
