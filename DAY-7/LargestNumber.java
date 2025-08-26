import java.util.*;

public class LargestNumber {
    public String largestNumber(int[] nums) {
        // Convert int array to String array
        String[] arr = new String[nums.length];
        for (int i = 0; i < nums.length; i++) {
            arr[i] = String.valueOf(nums[i]);
        }

        // Custom sort: compare a+b vs b+a
        Arrays.sort(arr, (a, b) -> (b + a).compareTo(a + b));

        // If largest number is "0", just return "0"
        if (arr[0].equals("0")) {
            return "0";
        }

        // Build the largest number
        StringBuilder sb = new StringBuilder();
        for (String s : arr) {
            sb.append(s);
        }

        return sb.toString();
    }

    // Main method for testing
    public static void main(String[] args) {
        LargestNumber sol = new LargestNumber();

        int[] nums1 = {3, 30, 34, 5, 9};
        System.out.println("Input: [3,30,34,5,9]");
        System.out.println("Largest Number: " + sol.largestNumber(nums1));

        int[] nums2 = {10, 2};
        System.out.println("\nInput: [10,2]");
        System.out.println("Largest Number: " + sol.largestNumber(nums2));

        int[] nums3 = {0, 0};
        System.out.println("\nInput: [0,0]");
        System.out.println("Largest Number: " + sol.largestNumber(nums3));
    }
}
