import java.util.*;

class Solution {
    public boolean isBipartite(int[][] graph) {
        int n = graph.length;
        int[] color = new int[n];
        Arrays.fill(color, -1); // -1 means uncolored

        for (int i = 0; i < n; i++) {
            if (color[i] == -1) {
                if (!bfsCheck(graph, i, color)) {
                    return false;
                }
            }
        }
        return true;
    }

    private boolean bfsCheck(int[][] graph, int start, int[] color) {
        Queue<Integer> queue = new LinkedList<>();
        queue.offer(start);
        color[start] = 0;

        while (!queue.isEmpty()) {
            int node = queue.poll();
            for (int neighbor : graph[node]) {
                if (color[neighbor] == -1) {
                    color[neighbor] = 1 - color[node]; // alternate color
                    queue.offer(neighbor);
                } else if (color[neighbor] == color[node]) {
                    return false; // same color on both sides
                }
            }
        }
        return true;
    }

    // For testing
    public static void main(String[] args) {
        Solution sol = new Solution();

        int[][] graph1 = {
            {1, 3},
            {0, 2},
            {1, 3},
            {0, 2}
        }; // Bipartite
        System.out.println(sol.isBipartite(graph1)); // true

        int[][] graph2 = {
            {1, 2, 3},
            {0, 2},
            {0, 1, 3},
            {0, 2}
        }; // Not Bipartite
        System.out.println(sol.isBipartite(graph2)); // false
    }
}
