package Week05;

public class Stack<T> {
    private class Node {
        T value;
        Node next;

        public Node(T value) {
            this.value = value;
        }
    }

    private Node head;
    private int n = 0;

    public void push(T item) {
        if (head == null) {
            head = new Node(item);
        } else {
            Node newHead = new Node(item);
            newHead.next = head;
            head = newHead;
        }
        n++;
    }

    public T pop() {
        T val = head.value;
        head = head.next;
        n--;
        return val;
    }

    public T peek() {
        return head.value;
    }

    public boolean isEmpty() {
        return head == null;
    }

    public int size() {
        return n;
    }
}
