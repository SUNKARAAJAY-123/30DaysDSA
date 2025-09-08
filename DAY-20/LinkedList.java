class MyLinkedList {

    // Node definition
    class Node {
        int val;
        Node next;
        Node(int val) {
            this.val = val;
        }
    }

    private Node head; // dummy head
    private int size;  // to track length

    public MyLinkedList() {
        head = new Node(0); // dummy node
        size = 0;
    }
    
    // Get value of node at index
    public int get(int index) {
        if (index < 0 || index >= size) return -1;
        Node curr = head;
        for (int i = 0; i <= index; i++) {
            curr = curr.next;
        }
        return curr.val;
    }
    
    // Add new node at head
    public void addAtHead(int val) {
        addAtIndex(0, val);
    }
    
    // Add new node at tail
    public void addAtTail(int val) {
        addAtIndex(size, val);
    }
    
    // Add node at index
    public void addAtIndex(int index, int val) {
        if (index > size) return; // invalid
        if (index < 0) index = 0;

        size++;
        Node pred = head;
        for (int i = 0; i < index; i++) {
            pred = pred.next;
        }
        Node newNode = new Node(val);
        newNode.next = pred.next;
        pred.next = newNode;
    }
    
    // Delete node at index
    public void deleteAtIndex(int index) {
        if (index < 0 || index >= size) return;

        size--;
        Node pred = head;
        for (int i = 0; i < index; i++) {
            pred = pred.next;
        }
        pred.next = pred.next.next;
    }

    // Print linked list (for debugging)
    public void printList() {
        Node curr = head.next;
        while (curr != null) {
            System.out.print(curr.val + " -> ");
            curr = curr.next;
        }
        System.out.println("null");
    }

    // Main method to test
    public static void main(String[] args) {
        MyLinkedList obj = new MyLinkedList();
        
        obj.addAtHead(10);
        obj.addAtTail(20);
        obj.addAtIndex(1, 15);  // list: 10 -> 15 -> 20
        obj.printList();
        
        System.out.println("Value at index 1: " + obj.get(1)); // 15
        
        obj.deleteAtIndex(1);  // list: 10 -> 20
        obj.printList();
        
        System.out.println("Value at index 1: " + obj.get(1)); // 20
    }
}
