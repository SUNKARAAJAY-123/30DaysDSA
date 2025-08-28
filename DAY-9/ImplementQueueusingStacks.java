import java.util.Stack;

class MyQueue {
    private Stack<Integer> inStack;
    private Stack<Integer> outStack;

    public MyQueue() {
        inStack = new Stack<>();
        outStack = new Stack<>();
    }
    
    public void push(int x) {
        inStack.push(x);
    }
    
    public int pop() {
        peek(); // ensure outStack has the front
        return outStack.pop();
    }
    
    public int peek() {
        if (outStack.isEmpty()) {
            while (!inStack.isEmpty()) {
                outStack.push(inStack.pop());
            }
        }
        return outStack.peek();
    }
    
    public boolean empty() {
        return inStack.isEmpty() && outStack.isEmpty();
    }

    // 🔹 Main method for testing
    public static void main(String[] args) {
        MyQueue obj = new MyQueue();
        obj.push(1);
        obj.push(2);
        obj.push(3);
        
        System.out.println("Peek: " + obj.peek());   // should print 1
        System.out.println("Pop: " + obj.pop());     // should print 1
        System.out.println("Peek: " + obj.peek());   // should print 2
        System.out.println("Empty: " + obj.empty()); // should print false
        obj.pop(); // remove 2
        obj.pop(); // remove 3
        System.out.println("Empty: " + obj.empty()); // should print true
    }
}
