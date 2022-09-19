package Week04;

// https://www.hackerrank.com/challenges/get-the-value-of-the-node-at-a-specific-position-from-the-tail/problem
public class GetNodeValue {
    public static int getNode(SinglyLinkedListNode llist, int positionFromTail) {
        // Write your code here
        SinglyLinkedListNode ptr = llist;
        SinglyLinkedListNode ptr2 = llist;
        int i = 0;
        for (;ptr != null; ptr = ptr.next) {
            if (i == positionFromTail) {
                ptr2 = llist;
                i++;
                continue;
            }
            ptr2 = ptr2.next;
            i++;
        }
        return ptr2.data;
    }
}
