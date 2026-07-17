package LinkedLists;

public class Reverse_Nodes_in_K_Groups {
    public static ListNode findKthNode(ListNode temp, int k) {
        k--;
        while(temp != null && k > 0) {
            k--;
            temp = temp.next;
        }
        return temp;
    }

    public static ListNode reverseKGroup(ListNode head, int k) {
        ListNode temp = head;
        ListNode prevNode = null;
        while(temp != null) {
            ListNode kthNode = findKthNode(temp, k);
            if(kthNode == null) {
                if(prevNode != null) prevNode.next = temp;
                break;
            }

            ListNode nextNode = kthNode.next;
            kthNode.next = null;
            Reverse_LL.reverse(temp);
            if(temp == head) {
                head = kthNode;
            }else {
                prevNode.next = kthNode;
            }

            prevNode = temp;
            temp = nextNode;
        }

        return head;
    }

    public static void main(String[] args) {
        int[] arr = {1,2,3,4,5,6,7,8,9,10};
        ListNode head = LLUtils.createSinglyLL(arr);
        head = reverseKGroup(head, 3);
        LLUtils.displaySinglyLL(head);
    }
}
