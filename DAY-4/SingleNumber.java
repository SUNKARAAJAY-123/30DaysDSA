class SingleNumber {
    public int singleNumber(int[] nums) {
        int result = 0;
        
        for (int num : nums) {
            result ^= num; // XOR cancels out pairs
        }
        
        return result;
    }

    public static void main(String[] args) {
        SingleNumber sol = new SingleNumber();
        
        int[] nums1 = {2,2,1};
        System.out.println(sol.singleNumber(nums1)); // 1

        int[] nums2 = {4,1,2,1,2};
        System.out.println(sol.singleNumber(nums2)); // 4

        int[] nums3 = {1};
        System.out.println(sol.singleNumber(nums3)); // 1
    }
}
