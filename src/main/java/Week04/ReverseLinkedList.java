package Week04;

// https://www.hackerrank.com/challenges/reverse-a-linked-list/problem
public class ReverseLinkedList {
    public static SinglyLinkedListNode reverse(SinglyLinkedListNode llist) {
        if (llist == null)
            return null;
        return reverse(llist, null);

    }

    public static SinglyLinkedListNode reverse(SinglyLinkedListNode head, SinglyLinkedListNode prev) {
        if (head.next == null) {
            head.next = prev;
            return head;
        }
        SinglyLinkedListNode current = head.next;
        head.next = prev;
        return reverse(current, head);
    }
}
