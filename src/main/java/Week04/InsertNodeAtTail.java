package Week04;

// https://www.hackerrank.com/challenges/insert-a-node-at-the-tail-of-a-linked-list/problem
public class InsertNodeAtTail {
    static SinglyLinkedListNode insertNodeAtTail(SinglyLinkedListNode head, int data) {
        if (head == null) {
            return new SinglyLinkedListNode(data);
        }

        SinglyLinkedListNode ptr = head;
        while (ptr.next != null) {
            ptr = ptr.next;
        }
        ptr.next = new SinglyLinkedListNode(data);
        return head;
    }
}
