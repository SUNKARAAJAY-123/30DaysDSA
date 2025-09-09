import java.util.*;

class Solution {
    public List<List<Integer>> combinationSum2(int[] candidates, int target) {
        List<List<Integer>> result = new ArrayList<>();
        Arrays.sort(candidates); // sort to handle duplicates
        backtrack(candidates, target, 0, new ArrayList<>(), result);
        return result;
    }

    private void backtrack(int[] candidates, int target, int start, List<Integer> path, List<List<Integer>> result) {
        if (target == 0) {
            result.add(new ArrayList<>(path));
            return;
        }

        for (int i = start; i < candidates.length; i++) {
            // skip duplicates
            if (i > start && candidates[i] == candidates[i - 1]) continue;

            // stop if number is larger than remaining target
            if (candidates[i] > target) break;

            // choose
            path.add(candidates[i]);
            backtrack(candidates, target - candidates[i], i + 1, path, result); // i+1 → each number used at most once
            path.remove(path.size() - 1); // undo
        }
    }

    // For testing
    public static void main(String[] args) {
        Solution sol = new Solution();
        int[] candidates = {10, 1, 2, 7, 6, 1, 5};
        int target = 8;
        List<List<Integer>> ans = sol.combinationSum2(candidates, target);
        System.out.println(ans);
    }
}
