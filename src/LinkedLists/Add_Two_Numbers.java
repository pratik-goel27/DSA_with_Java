package LinkedLists;

public class Add_Two_Numbers {
    public static ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        int sum = 0, carry = 0;
        ListNode dummy = new ListNode(-1);
        ListNode temp = dummy;

        while(l1 != null || l2 != null || carry == 1) {
            sum = 0;
            if(l1 != null) {
                sum += l1.data;
                l1 = l1.next;
            }

            if(l2 != null) {
                sum += l2.data;
                l2 = l2.next;
            }

            sum += carry;
            carry = sum / 10;
            ListNode node = new ListNode(sum % 10);
            temp.next = node;
            temp = temp.next;
        }

        return dummy.next;
    }

    public static void main(String[] args) {
        int[] arr1 = {2,4,3};
        int[] arr2 = {5,6,4};
        ListNode l1 = LLUtils.createSinglyLL(arr1);
        ListNode l2 = LLUtils.createSinglyLL(arr2);
        ListNode head = addTwoNumbers(l1, l2);
        LLUtils.displaySinglyLL(head);
    }
}
