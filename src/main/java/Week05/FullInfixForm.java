package Week05;
import edu.princeton.cs.algs4.*;

// Ex1.3.9 from https://docs.google.com/document/d/1J5Vpa2CBYVeWGQ3Ol0hvdcEVCJ5b8St2RthMdcPs-kA/edit
public class FullInfixForm {
    public static void main(String[] args) {
        Stack<String> operands = new Stack<>();
        Stack<String> operations = new Stack<>();

        while(!StdIn.isEmpty()) {
            String c = StdIn.readString();
            if (c.equals("+") || c.equals("-") || c.equals("*") || c.equals("/")) {
                operations.push(c);
            }
            else if (c.equals(")")) {
                String op = operations.pop();
                String operand1 = operands.pop();
                String operand2 = operands.pop();

                operands.push("( " + operand2 + " " + op + " " + operand1 + " )");
            } else {
                operands.push(String.valueOf(c));
            }
        }
        StdOut.println(operands.pop());
    }
}
