class Addtwonums {
    public int sum(int num1, int num2) {
        return num1 + num2;
    }

    // Main method to test the sum function
    public static void main(String[] args) {
        Addtwonums sol = new Addtwonums();

        int a = 5, b = 7;
        int result = sol.sum(a, b);

        System.out.println("Sum of " + a + " and " + b + " is: " + result);
    }
}
