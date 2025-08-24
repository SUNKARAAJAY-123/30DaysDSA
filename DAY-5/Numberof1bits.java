class Numberof1bits {
    public int hammingWeight(int n) {
        int count = 0;
        while (n != 0) {
            count += (n & 1);  // check last bit
            n >>>= 1;          // unsigned right shift
        }
        return count;
    }

    // main method for testing
    public static void main(String[] args) {
        Numberof1bits sol = new Numberof1bits();
        int n = 11; // binary 1011
        System.out.println(sol.hammingWeight(n)); // 3
    }
}
