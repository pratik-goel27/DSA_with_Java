package LinkedLists;

import java.util.HashSet;

public class Starting_Point_in_LL {

    public static ListNode detectCycle(ListNode head) {
        //BRUTE FORCE APPROACH :- USING HASHING :-
//        HashSet<Node> map = new HashSet<>();
//        Node temp = head;
//        while(temp != null) {
//            if(!map.contains(temp)) {
//                map.add(temp);
//                temp = temp.next;
//            }else return temp;
//        }
//
//        return null;

        ListNode slow = head;
        ListNode fast = head;
        while(fast != null && fast.next != null) {
            slow = slow.next;          //+1
            fast = fast.next.next;     //+2

            if(slow == fast) {         //cycle exists.
                slow = head;
                while(slow != fast) {
                    slow = slow.next;
                    fast = fast.next;
                }
                return slow;
            }
        }

        return null;
    }

    public static void main(String[] args) {
        int[] arr = {1,2,3,4,5,6,7,8};
        ListNode head = LLUtils.createCyclicSinglyLL(arr, 2);
        ListNode startNode = detectCycle(head);

        if(startNode != null) System.out.println(startNode.data);
        else System.out.println("The LL dosen't contains cycle.");
    }
}