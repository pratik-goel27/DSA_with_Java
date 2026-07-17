package LinkedLists;

import java.util.HashMap;

public class Clone_LL_with_Next_and_Random_Pointers {
    public static ListNode copyRandomList(ListNode head) {
        //BRUTE FORCE :-
//        HashMap<ListNode, ListNode> map = new HashMap<>();
//        ListNode temp = head;
//        while(temp != null) {
//            map.put(temp, new ListNode(temp.data));
//            temp = temp.next;
//        }
//
//        temp = head;
//        while(temp != null) {
//            map.get(temp).next = map.get(temp.next);
//            map.get(temp).random = map.get(temp.random);
//            temp = temp.next;
//        }
//
//        return map.get(head);


        //OPTIMAL SOLUTION :-
         //Insert middle node:
//        ListNode temp = head;
//        while(temp != null) {
//            ListNode newNode = new ListNode(temp.data);
//            newNode.next = temp.next;
//            temp.next = newNode;
//            temp = temp.next.next;
//        }
//
//        //connect the random pointers :-
//        temp = head;
//        while(temp != null) {
//            if(temp.random != null)
//                temp.next.random = temp.random.next;
//            else
//                temp.next.random = null;
//            temp = temp.next.next;
//        }
//
//        //connect next pointers :-
//        temp = head;
//        ListNode dummy = new ListNode(-1);
//        ListNode res = dummy;
//        while(temp != null) {
//            res.next = temp.next;
//            temp.next = temp.next.next;
//            res = res.next;
//            temp = temp.next;
//        }
//
//        return dummy.next;
    }

    public static void main(String[] args) {

    }
}
