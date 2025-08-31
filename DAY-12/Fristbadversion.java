// Mock VersionControl class (since LeetCode provides it internally)
class VersionControl {
    // Let's assume version 4 is the first bad version (you can change it)
    private int firstBad = 4;

    boolean isBadVersion(int version) {
        return version >= firstBad;
    }
}

class Solution extends VersionControl {
    public int firstBadVersion(int n) {
        int left = 1, right = n;
        
        while (left < right) {
            int mid = left + (right - left) / 2;
            
            if (isBadVersion(mid)) {
                right = mid; // first bad is mid or before
            } else {
                left = mid + 1; // first bad is after mid
            }
        }
        
        return left;
    }

    // Main method to test
    public static void main(String[] args) {
        Solution sol = new Solution();
        
        int n = 10; // total versions
        int result = sol.firstBadVersion(n);
        
        System.out.println("First bad version is: " + result);
    }
}
