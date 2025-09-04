import java.util.*;

class QueueReconstruction {
    public int[][] reconstructQueue(int[][] people) {
        // Step 1: Sort by height (desc), if same height then by k (asc)
        Arrays.sort(people, (a, b) -> {
            if (a[0] == b[0]) {
                return a[1] - b[1];
            }
            return b[0] - a[0];
        });

        // Step 2: Insert into list at index = k
        List<int[]> result = new ArrayList<>();
        for (int[] p : people) {
            result.add(p[1], p);
        }

        // Step 3: Convert list back to array
        return result.toArray(new int[people.length][]);
    }

    // Main method for testing
    public static void main(String[] args) {
        QueueReconstruction sol = new QueueReconstruction();

        int[][] people1 = {{7,0},{4,4},{7,1},{5,0},{6,1},{5,2}};
        int[][] res1 = sol.reconstructQueue(people1);
        System.out.println(Arrays.deepToString(res1)); 
        // [[5,0],[7,0],[5,2],[6,1],[4,4],[7,1]]

        int[][] people2 = {{6,0},{5,0},{4,0},{3,2},{2,2},{1,4}};
        int[][] res2 = sol.reconstructQueue(people2);
        System.out.println(Arrays.deepToString(res2)); 
        // [[4,0],[5,0],[2,2],[3,2],[1,4],[6,0]]
    }
}
