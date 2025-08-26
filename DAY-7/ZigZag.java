

public class ZigZag{
    public String convert(String s, int numRows) {
        if (numRows == 1 || s.length() <= numRows) return s;
        
        StringBuilder[] rows = new StringBuilder[numRows];
        for (int i = 0; i < numRows; i++) {
            rows[i] = new StringBuilder();
        }
        
        int currRow = 0;
        boolean goingDown = false;
        
        for (char c : s.toCharArray()) {
            rows[currRow].append(c);
            
            if (currRow == 0 || currRow == numRows - 1) {
                goingDown = !goingDown;
            }
            
            currRow += goingDown ? 1 : -1;
        }
        
        StringBuilder result = new StringBuilder();
        for (StringBuilder row : rows) {
            result.append(row);
        }
        
        return result.toString();
    }

    // Main method to test Zigzag Conversion
    public static void main(String[] args) {
        ZigZag sol = new ZigZag();

        String s1 = "PAYPALISHIRING";
        int rows1 = 3;
        System.out.println("Input: " + s1 + ", Rows: " + rows1);
        System.out.println("Output: " + sol.convert(s1, rows1)); // PAHNAPLSIIGYIR

        String s2 = "PAYPALISHIRING";
        int rows2 = 4;
        System.out.println("\nInput: " + s2 + ", Rows: " + rows2);
        System.out.println("Output: " + sol.convert(s2, rows2)); // PINALSIGYAHRPI

        String s3 = "A";
        int rows3 = 1;
        System.out.println("\nInput: " + s3 + ", Rows: " + rows3);
        System.out.println("Output: " + sol.convert(s3, rows3)); // A
    }
}
