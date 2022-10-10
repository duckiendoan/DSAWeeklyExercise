package Week10;

public class BinaryTreeInsertion {

    class Node {
        int data;
        Node left;
        Node right;

        public Node(int data) {
            this.data = data;
        }
    }

    public Node insert(Node root, int data) {
        if (root == null) return new Node(data);

        if (data < root.data) {
            root.left = insert(root.left, data);
        } else if (data > root.data) {
            root.right = insert(root.right, data);
        } else {
            root.data = data;
        }

        return root;

    }
}
