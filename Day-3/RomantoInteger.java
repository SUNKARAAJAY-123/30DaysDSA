import java.util.*;

class RomantoInteger{
    public int romanToInt(String s) {
        // Map of Roman numerals and their integer values
        Map<Character, Integer> map = new HashMap<>();
        map.put('I', 1);
        map.put('V', 5);
        map.put('X', 10);
        map.put('L', 50);
        map.put('C', 100);
        map.put('D', 500);
        map.put('M', 1000);
        
        int result = 0;
        
        for (int i = 0; i < s.length(); i++) {
            int value = map.get(s.charAt(i));
            
            // If next numeral is larger, subtract current value
            if (i + 1 < s.length() && value < map.get(s.charAt(i + 1))) {
                result -= value;
            } else {
                result += value;
            }
        }
        
        return result;
    }

    public static void main(String[] args) {
        RomantoInteger sol = new RomantoInteger();
        
        System.out.println(sol.romanToInt("III"));     // 3
        System.out.println(sol.romanToInt("LVIII"));   // 58
        System.out.println(sol.romanToInt("MCMXCIV")); // 1994
    }
}
