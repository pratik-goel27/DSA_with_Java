package LinkedLists;

public class Remove_Nth_Node_From_End {
    public static ListNode removeNthFromEnd(ListNode head, int n) {
        //BRUTE FORCE :-
//        ListNode temp = head;
//        int size = 0;
//        while(temp != null) {
//            size++;
//            temp = temp.next;
//        }
//
//        if(size == n) {
//            head = head.next;
//            return head;
//        }
//
//        temp = head;
//        int i = 1;
//        while(i < size-n) {
//            temp = temp.next;
//            i++;
//        }
//        temp.next = temp.next.next;
//
//        return head;

        //OPTIMAL SOLUTION :-
        if(head == null) return null;
        ListNode fast = head;
        ListNode slow = head;
        for(int i = 0; i < n; i++) fast = fast.next;
        if(fast == null) {
            head = head.next;
            return head;
        }
        while(fast.next != null) {
            slow = slow.next;
            fast = fast.next;
        }

        slow.next = slow.next.next;
        return head;
    }

    public static void main(String[] args) {
        int[] arr = {1,2,3,4,5};
        ListNode head = LLUtils.createSinglyLL(arr);
        LLUtils.displaySinglyLL(head);
        head = removeNthFromEnd(head, 2);
        LLUtils.displaySinglyLL(head);
    }
}
