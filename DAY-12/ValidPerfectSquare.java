class Solution {
    public boolean isPerfectSquare(int num) {
        if (num < 2) return true; // 1 is a perfect square

        long left = 2, right = num / 2; // use long to prevent overflow
        while (left <= right) {
            long mid = left + (right - left) / 2;
            long sq = mid * mid;

            if (sq == num) {
                return true;
            } else if (sq < num) {
                left = mid + 1;
            } else {
                right = mid - 1;
            }
        }
        
        return false;
    }

    // Main method for testing
    public static void main(String[] args) {
        Solution sol = new Solution();

        int[] testCases = {1, 4, 9, 16, 14, 25, 26, 2147395600};
        for (int num : testCases) {
            System.out.println(num + " is perfect square? " + sol.isPerfectSquare(num));
        }
    }
}
