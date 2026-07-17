package LinkedLists;

public class ListNode {
    int data;
    ListNode next;
    ListNode bottom;

    public ListNode(int data) {
        this.data = data;
        this.next = null;
    }

    public ListNode(int data, ListNode next) {
        this.data = data;
        this.next = next;
    }
}