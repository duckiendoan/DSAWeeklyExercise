package Week09;

import java.util.Stack;

public class PreorderTraversal {
    static class Node {
        int data;
        Node left;
        Node right;

        public Node(int data) {
            this.data = data;
        }
    }

    public static void preOrder(Node root) {
        System.out.print(root.data + " ");
        if (root.left != null)
            preOrder(root.left);
        if (root.right != null)
            preOrder(root.right);
    }

    public static void preOrderIterative(Node root) {
        Stack<Node> stack = new Stack<>();
        Node node = root;

        do {
            while (node != null) {
                stack.push(node);
                System.out.print(node.data + " ");
                node = node.left;
            }
            if (!stack.isEmpty()) {
                node = stack.pop();
                node = node.right;
            }

        } while (!stack.isEmpty() || node != null);
    }
}
