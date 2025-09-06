import java.util.PriorityQueue;

class KthLargest {
    private PriorityQueue<Integer> minHeap;
    private int k;

    public KthLargest(int k, int[] nums) {
        this.k = k;
        minHeap = new PriorityQueue<>();
        
        // Add initial numbers
        for (int num : nums) {
            add(num);
        }
    }
    
    public int add(int val) {
        minHeap.offer(val);
        
        // Keep only k largest elements
        if (minHeap.size() > k) {
            minHeap.poll();
        }
        
        return minHeap.peek(); // k-th largest
    }

    // Main method for testing
    public static void main(String[] args) {
        int[] nums = {4, 5, 8, 2};
        KthLargest obj = new KthLargest(3, nums);

        System.out.println(obj.add(3));   // Output: 4
        System.out.println(obj.add(5));   // Output: 5
        System.out.println(obj.add(10));  // Output: 5
        System.out.println(obj.add(9));   // Output: 8
        System.out.println(obj.add(4));   // Output: 8
    }
}
