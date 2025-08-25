import java.util.*;

class Sum3 {
    public List<List<Integer>> threeSum(int[] nums) {
        List<List<Integer>> result = new ArrayList<>();
        Arrays.sort(nums); // Sort array first

        for (int i = 0; i < nums.length - 2; i++) {
            // Avoid duplicate triplets for the first element
            if (i > 0 && nums[i] == nums[i - 1]) continue;

            int left = i + 1;
            int right = nums.length - 1;

            while (left < right) {
                int sum = nums[i] + nums[left] + nums[right];

                if (sum == 0) {
                    result.add(Arrays.asList(nums[i], nums[left], nums[right]));

                    // Skip duplicates for second number
                    while (left < right && nums[left] == nums[left + 1]) left++;
                    // Skip duplicates for third number
                    while (left < right && nums[right] == nums[right - 1]) right--;

                    left++;
                    right--;
                } else if (sum < 0) {
                    left++; // need a larger sum
                } else {
                    right--; // need a smaller sum
                }
            }
        }
        return result;
    }

    // Testing
    public static void main(String[] args) {
        Sum3 sol = new Sum3();
        int[] nums = {-1, 0, 1, 2, -1, -4};

        List<List<Integer>> ans = sol.threeSum(nums);
        System.out.println(ans);
    }
}
