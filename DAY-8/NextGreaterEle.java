import java.util.*;

class NextGreaterEle{
    public int[] nextGreaterElement(int[] nums1, int[] nums2) {
        Map<Integer, Integer> map = new HashMap<>(); // stores next greater for each number
        Stack<Integer> stack = new Stack<>();

        for (int num : nums2) {
            // Maintain decreasing stack
            while (!stack.isEmpty() && stack.peek() < num) {
                map.put(stack.pop(), num);
            }
            stack.push(num);
        }

        // Build result for nums1
        int[] result = new int[nums1.length];
        for (int i = 0; i < nums1.length; i++) {
            result[i] = map.getOrDefault(nums1[i], -1);
        }

        return result;
    }

    // Helper to print array
    public void printArray(int[] arr) {
        System.out.print("[");
        for (int i = 0; i < arr.length; i++) {
            System.out.print(arr[i]);
            if (i < arr.length - 1) System.out.print(", ");
        }
        System.out.println("]");
    }

    public static void main(String[] args) {
        NextGreaterEle sol = new NextGreaterEle();

        int[] nums1 = {4, 1, 2};
        int[] nums2 = {1, 3, 4, 2};

        int[] result = sol.nextGreaterElement(nums1, nums2);

        System.out.print("Next Greater Elements: ");
        sol.printArray(result);  // Expected: [-1, 3, -1]
    }
}
