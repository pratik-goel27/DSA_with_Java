package LinkedLists;

public class Middle_of_LL {

    public static ListNode findMid(ListNode head) {
        //BRUTE FORCE METHOD :-
//        ListNode temp = head;
//        //Finding the no of nodes :-
//        int cnt = 0;
//        while(temp != null) {
//            cnt++;
//            temp = temp.next;
//        }
//
//        //Finding the mid :-
//        temp = head;
//        int mid = (cnt / 2) + 1;
//        while(temp != null) {
//            mid--;
//            if(mid == 0) break;
//            temp = temp.next;
//        }
//        return temp;

        //OPTIMAL (TORTOISE AND HARE) :-
        ListNode slow = head;
        ListNode fast = head;
        while(fast != null && fast.next != null) {
            slow = slow.next;
            fast = fast.next.next;
        }
        return slow;
    }

    public static void main(String[] args) {
        int[] arr = {1,2,10,4,5};
        ListNode head = LLUtils.createSinglyLL(arr);
        ListNode midNode = findMid(head);
        System.out.println(midNode.data);
    }
}