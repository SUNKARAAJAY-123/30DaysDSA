import java.util.HashSet;

class HappyNumber {
    public boolean isHappy(int n) {
        HashSet<Integer> seen = new HashSet<>();
        
        while (n != 1 && !seen.contains(n)) {
            seen.add(n);
            n = getNext(n);
        }
        
        return n == 1;
    }
    
    private int getNext(int n) {
        int sum = 0;
        while (n > 0) {
            int digit = n % 10;
            sum += digit * digit;
            n /= 10;
        }
        return sum;
    }

    // main method for testing
    public static void main(String[] args) {
        HappyNumber sol = new HappyNumber();
        int n = 19;
        System.out.println(sol.isHappy(n)); // true
    }
}
