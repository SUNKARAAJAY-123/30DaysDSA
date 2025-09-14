import java.util.*;

class Solution {
    public boolean canVisitAllRooms(List<List<Integer>> rooms) {
        int n = rooms.size();
        boolean[] visited = new boolean[n];
        dfs(0, rooms, visited);
        for (boolean v : visited) if (!v) return false;
        return true;
    }

    private void dfs(int room, List<List<Integer>> rooms, boolean[] visited) {
        visited[room] = true;
        for (int key : rooms.get(room))
            if (!visited[key]) dfs(key, rooms, visited);
    }

    public static void main(String[] args) {
        Solution sol = new Solution();
        List<List<Integer>> rooms = new ArrayList<>();
        rooms.add(Arrays.asList(1));
        rooms.add(Arrays.asList(2));
        rooms.add(Arrays.asList(3));
        rooms.add(new ArrayList<>());
        System.out.println(sol.canVisitAllRooms(rooms)); // true
    }
}
