package Week05;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Scanner;
import java.util.Stack;

public class SimpleTextEditor {
    public static void main(String[] args) throws IOException {
        TextEditor editor = new TextEditor();
        BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        for (int i = 0; i < n; i++) {
            String[] z = br.readLine().split(" ");
            if (z[0].equals("1")) {
                editor.append(z[1]);
            } else if (z[0].equals("2")) {
                editor.delete(Integer.parseInt(z[1]));
            } else if (z[0].equals("3")) {
                editor.print(Integer.parseInt(z[1]));
            } else {
                editor.undo();
            }
        }
    }
}

class TextEditor {
    private StringBuilder S = new StringBuilder();
    private Stack<String> operations = new Stack<>();

    public void append(String w) {
        S.append(w);
        operations.push("1 " + w);
    }

    public void delete(int k) {
        operations.push(S.toString());
        S.setLength(S.length() - k);
    }

    public void undo() {
        String op = operations.pop();
        if (op.charAt(0) == '1') {
            S.setLength(S.length() - (op.length() - 2));
        } else  {
            S.setLength(0);
            S.append(op);
        }
    }

    public void print(int k) {
        System.out.println(S.charAt(k - 1));
    }
}