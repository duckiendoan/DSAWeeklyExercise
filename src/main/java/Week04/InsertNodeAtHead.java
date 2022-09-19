package Week04;

// https://www.hackerrank.com/challenges/insert-a-node-at-the-head-of-a-linked-list
public class InsertNodeAtHead {
    static SinglyLinkedListNode insertNodeAtHead(SinglyLinkedListNode llist, int data) {
        SinglyLinkedListNode newHead = new SinglyLinkedListNode(data);
        newHead.next = llist;
        return newHead;
    }
}
