package LinkedLists;

public class Reverse_LL {

    public static ListNode reverse(ListNode head) {
        //ITERATIVE :-
//        ListNode prev = null;
//        ListNode curr = top;
//        ListNode next;
//
//        while(curr != null) {
//            next = curr.next;
//            curr.next = prev;
//            prev = curr;
//            curr = next;
//        }
//
//        top = prev;
//        return top;

        //RECURSIVE :-
        if(head == null || head.next == null) return head;
        ListNode newHead = reverse(head.next);
        ListNode front = head.next;
        front.next = head;
        head.next = null;
        return newHead;
    }

    public static void main(String[] args) {
        int[] arr = {1,2,3,4,5};
        ListNode head = LLUtils.createSinglyLL(arr);
        LLUtils.displaySinglyLL(head);
        head = reverse(head);
        LLUtils.displaySinglyLL(head);
    }
}