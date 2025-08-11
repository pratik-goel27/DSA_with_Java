package LinkedLists;

public class Check_Palindrome {
    public static boolean isPalindrome(ListNode head) {
        //Step1: finding the midNode:-
        ListNode slow = head;
        ListNode fast = head;
        while(fast != null && fast.next != null) {
            slow = slow.next;
            fast = fast.next.next;
        }
        ListNode midNode = slow;

        //Step2: reversing the LL from the midNode to the end.
        ListNode prev = null;
        ListNode curr = midNode;
        ListNode next;
        while(curr != null) {
            next = curr.next;
            curr.next = prev;
            prev = curr;
            curr = next;
        }
        ListNode secHead = prev;

        //Step3: checking the left and right halfves.
        ListNode left = head;
        ListNode right = secHead;
        while(right != null) {
            if(left.data != right.data) {
                return false;
            }
            left = left.next;
            right = right.next;
        }
        return true;

    }

    public static void main(String[] args) {
        int[] arr = {1,2,2,1};
        ListNode head = LLUtils.createSinglyLL(arr);
        System.out.println(isPalindrome(head));
    }
}
