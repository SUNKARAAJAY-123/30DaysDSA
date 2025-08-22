class RomantoInteger{
    public int lengthOfLastWord(String s) {
        // Remove trailing spaces
        s = s.trim();
        
        int length = 0;
        
        // Start from the end and count until a space is found
        for (int i = s.length() - 1; i >= 0; i--) {
            if (s.charAt(i) == ' ') {
                break;
            }
            length++;
        }
        
        return length;
    }

    public static void main(String[] args) {
        RomantoInteger sol = new RomantoInteger();
        
        System.out.println(sol.lengthOfLastWord("Hello World"));     // 5
        System.out.println(sol.lengthOfLastWord("   fly me   to   the moon  ")); // 4
        System.out.println(sol.lengthOfLastWord("luffy is still joyboy")); // 6
    }
}
