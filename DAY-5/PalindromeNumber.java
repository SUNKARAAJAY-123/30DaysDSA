class PalindromeNumber {
    public boolean isPalindrome(int x) {
        if (x < 0) return false;
        
        int original = x;
        int reversed = 0;
        
        while (x != 0) {
            int digit = x % 10;
            // check for overflow (not needed in LeetCode because x is within int range)
            if (reversed > Integer.MAX_VALUE / 10 || reversed < Integer.MIN_VALUE / 10) {
                return false;
            }
            reversed = reversed * 10 + digit;
            x /= 10;
        }
        
        return original == reversed;
    }

    public static void main(String[] args) {
        PalindromeNumber sol = new PalindromeNumber();

        // Test cases
        System.out.println(sol.isPalindrome(121));    // true
        System.out.println(sol.isPalindrome(-121));   // false
        System.out.println(sol.isPalindrome(10));     // false
        System.out.println(sol.isPalindrome(12321));  // true
        System.out.println(sol.isPalindrome(0));      // true
    }
}
