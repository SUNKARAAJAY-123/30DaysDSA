import java.util.Collections;
import java.util.PriorityQueue;

class MedianFinder {
    private PriorityQueue<Integer> low;  // max-heap
    private PriorityQueue<Integer> high; // min-heap

    public MedianFinder() {
        low = new PriorityQueue<>(Collections.reverseOrder());
        high = new PriorityQueue<>();
    }
    
    public void addNum(int num) {
        // Step 1: Add to max heap
        low.offer(num);

        // Step 2: Balance -> move largest from low to high
        high.offer(low.poll());

        // Step 3: Maintain size property
        if (low.size() < high.size()) {
            low.offer(high.poll());
        }
    }
    
    public double findMedian() {
        if (low.size() > high.size()) {
            return low.peek();
        } else {
            return (low.peek() + high.peek()) / 2.0;
        }
    }

    // Testing
    public static void main(String[] args) {
        MedianFinder mf = new MedianFinder();
        mf.addNum(1);
        mf.addNum(2);
        System.out.println(mf.findMedian()); // 1.5
        mf.addNum(3);
        System.out.println(mf.findMedian()); // 2
    }
}
