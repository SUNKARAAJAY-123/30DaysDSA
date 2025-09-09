import java.util.*;

class Solution {
    public List<List<Integer>> permuteUnique(int[] nums) {
        List<List<Integer>> result = new ArrayList<>();
        Arrays.sort(nums); // sort first to handle duplicates
        boolean[] used = new boolean[nums.length];
        backtrack(nums, new ArrayList<>(), used, result);
        return result;
    }

    private void backtrack(int[] nums, List<Integer> path, boolean[] used, List<List<Integer>> result) {
        if (path.size() == nums.length) {
            result.add(new ArrayList<>(path));
            return;
        }

        for (int i = 0; i < nums.length; i++) {
            // skip used
            if (used[i]) continue;
            // skip duplicates
            if (i > 0 && nums[i] == nums[i - 1] && !used[i - 1]) continue;

            // choose
            used[i] = true;
            path.add(nums[i]);

            // explore
            backtrack(nums, path, used, result);

            // unchoose
            path.remove(path.size() - 1);
            used[i] = false;
        }
    }

    // For testing
    public static void main(String[] args) {
        Solution sol = new Solution();
        int[] nums = {1, 1, 2};
        List<List<Integer>> ans = sol.permuteUnique(nums);
        System.out.println(ans);
    }
}
