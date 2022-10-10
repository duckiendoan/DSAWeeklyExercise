package Week10;

public class IsThisABST {
    class Node {
        int data;
        Node left;
        Node right;

        public Node(int data) {
            this.data = data;
        }
    }
    boolean checkSubtree(Node node, int minValue, int maxValue) {
        if (node == null) return true;
        if (node.data <= minValue || node.data >= maxValue) return false;
        return checkSubtree(node.left, minValue, node.data) && checkSubtree(node.right, node.data, maxValue);
    }

    boolean checkBST(Node root) {
        return checkSubtree(root, Integer.MIN_VALUE, Integer.MAX_VALUE);
    }
}
