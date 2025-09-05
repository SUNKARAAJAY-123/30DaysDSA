// Definition for singly-linked list.
class ListNode {
    int val;
    ListNode next;
    ListNode() {}
    ListNode(int val) { this.val = val; }
    ListNode(int val, ListNode next) { this.val = val; this.next = next; }
}

class Solution {
    public ListNode rotateRight(ListNode head, int k) {
        if (head == null || head.next == null || k == 0) return head;

        // 1. Find the length of the list
        ListNode curr = head;
        int length = 1;
        while (curr.next != null) {
            curr = curr.next;
            length++;
        }

        // 2. Connect last node to head (make it circular)
        curr.next = head;

        // 3. Find new head after rotation
        k = k % length;  // In case k > length
        int stepsToNewHead = length - k;

        ListNode newTail = curr;
        while (stepsToNewHead-- > 0) {
            newTail = newTail.next;
        }

        // 4. Break the circle
        ListNode newHead = newTail.next;
        newTail.next = null;

        return newHead;
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
        // Create test list: 1 -> 2 -> 3 -> 4 -> 5
        ListNode head = new ListNode(1,
                        new ListNode(2,
                        new ListNode(3,
                        new ListNode(4,
                        new ListNode(5)))));

        System.out.println("Original List:");
        printList(head);

        Solution sol = new Solution();
        ListNode rotated = sol.rotateRight(head, 2); // Rotate by 2

        System.out.println("After Rotating by 2:");
        printList(rotated);
    }
}
