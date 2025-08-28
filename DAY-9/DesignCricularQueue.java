class MyCircularQueue {
    private int[] queue;
    private int front;
    private int rear;
    private int size;
    private int capacity;

    public MyCircularQueue(int k) {
        capacity = k;
        queue = new int[k];
        front = 0;
        rear = -1;
        size = 0;
    }
    
    public boolean enQueue(int value) {
        if (isFull()) return false;
        rear = (rear + 1) % capacity;
        queue[rear] = value;
        size++;
        return true;
    }
    
    public boolean deQueue() {
        if (isEmpty()) return false;
        front = (front + 1) % capacity;
        size--;
        return true;
    }
    
    public int Front() {
        if (isEmpty()) return -1;
        return queue[front];
    }
    
    public int Rear() {
        if (isEmpty()) return -1;
        return queue[rear];
    }
    
    public boolean isEmpty() {
        return size == 0;
    }
    
    public boolean isFull() {
        return size == capacity;
    }

    // 🔹 Main method for testing
    public static void main(String[] args) {
        MyCircularQueue cq = new MyCircularQueue(3); // capacity 3
        System.out.println(cq.enQueue(1)); // true
        System.out.println(cq.enQueue(2)); // true
        System.out.println(cq.enQueue(3)); // true
        System.out.println(cq.enQueue(4)); // false (queue full)
        
        System.out.println("Rear: " + cq.Rear());   // 3
        System.out.println("Front: " + cq.Front()); // 1
        System.out.println("isFull: " + cq.isFull());// true
        
        System.out.println(cq.deQueue()); // true (removes 1)
        System.out.println(cq.enQueue(4)); // true (adds 4)
        
        System.out.println("Rear: " + cq.Rear());   // 4
        System.out.println("Front: " + cq.Front()); // 2
    }
}
