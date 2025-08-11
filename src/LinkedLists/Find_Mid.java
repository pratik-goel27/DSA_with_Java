package LinkedLists;

public class Find_Mid {

    public static ListNode findMid(ListNode head) {
        ListNode slow = head;
        ListNode fast = head;
        while(fast != null && fast.next != null) {
            slow = slow.next;
            fast = fast.next.next;
        }
        return slow;
    }

    public static void main(String[] args) {
        int[] arr = {1,2,3,4,5,6};
        ListNode head = LLUtils.createSinglyLL(arr);
        ListNode mid = findMid(head);
        LLUtils.displaySinglyLL(mid);
    }
}