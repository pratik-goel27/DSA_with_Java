package LinkedLists;

import java.util.HashMap;

public class Detect_Loop {

    public static boolean hasCycle(ListNode head) {
        //BRUTE FORCE USING HASHING :-
//        Node temp = head;
//        HashMap<Node, Integer> map = new HashMap<>();
//        while(temp != null) {
//            int val = map.getOrDefault(temp, 0);  //if the node has been seen for the first time then val = 0.
//            if(val >= 1) return true;  //if the node has been seen before it's key will be at least 1 or greater than that which means loop.
//            map.put(temp, val+1);
//            temp = temp.next;
//        }
//
//        return false;

        //OPTIMAL :- TORTOISE AND HARE ALGO / FLOYD'S ALGO :-
        ListNode slow = head;
        ListNode fast = head;
        while(fast != null && fast.next != null) {
            slow = slow.next;
            fast = fast.next.next;
            if(slow == fast) return true;
        }

        return false;
    }

//    public static int lengthOfLoop(ListNode head) {
//        ListNode slow = head;
//        ListNode fast = head;
//        while(fast != null && fast.next != null) {
//            slow = slow.next;
//            fast = fast.next.next;
//
//            if(slow == fast) {
//                int count = 1;
//                slow = slow.next;
//                while(slow != fast) {
//                    count++;
//                    slow = slow.next;
//                }
//                return count;
//            }
//        }
//
//        return 0;
//    }

    public static void main(String[] args) {
        int[] arr = {1,2,3,4,5,6,7,8};
        ListNode head = LLUtils.createCyclicSinglyLL(arr, 2);
        System.out.println(hasCycle(head));
//        System.out.println(lengthOfLoop(head));
    }
}