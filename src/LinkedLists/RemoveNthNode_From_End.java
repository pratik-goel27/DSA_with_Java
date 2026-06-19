package LinkedLists;

public class RemoveNthNode_From_End {
    public static ListNode removeNthFromEnd(ListNode head, int n) {
        ListNode temp = head;
        int size = 0;
        while(temp != null) {
            size++;
            temp = temp.next;
        }

        if(size == n) {
            head = head.next;
            return head;
        }

        temp = head;
        int i = 1;
        while(i < size-n) {
            temp = temp.next;
            i++;
        }
        temp.next = temp.next.next;

        return head;
    }

    public static void main(String[] args) {
        int[] arr = {1,2,3,4,5};
        ListNode head = LLUtils.createSinglyLL(arr);
        head = removeNthFromEnd(head, 2);
        LLUtils.displaySinglyLL(head);
    }
}
