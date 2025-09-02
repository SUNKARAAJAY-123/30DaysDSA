class ArrangeCoins {
    public int arrangeCoins(int n) {
        return (int)((Math.sqrt(1 + 8L * n) - 1) / 2);
    }

    public static void main(String[] args) {
        ArrangeCoins solver = new ArrangeCoins();
        int n = 8;
        System.out.println("Input: n = " + n);
        System.out.println("Output: " + solver.arrangeCoins(n)); // Expected 3
    }
}
