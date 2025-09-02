class ShipWithinDays {
    public int shipWithinDays(int[] weights, int days) {
        int left = 0, right = 0;
        for (int w : weights) {
            left = Math.max(left, w);
            right += w;
        }

        while (left < right) {
            int mid = left + (right - left) / 2;
            if (canShip(weights, days, mid)) {
                right = mid;
            } else {
                left = mid + 1;
            }
        }
        return left;
    }

    private boolean canShip(int[] weights, int days, int capacity) {
        int current = 0, requiredDays = 1;
        for (int w : weights) {
            if (current + w > capacity) {
                requiredDays++;
                current = 0;
            }
            current += w;
        }
        return requiredDays <= days;
    }

    public static void main(String[] args) {
        ShipWithinDays solver = new ShipWithinDays();
        int[] weights = {1,2,3,1,1};
        int days = 4;
        System.out.println("Input: weights = [1,2,3,1,1], days = " + days);
        System.out.println("Output: " + solver.shipWithinDays(weights, days)); // Expected 3
    }
}
