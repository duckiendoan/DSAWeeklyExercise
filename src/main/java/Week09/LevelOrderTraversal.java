package Week09;

import java.util.LinkedList;
import java.util.Queue;

public class LevelOrderTraversal {
    static class Node {
        int data;
        Node left;
        Node right;

        public Node(int data) {
            this.data = data;
        }
    }

    public static void levelOrder(Node root) {
        Queue<Node> next = new LinkedList<>();
        next.add(root);
        while (!next.isEmpty()) {
            Node current = next.poll();
            System.out.print(current.data + " ");
            if (current.left != null)
                next.add(current.left);
            if (current.right != null)
                next.add(current.right);
        }
    }
}
