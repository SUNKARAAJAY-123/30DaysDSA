import java.util.Arrays;

class Solution {
    public int arrayPairSum(int[] nums) {
        Arrays.sort(nums); // sort array
        int sum = 0;
        for (int i = 0; i < nums.length; i += 2) {
            sum += nums[i]; // pick every alternate element (min in the pair)
        }
        return sum;
    }

    // main method to test
    public static void main(String[] args) {
        Solution sol = new Solution();
        int[] nums = {1, 4, 3, 2};
        System.out.println(sol.arrayPairSum(nums)); // Output: 4 (pairs: (1,2), (3,4))
    }
}
