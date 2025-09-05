// Definition for a Node.
class Node {
    int val;
    Node next;
    Node random;

    public Node(int val) {
        this.val = val;
        this.next = null;
        this.random = null;
    }
}

class Solution {
    public Node copyRandomList(Node head) {
        if (head == null) return null;

        // 1. Create new nodes and insert them after original nodes
        Node curr = head;
        while (curr != null) {
            Node copy = new Node(curr.val);
            copy.next = curr.next;
            curr.next = copy;
            curr = copy.next;
        }

        // 2. Assign random pointers for copied nodes
        curr = head;
        while (curr != null) {
            if (curr.random != null) {
                curr.next.random = curr.random.next;
            }
            curr = curr.next.next;
        }

        // 3. Separate the original and copied lists
        curr = head;
        Node newHead = head.next;
        while (curr != null) {
            Node copy = curr.next;
            curr.next = copy.next;
            if (copy.next != null) {
                copy.next = copy.next.next;
            }
            curr = curr.next;
        }

        return newHead;
    }

    // Helper to print list with random pointers
    public static void printList(Node head) {
        Node curr = head;
        while (curr != null) {
            int randomVal = (curr.random != null) ? curr.random.val : -1;
            System.out.print("[" + curr.val + ", random->" + randomVal + "] ");
            curr = curr.next;
        }
        System.out.println();
    }

    // Main method to test
    public static void main(String[] args) {
        // Create nodes
        Node n1 = new Node(1);
        Node n2 = new Node(2);
        Node n3 = new Node(3);

        // Connect next pointers
        n1.next = n2;
        n2.next = n3;

        // Connect random pointers
        n1.random = n3; // 1 -> random -> 3
        n2.random = n1; // 2 -> random -> 1
        n3.random = n2; // 3 -> random -> 2

        System.out.println("Original List:");
        printList(n1);

        Solution sol = new Solution();
        Node copiedHead = sol.copyRandomList(n1);

        System.out.println("Copied List:");
        printList(copiedHead);
    }
}
