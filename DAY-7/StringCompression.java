public class StringCompression {
    public int compress(char[] chars) {
        int n = chars.length;
        int write = 0;  // position to write compressed chars
        int read = 0;   // position to read
        
        while (read < n) {
            char currentChar = chars[read];
            int count = 0;
            
            // Count consecutive characters
            while (read < n && chars[read] == currentChar) {
                read++;
                count++;
            }
            
            // Write the character
            chars[write++] = currentChar;
            
            // If count > 1, write its digits
            if (count > 1) {
                for (char c : String.valueOf(count).toCharArray()) {
                    chars[write++] = c;
                }
            }
        }
        
        return write;
    }

    // Main method for testing
    public static void main(String[] args) {
        StringCompression sol = new StringCompression();

        char[] chars1 = {'a','a','b','b','c','c','c'};
        int len1 = sol.compress(chars1);
        System.out.print("Compressed: ");
        for (int i = 0; i < len1; i++) {
            System.out.print(chars1[i]);
        }
        System.out.println(" | Length: " + len1);

        char[] chars2 = {'a'};
        int len2 = sol.compress(chars2);
        System.out.print("Compressed: ");
        for (int i = 0; i < len2; i++) {
            System.out.print(chars2[i]);
        }
        System.out.println(" | Length: " + len2);

        char[] chars3 = {'a','b','b','b','b','b','b','b','b','b','b','b','b'};
        int len3 = sol.compress(chars3);
        System.out.print("Compressed: ");
        for (int i = 0; i < len3; i++) {
            System.out.print(chars3[i]);
        }
        System.out.println(" | Length: " + len3);
    }
}
