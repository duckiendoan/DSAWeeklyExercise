package Week04;

// https://www.hackerrank.com/challenges/print-the-elements-of-a-linked-list/problem
public class PrintLinkedListElements {
    /*
     * For your reference:
     *
     * SinglyLinkedListNode {
     *     int data;
     *     SinglyLinkedListNode next;
     * }
     *
     */
    private static class SinglyLinkedListNode {
          int data;
          SinglyLinkedListNode next;
     }
    static void printLinkedList(SinglyLinkedListNode head) {
        for (SinglyLinkedListNode ptr = head; ptr != null; ptr = ptr.next) {
            System.out.println(ptr.data);
        }

    }
}
