class Validpalindrome {
    public boolean validPalindrome(String s) {
        int left = 0, right = s.length() - 1;

        while (left < right) {
            if (s.charAt(left) != s.charAt(right)) {
                // Skip either left or right char and check
                return isPalindrome(s, left + 1, right) || isPalindrome(s, left, right - 1);
            }
            left++;
            right--;
        }
        return true;
    }

    private boolean isPalindrome(String s, int left, int right) {
        while (left < right) {
            if (s.charAt(left) != s.charAt(right)) return false;
            left++;
            right--;
        }
        return true;
    }

    // Main method for testing
    public static void main(String[] args) {
        Validpalindrome sol = new Validpalindrome();

        String s1 = "abca"; // remove 'b' or 'c'
        String s2 = "racecar"; // already palindrome
        String s3 = "abc"; // cannot be palindrome with ≤1 removal

        System.out.println(sol.validPalindrome(s1)); // true
        System.out.println(sol.validPalindrome(s2)); // true
        System.out.println(sol.validPalindrome(s3)); // false
    }
}
