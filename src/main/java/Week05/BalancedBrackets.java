package Week05;
import edu.princeton.cs.algs4.*;

// https://www.hackerrank.com/challenges/balanced-brackets
public class BalancedBrackets {
    private static char getOpenBracket(char c) {
        if (c == ')') return '(';
        if (c == ']') return '[';
        return '{';
    }
    public static String isBalanced(String s) {
        // Write your code here
        Stack<Character> stack = new Stack<>();
        for(int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);
            if (c == '(' || c == '[' || c == '{')
                stack.push(c);
            else if (c == ')' || c == ']' || c == '}') {
                if (stack.isEmpty())
                    return "NO";
                char c2 = stack.pop();
                if (getOpenBracket(c) != c2)
                    return "NO";
            }
        }
        return stack.isEmpty() ? "YES": "NO";
    }
}
