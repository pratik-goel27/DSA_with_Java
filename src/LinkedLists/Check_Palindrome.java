package LinkedLists;

import java.util.Stack;

public class Check_Palindrome {

    public static boolean isPalindrome(ListNode head) {
//        //BRUTE FORCE APPROACH :-  O(N) space, have to reduce this in optimal soln.
//        //STEP1 :-
//        ListNode temp = head;
//        Stack<Integer> st = new Stack<>();
//        while(temp != null) {
//            st.push(temp.data);
//            temp = temp.next;
//        }
//
//        //STEP2 :-
//        temp = head;
//        while(temp != null || !st.isEmpty()) {
//            if(temp.data != st.peek()) return false;
//            temp = temp.next;
//            st.pop();
//        }
//
//        return true;

        //OPTIMAL SOLUTION :-
        //Step1: finding the midNode:- for even length LL choose the first mid-node.
        ListNode slow = head;
        ListNode fast = head;
        while(fast.next != null && fast.next.next != null) {
            slow = slow.next;
            fast = fast.next.next;
        }

        //Step2: reversing the LL from the midNode to the end.
        ListNode newHead = Reverse_LL.reverse(slow.next);

        //Step3: checking the left and right halves.
        ListNode first = head;
        ListNode right = newHead;
        while(right != null) {
            if(first.data != right.data) return false;

            first = first.next;
            right = right.next;
        }
        Reverse_LL.reverse(newHead);
        return true;
    }

    public static void main(String[] args) {
        int[] arr = {1,2,2,3,2,2,1};
        ListNode head = LLUtils.createSinglyLL(arr);
        System.out.println(isPalindrome(head));
    }
}