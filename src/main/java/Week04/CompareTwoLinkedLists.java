package Week04;

// https://www.hackerrank.com/challenges/compare-two-linked-lists
public class CompareTwoLinkedLists {
    static boolean compareLists(SinglyLinkedListNode head1, SinglyLinkedListNode head2) {
        SinglyLinkedListNode ptr1 = head1;
        SinglyLinkedListNode ptr2 = head2;

        while (ptr1 != null && ptr2 != null) {
            if (ptr1.data != ptr2.data)
                return false;
            ptr1 = ptr1.next;
            ptr2 = ptr2.next;
        }
        return ptr1 == null && ptr2 == null;

    }
}
