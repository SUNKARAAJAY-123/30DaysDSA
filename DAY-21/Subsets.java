import java.util.*;

class Solution {
    public List<List<Integer>> subsetsWithDup(int[] nums) {
        List<List<Integer>> result = new ArrayList<>();
        Arrays.sort(nums); // sort to handle duplicates
        backtrack(nums, 0, new ArrayList<>(), result);
        return result;
    }

    private void backtrack(int[] nums, int start, List<Integer> path, List<List<Integer>> result) {
        result.add(new ArrayList<>(path)); // every path is a subset

        for (int i = start; i < nums.length; i++) {
            // skip duplicates
            if (i > start && nums[i] == nums[i - 1]) continue;

            path.add(nums[i]); // choose
            backtrack(nums, i + 1, path, result);
            path.remove(path.size() - 1); // undo
        }
    }

    // For testing
    public static void main(String[] args) {
        Solution sol = new Solution();
        int[] nums = {1, 2, 2};
        List<List<Integer>> ans = sol.subsetsWithDup(nums);
        System.out.println(ans);
    }
}
