package Week04;

// https://www.hackerrank.com/challenges/insert-a-node-at-a-specific-position-in-a-linked-list
public class InsertNodeAtPosition {
    public static SinglyLinkedListNode insertNodeAtPosition(SinglyLinkedListNode llist, int data, int position) {
        // Write your code here
        if (position == 0) {
            SinglyLinkedListNode newHead = new SinglyLinkedListNode(data);
            newHead.next = llist;
            return newHead;
        }

        SinglyLinkedListNode prev = llist;
        for (int i = 0; i < position - 1; i++)
            prev = prev.next;

        SinglyLinkedListNode oldNext = prev.next;
        prev.next = new SinglyLinkedListNode(data);
        prev.next.next = oldNext;

        return llist;
    }
}
