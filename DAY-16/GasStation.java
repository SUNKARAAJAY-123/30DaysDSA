class GasStation{
    public int canCompleteCircuit(int[] gas, int[] cost) {
        int total = 0, tank = 0, start = 0;

        for (int i = 0; i < gas.length; i++) {
            total += gas[i] - cost[i];
            tank += gas[i] - cost[i];
            
            // If tank goes negative, cannot start from current 'start'
            if (tank < 0) {
                start = i + 1;
                tank = 0;
            }
        }

        return total >= 0 ? start : -1;
    }

    // Main method for testing
    public static void main(String[] args) {
        GasStation sol = new GasStation();

        int[] gas1 = {1,2,3,4,5};
        int[] cost1 = {3,4,5,1,2};
        System.out.println(sol.canCompleteCircuit(gas1, cost1)); // 3

        int[] gas2 = {2,3,4};
        int[] cost2 = {3,4,3};
        System.out.println(sol.canCompleteCircuit(gas2, cost2)); // -1
    }
}
