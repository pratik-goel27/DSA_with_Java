package LinkedLists;

public class Delete_Node_In_LL {
    public static void deleteNode(ListNode node) {
        node.data = node.next.data;
        node.next = node.next.next;
    }

    public static void main(String[] args) {
        int[] arr = {1,4,2,3};
        ListNode head = LLUtils.createSinglyLL(arr);
        ListNode node = head.next.next;
        LLUtils.displaySinglyLL(head);
        deleteNode(node);
        LLUtils.displaySinglyLL(head);
    }
}
