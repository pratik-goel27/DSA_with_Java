package LinkedLists;

import java.util.LinkedList;
import java.util.Queue;

public class Segregate_Odd_and_Even {
    public static ListNode SegOddEven(ListNode head) {
        //BRUTE FORCE APPROACH :-  O(N) space.
//        if(head == null || head.next == null) return head;
//        ListNode temp = head;
//        Queue<Integer> q = new LinkedList<>();
//        while(temp != null && temp.next != null) {
//            q.add(temp.data);
//            temp = temp.next.next;
//        }
//        if(temp != null) q.add(temp.data);
//
//        temp = head.next;
//        while(temp != null && temp.next != null) {
//            q.add(temp.data);
//            temp = temp.next.next;
//        }
//        if(temp != null) q.add(temp.data);
//
//        temp = head;
//        while(temp != null && !q.isEmpty()) {
//            temp.data = q.poll();
//            temp = temp.next;
//        }
//
//        return head;

        //OPTIMAL SOLUTION :-  Reduce the extra space O(1)
        if(head == null || head.next == null) return head;
        ListNode odd = head;
        ListNode even = head.next;
        ListNode evenHead = head.next;

        while(even != null && even.next != null) {
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