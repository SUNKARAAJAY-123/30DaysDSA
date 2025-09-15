class Solution {
    public boolean validTree(int n, int[][] edges) {
        if (edges.length != n - 1) return false; // tree must have n-1 edges

        int[] parent = new int[n];
        for (int i = 0; i < n; i++) parent[i] = i;

        for (int[] edge : edges) {
            int u = find(parent, edge[0]);
            int v = find(parent, edge[1]);
            if (u == v) return false; // cycle found
            parent[u] = v;            // union
        }

        return true; // connected and acyclic
    }

    private int find(int[] parent, int x) {
        if (parent[x] != x) parent[x] = find(parent, parent[x]); // path compression
        return parent[x];
    }

    // Main method for quick testing
    public static void main(String[] args) {
        Solution sol = new Solution();
        int[][] edges1 = {{0,1},{0,2},{0,3},{1,4}};
        System.out.println(sol.validTree(5, edges1)); // true

        int[][] edges2 = {{0,1},{1,2},{2,3},{1,3},{1,4}};
        System.out.println(sol.validTree(5, edges2)); // false
    }
}
