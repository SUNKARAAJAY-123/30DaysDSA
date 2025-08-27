class ListNode {
    int val;
    ListNode next;
    ListNode(int x) { val = x; }
}

class ReverseLL {
    public ListNode reverseList(ListNode head) {
        ListNode prev = null;
        ListNode curr = head;

        while (curr != null) {
            ListNode nextNode = curr.next; // store next
            curr.next = prev;              // reverse link
            prev = curr;                   // move prev forward
            curr = nextNode;               // move curr forward
        }

        return prev; // new head
    }

    // Helper to create linked list from array
    public ListNode createList(int[] arr) {
        ListNode dummy = new ListNode(0);
        ListNode current = dummy;
        for (int num : arr) {
            current.next = new ListNode(num);
            current = current.next;
        }
        return dummy.next;
    }

    // Helper to print a linked list
    public void printList(ListNode node) {
        while (node != null) {
            System.out.print(node.val);
            if (node.next != null) System.out.print(" -> ");
            node = node.next;
        }
        System.out.println();
    }

    public static void main(String[] args) {
        ReverseLL sol = new ReverseLL();

        // Example: 1 -> 2 -> 3 -> 4 -> 5
        ListNode head = sol.createList(new int[]{1, 2, 3, 4, 5});

        System.out.print("Original List: ");
        sol.printList(head);

        ListNode reversed = sol.reverseList(head);

        System.out.print("Reversed List: ");
        sol.printList(reversed);  // Output: 5 -> 4 -> 3 -> 2 -> 1
    }
}
