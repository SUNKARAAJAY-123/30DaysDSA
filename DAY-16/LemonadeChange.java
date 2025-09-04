class LemonadeChange{
    public boolean lemonadeChange(int[] bills) {
        int five = 0, ten = 0;

        for (int bill : bills) {
            if (bill == 5) {
                five++;
            } else if (bill == 10) {
                if (five == 0) return false;
                five--;
                ten++;
            } else { // bill == 20
                if (ten > 0 && five > 0) {
                    ten--;
                    five--;
                } else if (five >= 3) {
                    five -= 3;
                } else {
                    return false;
                }
            }
        }

        return true;
    }

    // Main method for testing
    public static void main(String[] args) {
        LemonadeChange sol = new LemonadeChange();

        int[] bills1 = {5, 5, 5, 10, 20};
        System.out.println(sol.lemonadeChange(bills1)); // true

        int[] bills2 = {5, 5, 10, 10, 20};
        System.out.println(sol.lemonadeChange(bills2)); // false

        int[] bills3 = {5, 5, 5, 5, 10, 5, 10, 10, 10, 20};
        System.out.println(sol.lemonadeChange(bills3)); // false
    }
}
