package Week04;

// https://www.hackerrank.com/challenges/merge-two-sorted-linked-lists/problem
public class MergeSortedLinkedLists {
    static SinglyLinkedListNode mergeLists(SinglyLinkedListNode head1, SinglyLinkedListNode head2) {
        SinglyLinkedListNode dummyHead = new SinglyLinkedListNode(0);
        SinglyLinkedListNode ptr1 = head1;
        SinglyLinkedListNode ptr2 = head2;
        SinglyLinkedListNode newPtr = dummyHead;

        while (ptr1 != null && ptr2 != null) {
            if (ptr1.data >= ptr2.data) {
                newPtr.next = new SinglyLinkedListNode(ptr2.data);
                newPtr = newPtr.next;
                ptr2 = ptr2.next;
            } else {
                newPtr.next = new SinglyLinkedListNode(ptr1.data);
                newPtr = newPtr.next;
                ptr1 = ptr1.next;
            }
        }

        while (ptr1 != null) {
            newPtr.next = new SinglyLinkedListNode(ptr1.data);
            newPtr = newPtr.next;
            ptr1 = ptr1.next;
        }

        while (ptr2 != null) {
            newPtr.next = new SinglyLinkedListNode(ptr2.data);
            newPtr = newPtr.next;
            ptr2 = ptr2.next;
        }
        return dummyHead.next;

    }
}
