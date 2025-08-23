import java.util.*;

class SolutioIntersectionofTwoArrays {
    public int[] intersect(int[] nums1, int[] nums2) {
        Map<Integer, Integer> map = new HashMap<>();
        List<Integer> result = new ArrayList<>();
        
        // Count frequency of each number in nums1
        for (int num : nums1) {
            map.put(num, map.getOrDefault(num, 0) + 1);
        }
        
        // Check nums2 elements in the map
        for (int num : nums2) {
            if (map.containsKey(num) && map.get(num) > 0) {
                result.add(num);
                map.put(num, map.get(num) - 1); // decrease frequency
            }
        }
        
        // Convert list to array
        int[] resArr = new int[result.size()];
        for (int i = 0; i < result.size(); i++) {
            resArr[i] = result.get(i);
        }
        
        return resArr;
    }

    public static void main(String[] args) {
        IntersectionofTwoArrays sol = new SolutioIntersectionofTwoArrays();
        
        int[] nums1 = {1,2,2,1};
        int[] nums2 = {2,2};
        System.out.println(Arrays.toString(sol.intersect(nums1, nums2))); // [2, 2]

        int[] nums3 = {4,9,5};
        int[] nums4 = {9,4,9,8,4};
        System.out.println(Arrays.toString(sol.intersect(nums3, nums4))); // [4, 9] or [9, 4]
    }
}
