package Week04;

// https://www.hackerrank.com/challenges/print-the-elements-of-a-linked-list-in-reverse/problem
public class PrintInReverse {
    public static void reversePrint(SinglyLinkedListNode llist) {
        // Write your code here
        if (llist == null)
            return;
        if (llist.next != null)
            reversePrint(llist.next);
        System.out.println(llist.data);
    }
}
