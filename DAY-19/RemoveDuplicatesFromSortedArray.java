public class RemoveDuplicatesFromSortedArray {
    public static int removeDuplicates(int[] nums) {
        int n = nums.length;
        if (n == 0) return 0;

        int j = 0;
        for (int i = 1; i < n; i++) {
            if (nums[i] != nums[j]) {
                j++;
                nums[j] = nums[i];
            }
        }
        return j + 1;
    }

    public static void main(String[] args) {
        int[] nums = {1, 1, 2};
        int newLength = removeDuplicates(nums);

        System.out.println("Length after removing duplicates: " + newLength);
        System.out.print("Updated array: ");
        for (int i = 0; i < newLength; i++) {
            System.out.print(nums[i] + " ");
        }
    }
}
