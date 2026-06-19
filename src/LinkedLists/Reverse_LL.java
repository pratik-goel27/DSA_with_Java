package LinkedLists;

public class Reverse_LL {

    public static ListNode reverse(ListNode head) {
        //ITERATIVE :- (BRUTE FORCE) :-
//        Node temp = head;
//        Stack<Integer> st = new Stack<>();
//        while(temp != null) {
//            st.push(temp.data);
//            temp = temp.next;
//        }
//
//        temp = head;
//        while(temp != null || !st.isEmpty()) {
//            temp.data = st.pop();
//            temp = temp.next;
//        }
//
//        return head;

        //OPTIMAL SOLUTION :- (Reversing the links)
        ListNode prev = null;
        ListNode temp = head;
        ListNode front;

        while(temp != null) {
            front = temp.next;
            temp.next = prev;
            prev = temp;
            temp = front;
        }
        return prev;

        //RECURSIVE :-
//        if(head == null || head.next == null) return head;
//        ListNode newHead = reverse(head.next);
//        ListNode front = head.next;
//        front.next = head;
//        head.next = null;
//        return newHead;
    }

    public static void main(String[] args) {
        int[] arr = {1,2,10,4,5};
        ListNode head = LLUtils.createSinglyLL(arr);
        LLUtils.displaySinglyLL(head);
        ListNode newHead = reverse(head);
        LLUtils.displaySinglyLL(newHead);
    }
}