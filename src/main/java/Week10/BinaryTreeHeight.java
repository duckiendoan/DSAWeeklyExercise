package Week10;

// https://www.hackerrank.com/challenges/tree-height-of-a-binary-tree/problem
public class BinaryTreeHeight {
    class Node {
        int data;
        Node left;
        Node right;
    }


    public static int height(Node root) {
        // Write your code here.
        int leftHeight = -1, rightheight = -1;
        if (root.left != null)
            leftHeight = height(root.left);
        if (root.right != null)
            rightheight = height(root.right);
        return 1 + Math.max(leftHeight, rightheight);
    }
}
