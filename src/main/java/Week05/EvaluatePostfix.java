package Week05;

import edu.princeton.cs.algs4.StdIn;

// 1.3.11 from https://docs.google.com/document/d/1J5Vpa2CBYVeWGQ3Ol0hvdcEVCJ5b8St2RthMdcPs-kA/edit
public class EvaluatePostfix {
    public static void main(String[] args) {
        String input = StdIn.readLine();
        String postfix = InfixToPostfix.InfixToPostfix(input.split(" "));
        System.out.println("Postfix form: " + postfix);
        System.out.println("Result of infix: " + EvaluateInfix(input));
        System.out.println("Result of postfix: " + Evaluate(postfix));
    }
    public static double Evaluate(String input) {
        String[] parts = input.split(" ");
        Stack<Double> operands = new Stack<>();
        for (String c: parts) {
            if (c.equals("+") || c.equals("-") || c.equals("*") || c.equals("/")) {
                Double n1 = operands.pop();
                Double n2 = operands.pop();
                if (c.equals("+")) operands.push(n1 + n2);
                if (c.equals("-")) operands.push(n2 - n1);
                if (c.equals("*")) operands.push(n2 * n1);
                if (c.equals("/")) operands.push(n2 / n1);
            } else {
                operands.push(Double.parseDouble(c));
            }
        }
        return operands.pop();
    }

    public static double EvaluateInfix(String input) {
        Stack<String> ops = new Stack<String>();
        Stack<Double> vals = new Stack<Double>();
        String[] parts = input.split(" ");
        for (String s: parts) {
            if (s.equals("(")) ;
            else if (s.equals("+")) ops.push(s);
            else if (s.equals("*")) ops.push(s);
            else if (s.equals(")"))
            {
                String op = ops.pop();
                if (op.equals("+")) vals.push(vals.pop() + vals.pop());
                else if (op.equals("*")) vals.push(vals.pop() * vals.pop());
            }
            else vals.push(Double.parseDouble(s));
        }
        return vals.pop();
    }
}
