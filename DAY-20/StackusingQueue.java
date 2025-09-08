import java.util.LinkedList;
import java.util.Queue;

class MyStack {
    private Queue<Integer> q;

    public MyStack() {
        q = new LinkedList<>();
    }
    
    // Push element onto stack
    public void push(int x) {
        q.offer(x);
        int size = q.size();
        // rotate queue so that new element is at front
        for (int i = 0; i < size - 1; i++) {
            q.offer(q.poll());
        }
    }
    
    // Removes and returns the top element
    public int pop() {
        return q.poll();
    }
    
    // Get top element
    public int top() {
        return q.peek();
    }
    
    // Returns whether stack is empty
    public boolean empty() {
        return q.isEmpty();
    }

    // Main method for testing
    public static void main(String[] args) {
        MyStack obj = new MyStack();
        
        obj.push(10);
        obj.push(20);
        obj.push(30);
        
        System.out.println("Top element: " + obj.top()); // 30
        System.out.println("Popped: " + obj.pop());      // 30
        System.out.println("Top element: " + obj.top()); // 20
        System.out.println("Is empty? " + obj.empty());  // false
        
        obj.pop();
        obj.pop();
        System.out.println("Is empty? " + obj.empty());  // true
    }
}
