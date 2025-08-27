class ListNode {
    int val;
    ListNode next;
    ListNode(int x) { val = x; }
}

class AddTwoNubers {
    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        ListNode dummy = new ListNode(0);
        ListNode current = dummy;
        int carry = 0;

        while (l1 != null || l2 != null || carry != 0) {
            int sum = carry;

            if (l1 != null) {
                sum += l1.val;
                l1 = l1.next;
            }
            if (l2 != null) {
                sum += l2.val;
                l2 = l2.next;
            }

            carry = sum / 10;
            current.next = new ListNode(sum % 10);
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

    public static void main(String[] args) {
        AddTwoNubers sol = new AddTwoNubers();

        // Example: (2 -> 4 -> 3) + (5 -> 6 -> 4)
        ListNode l1 = sol.createList(new int[]{2, 4, 3});
        ListNode l2 = sol.createList(new int[]{5, 6, 4});

        ListNode result = sol.addTwoNumbers(l1, l2);

        System.out.print("Result: ");
        sol.printList(result); // Output should be 7 -> 0 -> 8
    }
}
