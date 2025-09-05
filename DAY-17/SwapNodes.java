// Definition for singly-linked list.
class ListNode {
    int val;
    ListNode next;
    ListNode() {}
    ListNode(int val) { this.val = val; }
    ListNode(int val, ListNode next) { this.val = val; this.next = next; }
}

class Solution {
    public ListNode swapPairs(ListNode head) {
        // Create a dummy node before head to handle edge cases easily
        ListNode dummy = new ListNode(0);
        dummy.next = head;
        
        ListNode prev = dummy;
        
        while (head != null && head.next != null) {
            // Nodes to swap
            ListNode first = head;
            ListNode second = head.next;
            
            // Swapping
            prev.next = second;
            first.next = second.next;
            second.next = first;
            
            // Move pointers forward
            prev = first;
            head = first.next;
        }
        
        return dummy.next;
    }

    // Helper method to print the linked list
    public static void printList(ListNode head) {
        while (head != null) {
            System.out.print(head.val);
            if (head.next != null) System.out.print(" -> ");
            head = head.next;
        }
        System.out.println();
    }

    // Main method for testing
    public static void main(String[] args) {
        // Create test list: 1 -> 2 -> 3 -> 4
        ListNode head = new ListNode(1, new ListNode(2, new ListNode(3, new ListNode(4))));

        System.out.println("Original List:");
        printList(head);

        Solution sol = new Solution();
        ListNode swapped = sol.swapPairs(head);

        System.out.println("After Swapping Pairs:");
        printList(swapped);
    }
}
