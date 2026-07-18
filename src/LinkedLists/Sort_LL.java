package LinkedLists;

import java.util.*;

public class Sort_LL {
    public static ListNode sortList(ListNode head) {
        ArrayList<Integer> al = new ArrayList<>();
        ListNode temp = head;
        while(temp != null) {
            al.add(temp.data);
            temp = temp.next;
        }

        Collections.sort(al);

        ListNode dummy = new ListNode(-1);
        temp = dummy;
        for(int num : al) {
            temp.next = new ListNode(num);
            temp = temp.next;
        }

        return dummy.next;
    }

    public static void main(String[] args) {
        int[] arr = {4,2,1,3};
        ListNode head = LLUtils.createSinglyLL(arr);
        LLUtils.displaySinglyLL(head);
        head = sortList(head);
        LLUtils.displaySinglyLL(head);
    }
}
