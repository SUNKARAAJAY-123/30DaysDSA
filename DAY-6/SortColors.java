class SortColors {
    public void sortColors(int[] nums) {
        int low = 0;        // pointer for 0s
        int mid = 0;        // pointer for 1s
        int high = nums.length - 1; // pointer for 2s

        while (mid <= high) {
            if (nums[mid] == 0) {
                // swap nums[low] and nums[mid]
                int temp = nums[low];
                nums[low] = nums[mid];
                nums[mid] = temp;
                low++;
                mid++;
            } else if (nums[mid] == 1) {
                mid++;
            } else { // nums[mid] == 2
                // swap nums[mid] and nums[high]
                int temp = nums[mid];
                nums[mid] = nums[high];
                nums[high] = temp;
                high--;
            }
        }
    }

    // main method for testing
    public static void main(String[] args) {
       SortColors  sol = new SortColors();

        int[] nums = {2, 0, 2, 1, 1, 0};
        sol.sortColors(nums);

        System.out.print("Sorted colors: ");
        for (int num : nums) {
            System.out.print(num + " ");
        }
    }
}
