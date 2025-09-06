import java.util.PriorityQueue;

class KClosestPointToOri{
    public int[][] kClosest(int[][] points, int k) {
        // Max heap based on distance
        PriorityQueue<int[]> maxHeap = new PriorityQueue<>(
            (a, b) -> (b[0]*b[0] + b[1]*b[1]) - (a[0]*a[0] + a[1]*a[1])
        );

        for (int[] p : points) {
            maxHeap.offer(p);
            if (maxHeap.size() > k) {
                maxHeap.poll(); // remove farthest
            }
        }

        // Build result
        int[][] res = new int[k][2];
        for (int i = 0; i < k; i++) {
            res[i] = maxHeap.poll();
        }
        return res;
    }

    // For testing
    public static void main(String[] args) {
        KClosestPointToOri sol = new KClosestPointToOri();
        int[][] points = {{1,3},{-2,2},{5,8},{0,1}};
        int k = 2;

        int[][] result = sol.kClosest(points, k);
        for (int[] p : result) {
            System.out.println("[" + p[0] + "," + p[1] + "]");
        }
    }
}
