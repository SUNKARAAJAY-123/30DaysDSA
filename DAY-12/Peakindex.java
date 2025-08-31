class Solution {
    public int peakIndexInMountainArray(int[] arr) {
        int left = 0, right = arr.length - 1;

        while (left < right) {
            int mid = left + (right - left) / 2;

            if (arr[mid] < arr[mid + 1]) {
                // Peak is on the right
                left = mid + 1;
            } else {
                // Peak is at mid or to the left
                right = mid;
            }
        }

        return left; // or right, both will be same
    }

    // Main method for testing
    public static void main(String[] args) {
        Solution sol = new Solution();

        int[] arr1 = {0, 2, 5, 3, 1};
        int[] arr2 = {0, 10, 5, 2};
        int[] arr3 = {3, 4, 5, 1};

        System.out.println("Peak index in arr1: " + sol.peakIndexInMountainArray(arr1)); // Output: 2
        System.out.println("Peak index in arr2: " + sol.peakIndexInMountainArray(arr2)); // Output: 1
        System.out.println("Peak index in arr3: " + sol.peakIndexInMountainArray(arr3)); // Output: 2
    }
}
