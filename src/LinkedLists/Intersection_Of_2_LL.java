package LinkedLists;

import java.util.HashMap;

public class Intersection_Of_2_LL {
    public static ListNode collisionPoint(ListNode t1, ListNode t2, int d) {  //here t1 is the head of smaller LL & t2 is for greater LL.
        while(d != 0) {
            d--;
            t2 = t2.next;
        }

        while(t1 != t2) {
            t1 = t1.next;
            t2 = t2.next;
        }

        return t1;
    }

    public static ListNode getIntersectionNode(ListNode headA, ListNode headB) {
        //BRUTE FORCE :-
//        HashMap<ListNode, Integer> map = new HashMap<>();
//
//        ListNode temp = headA;
//        while(temp != null) {
//            map.put(temp, 1);
//            temp = temp.next;
//        }
//
//        temp = headB;
//        while(temp != null) {
//            if(map.containsKey(temp))
//                return temp;
//            temp = temp.next;
//        }
//
//        return null;


        //BETTER SOLUTION :-
//        ListNode t1 = headA;
//        ListNode t2 = headB;
//        int n1 = 0, n2 = 0;
//
//        while(t1 != null) {
//            n1++;
//            t1 = t1.next;
//        }
//
//        while(t2 != null) {
//            n2++;
//            t2 = t2.next;
//        }
//
//        if(n1 < n2) {
//            return collisionPoint(headA, headB, n2-n1);
//        }else {
//            return collisionPoint(headB, headA, n1-n2);
//        }


        //OPTIMAL SOLUTION :-
        if(headA == null || headB == null) return null;

        ListNode t1 = headA;
        ListNode t2 = headB;

        while(t1 != t2) {  //this condition is only for when there is a single LL and both the heads are pointing to the same starting head.
            t1 = t1.next;
            t2 = t2.next;

            if(t1 == t2) return t1;   //this covers both the cases intersecting nodes exists or not.

            if(t1 == null) t1 = headB;
            if(t2 == null) t2 = headA;
        }

        return t1;
    }

    public static void main(String[] args) {

    }
}
