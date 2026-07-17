package LinkedLists;

import java.util.ArrayList;
import java.util.Collections;

public class Flattening_a_LL {
    public ListNode convert(ArrayList<Integer> al) {
        ListNode head = new ListNode(al.getFirst());
        ListNode temp = head;
        for(int i = 1; i < al.size(); i++) {
            temp.bottom = new ListNode(al.get(i));
            temp.next = null;
            temp = temp.bottom;
        }

        return head;
    }

    public ListNode merge(ListNode list1, ListNode list2) {
        ListNode dummy = new ListNode(-1);
        ListNode res = dummy;
        while(list1 != null && list2 != null) {
            if(list1.data < list2.data) {
                res.bottom = list1;
                res = list1;
                list1 = list1.bottom;
            }else {
                res.bottom = list2;
                res = list2;
                list2 = list2.bottom;
            }
            res.next = null;
        }

        if(list1 != null) res.bottom = list1;
        else res.bottom = list2;
        return dummy.bottom;
    }

    public ListNode flatten(ListNode root) {
        //BRUTE FORCE :-
//        ArrayList<Integer> al = new ArrayList<>();
//        ListNode temp = root;
//        while(temp != null) {
//            ListNode t2 = temp;
//            while(t2 != null) {
//                al.add(t2.data);
//                t2 = t2.bottom;
//            }
//
//            temp = temp.next;
//        }
//
//        Collections.sort(al);
//
//        root = convert(al);
//        return root;


        //OPTIMAL SOLUTION :-
        if(root == null || root.next == null) return root;

        ListNode mergedHead = flatten(root.next);
        return merge(root, mergedHead);
    }

    public static void main(String[] args) {

    }
}
