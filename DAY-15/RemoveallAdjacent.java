class RemoveallAdjacent {
    public String removeDuplicates(String s, int k) {
        // stack to store char and its frequency
        Stack<Pair> stack = new Stack<>();

        for (char c : s.toCharArray()) {
            if (!stack.isEmpty() && stack.peek().ch == c) {
                stack.peek().count++;
                if (stack.peek().count == k) {
                    stack.pop(); // remove group of k
                }
            } else {
                stack.push(new Pair(c, 1));
            }
        }

        // rebuild string
        StringBuilder sb = new StringBuilder();
        for (Pair p : stack) {
            for (int i = 0; i < p.count; i++) {
                sb.append(p.ch);
            }
        }
        return sb.toString();
    }

    // helper class
    private static class Pair {
        char ch;
        int count;
        Pair(char ch, int count) {
            this.ch = ch;
            this.count = count;
        }
    }

    // Main method for testing
    public static void main(String[] args) {
        RemoveallAdjacent sol = new RemoveallAdjacent();
        
        System.out.println(sol.removeDuplicates("abcd", 2));       // "abcd"
        System.out.println(sol.removeDuplicates("deeedbbcccbdaa", 3)); // "aa"
        System.out.println(sol.removeDuplicates("pbbcggttciiippooaais", 2)); // "ps"
    }
}
