package LinkedLists;

public class Segregate_Odd_and_Even {
    public static ListNode SegOddEven(ListNode head) {
        if(head == null || head.next == null) {
            return head;
        }
        ListNode odd = head;
        ListNode even = head.next;
        ListNode evenHead = head.next;
        while(even != null) {
            odd.next = odd.next.next;
            even.next = even.next.next;

            odd = odd.next;
            even = even.next;
        }
        odd.next = evenHead;
        return head;
    }

    public static void main(String[] args) {
        int[] arr = {1,2,3,4,5,6,7};
        ListNode head = LLUtils.createSinglyLL(arr);
        head = SegOddEven(head);
        LLUtils.displaySinglyLL(head);
    }
}