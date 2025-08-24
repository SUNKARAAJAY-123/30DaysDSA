import java.util.HashSet;

class ContainsDuplicate {
    public boolean containsDuplicate(int[] nums) {
        HashSet<Integer> set = new HashSet<>();
        
        for (int num : nums) {
            if (set.contains(num)) {
                return true; // Duplicate found
            }
            set.add(num);
        }
        
        return false; // No duplicates
    }

    public static void main(String[] args) {
        ContainsDuplicate sol = new ContainsDuplicate();
        
        int[] nums1 = {1, 2, 3, 1};
        System.out.println(sol.containsDuplicate(nums1)); // true
        
        int[] nums2 = {1, 2, 3, 4};
        System.out.println(sol.containsDuplicate(nums2)); // false
    }
}
