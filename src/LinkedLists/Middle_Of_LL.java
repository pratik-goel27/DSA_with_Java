package LinkedLists;

public class Middle_Of_LL {

    public static ListNode findMid(ListNode head) {
        //BRUTE FORCE :-
//        ListNode temp = head;
//        int cnt = 0;
//        while(temp != null) {
//            cnt++;
//            temp = temp.next;
//        }
//
//        temp = head;
//        int i = 1;
//        while(i < (cnt/2 + 1)) {
//            temp = temp.next;
//            i++;
//        }
//
//        return temp;

        //OPTIMAL SOLUTION :-
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
        System.out.println(mid.data);
    }
}
