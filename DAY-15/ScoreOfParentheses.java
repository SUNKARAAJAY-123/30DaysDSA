import java.util.*;

class ScoreOfParentheses {
    public int scoreOfParentheses(String s) {
        Stack<Integer> stack = new Stack<>();
        stack.push(0); // base score

        for (char c : s.toCharArray()) {
            if (c == '(') {
                stack.push(0);
            } else {
                int v = stack.pop();
                int w = stack.pop();
                stack.push(w + Math.max(2 * v, 1));
            }
        }
        return stack.pop();
    }

    public static void main(String[] args) {
        ScoreOfParentheses sol = new ScoreOfParentheses();
        System.out.println(sol.scoreOfParentheses("()"));       // 1
        System.out.println(sol.scoreOfParentheses("(())"));     // 2
        System.out.println(sol.scoreOfParentheses("()()"));     // 2
        System.out.println(sol.scoreOfParentheses("(()(()))")); // 6
    }
}
