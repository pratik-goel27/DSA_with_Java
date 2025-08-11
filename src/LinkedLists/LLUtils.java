package LinkedLists;

public class LLUtils {
    public static ListNode createSinglyLL(int[] arr) {
        if(arr.length == 0) return null;

        ListNode head = new ListNode(arr[0]);
        ListNode temp = head;
        for(int i = 1; i < arr.length; i++) {
            temp.next = new ListNode(arr[i]);
            temp = temp.next;
        }
        return head;
    }

    public static DoublyListNode createDoublyLL(int[] arr) {
        if(arr.length == 0) return null;

        DoublyListNode head = new DoublyListNode(arr[0]);
        DoublyListNode temp = head;
        for(int i = 1; i < arr.length; i++) {
            DoublyListNode newNode = new DoublyListNode(arr[i]);
            temp.next = newNode;
            newNode.prev = temp;
            temp = temp.next;
        }
        return head;
    }

    public static void displaySinglyLL(ListNode head) {
        ListNode temp = head;
        while(temp != null) {
            System.out.print(temp.data+"->");
            temp = temp.next;
        }
        System.out.println("null");
    }

    public static void displayDoublyLL(DoublyListNode head) {
        DoublyListNode temp = head;
        while(temp != null) {
            System.out.print(temp.data+"<->");
            temp = temp.next;
        }
        System.out.println("null");
    }
}