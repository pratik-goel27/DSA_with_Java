package LinkedLists;

import java.util.Stack;

public class Reverse_DLL {

    public static DoublyListNode reverseDLL(DoublyListNode head) {
        if(head == null || head.next == null) return head;
        Stack<Integer> st = new Stack<>();
        DoublyListNode temp = head;
        while(temp != null) {
            st.push(temp.data);
            temp = temp.next;
        }
        temp = head;
        while(temp != null) {
            temp.data = st.pop();
            temp = temp.next;
        }
        return head;
    }

    public static void main(String[] args) {
        int[] arr = {1,2,3,4,5,6};
        DoublyListNode head = LLUtils.createDoublyLL(arr);
        LLUtils.displayDoublyLL(head);
        reverseDLL(head);
        LLUtils.displayDoublyLL(head);
    }
}