package LinkedLists;

import com.sun.security.jgss.GSSUtil;

public class Rotate_LL {
    public static ListNode findNthNode(ListNode head, int k) {
        ListNode temp = head;
        int cnt = 1;
        while(temp != null) {
            if(cnt == k) return temp;
            cnt++;
            temp = temp.next;
        }
        return temp;
    }

    public static ListNode rotateRight(ListNode head, int k) {
        if(head == null || k == 0) return head;
        ListNode tail = head;
        int size = 1;
        while(tail.next != null) {
            size++;
            tail = tail.next;
        }

        k = k % size;
        if(k == 0) return head;

        tail.next = head;

        ListNode newLastNode = findNthNode(head, size-k);
        head = newLastNode.next;
        newLastNode.next = null;

        return head;
    }

    public static void main(String[] args) {
        int[] arr = {1,2,3,4,5};
        ListNode head = LLUtils.createSinglyLL(arr);
        head = rotateRight(head, 2);
        LLUtils.displaySinglyLL(head);

        Integer a = null;

        System.out.println(a.getClass().getName());
    }
}
