class SplitArray {
    public int splitArray(int[] nums, int k) {
        int left = 0, right = 0;
        for (int num : nums) {
            left = Math.max(left, num);
            right += num;
        }

        while (left < right) {
            int mid = left + (right - left) / 2;
            if (canSplit(nums, k, mid)) {
                right = mid;
            } else {
                left = mid + 1;
            }
        }
        return left;
    }

    private boolean canSplit(int[] nums, int k, int maxSum) {
        int current = 0, parts = 1;
        for (int num : nums) {
            if (current + num > maxSum) {
                parts++;
                current = 0;
            }
            current += num;
        }
        return parts <= k;
    }

    public static void main(String[] args) {
        SplitArray solver = new SplitArray();
        int[] nums = {7,2,5,10,8};
        int k = 2;
        System.out.println("Input: nums = [7,2,5,10,8], k = " + k);
        System.out.println("Output: " + solver.splitArray(nums, k)); // Expected 18
    }
}
