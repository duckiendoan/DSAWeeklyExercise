package Week04;

// https://www.hackerrank.com/challenges/delete-a-node-from-a-linked-list/problem
public class DeleteANode {
    public static SinglyLinkedListNode deleteNode(SinglyLinkedListNode llist, int position) {
        // Write your code here
        if (position == 0) {
            return llist.next;
        }

        SinglyLinkedListNode prev = llist;
        for (int i = 0; i < position - 1; i++)
            prev = prev.next;
        SinglyLinkedListNode nextItem = prev.next;
        if (nextItem.next != null)
            prev.next = nextItem.next;
        return llist;
    }
}
