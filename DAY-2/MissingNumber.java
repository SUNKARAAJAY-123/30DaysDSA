import java.util.Arrays;

class MissingNumber{
    public int missingNumber(int[] nums) {
        Arrays.sort(nums);
        int res = 0;
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] == res) {
                res++;
            } else if (nums[i] > res) {
                break;
            }
        }
        return res;
    }

    public static void main(String[] args) {
        MissingNumber sol = new MissingNumber();
        
        int[] nums1 = {3, 0, 1};
        System.out.println(sol.missingNumber(nums1)); // 2
        
        int[] nums2 = {0, 1};
        System.out.println(sol.missingNumber(nums2)); // 2
        
        int[] nums3 = {9,6,4,2,3,5,7,0,1};
        System.out.println(sol.missingNumber(nums3)); // 8
    }
}
