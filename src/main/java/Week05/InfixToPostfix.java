package Week05;

import edu.princeton.cs.algs4.StdIn;

// 1.3.10 from https://docs.google.com/document/d/1J5Vpa2CBYVeWGQ3Ol0hvdcEVCJ5b8St2RthMdcPs-kA/edit
public class InfixToPostfix {
    public static void main(String[] args) {
        System.out.println(InfixToPostfix(StdIn.readLine().split(" ")));
    }

    public static String InfixToPostfix(String[] parts) {
        Stack<String> operations = new Stack<>();
        String result = "";
        for (String c: parts) {
            if (c.equals("+") || c.equals("-") || c.equals("*") || c.equals("/")) {
                while (!operations.isEmpty()) {
                    String op = operations.peek();
                    if (getPriority(op) >= getPriority(c)) {
                        result += operations.pop() + " ";
                    } else break;
                }
                operations.push(c);
            } else if (c.equals("(")) {
                operations.push(c);
            } else if (c.equals(")")) {
                while (!operations.isEmpty()) {
                    String op = operations.pop();
                    if (!op.equals("(")) {
                        result += op + " ";
                    } else break;
                }

            } else {
                result += c + " ";
            }
        }
        while (!operations.isEmpty()) {
            result += operations.pop() + " ";
        }
        return result.trim();
    }

    private static int getPriority(String op) {
        if (op.equals("*") || op.equals("/")) return 1;
        return (op.equals("+") || op.equals("-")) ? 0 : -1;
    }
}
