import java.util.*;

class RecentCounter {
    private Queue<Integer> queue;

    public RecentCounter() {
        queue = new LinkedList<>();
    }
    
    public int ping(int t) {
        queue.offer(t);
        while (queue.peek() < t - 3000) {
            queue.poll();
        }
        return queue.size();
    }

    // 🔹 Main method for testing
    public static void main(String[] args) {
        RecentCounter obj = new RecentCounter();
        System.out.println(obj.ping(1));    // should print 1
        System.out.println(obj.ping(100));  // should print 2
        System.out.println(obj.ping(3001)); // should print 3
        System.out.println(obj.ping(3002)); // should print 3
    }
}
