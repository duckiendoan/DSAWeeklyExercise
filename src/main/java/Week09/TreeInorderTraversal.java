package Week09;

import java.util.Scanner;
import java.util.Stack;

public class TreeInorderTraversal {
    static class Node {
        int data;
        Node left;
        Node right;

        public Node(int data) {
            this.data = data;
        }
    }

    public static void inOrder(Node root) {
        if (root.left != null)
            inOrder(root.left);
        System.out.print(root.data + " ");
        if (root.right != null)
            inOrder(root.right);
    }

    public static void inorder2(Node root) {
        Stack<Node> stack = new Stack<>();
        Node node = root;

        do {
            while (node != null) {
                stack.push(node);
                node = node.left;
            }
            if (!stack.isEmpty()) {
                node = stack.pop();
                System.out.print(node.data + " ");
                node = node.right;
            }

        } while (!stack.isEmpty() || node != null);
    }

    public static Node insert(Node root, int data) {
        if(root == null) {
            return new Node(data);
        } else {
            Node cur;
            if(data <= root.data) {
                cur = insert(root.left, data);
                root.left = cur;
            } else {
                cur = insert(root.right, data);
                root.right = cur;
            }
            return root;
        }
    }

    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        int t = scan.nextInt();
        Node root = null;
        while(t-- > 0) {
            int data = scan.nextInt();
            root = insert(root, data);
        }
        scan.close();
        inorder2(root);
    }
}
