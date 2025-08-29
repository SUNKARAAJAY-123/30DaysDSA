import java.util.*;

class RepeatedDNA {
    public List<String> findRepeatedDnaSequences(String s) {
        Set<String> seen = new HashSet<>();
        Set<String> repeated = new HashSet<>();
        
        // Sliding window of length 10
        for (int i = 0; i + 10 <= s.length(); i++) {
            String sub = s.substring(i, i + 10);
            if (!seen.add(sub)) {
                repeated.add(sub);
            }
        }
        
        return new ArrayList<>(repeated);
    }

    // Main method for testing
    public static void main(String[] args) {
        RepeatedDNA sol = new RepeatedDNA();
        String s = "AAAAACCCCCAAAAACCCCCCAAAAAGGGTTT";
        List<String> result = sol.findRepeatedDnaSequences(s);
        
        System.out.println("Repeated DNA sequences: " + result);
    }
}
