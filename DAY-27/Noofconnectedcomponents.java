class Solution {
    public int countComponents(int n, int[][] edges) {
        int[] parent = new int[n];
        for (int i = 0; i < n; i++) parent[i] = i;

        int components = n;
        for (int[] edge : edges) {
            int u = find(parent, edge[0]);
            int v = find(parent, edge[1]);
            if (u != v) {
                parent[u] = v; // union
                components--;
            }
        }

        return components;
    }

    private int find(int[] parent, int x) {
        if (parent[x] != x) parent[x] = find(parent, parent[x]);
        return parent[x];
    }

    // Main method for quick testing
    public static void main(String[] args) {
        Solution sol = new Solution();
        int[][] edges1 = {{0,1},{1,2},{3,4}};
        System.out.println(sol.countComponents(5, edges1)); // 2

        int[][] edges2 = {{0,1},{1,2},{2,3},{3,4}};
        System.out.println(sol.countComponents(5, edges2)); // 1
    }
}
