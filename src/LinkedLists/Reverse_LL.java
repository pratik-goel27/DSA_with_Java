package LinkedLists;

public class Reverse_LL {
    static class Node {
        int data;
        Node next;
        Node(int data) {
            this.data = data;
            this.next = null;
        }
    }

    public static Node reverse(Node head) {
        //ITERATIVE :- (BRUTE FORCE) :-
//        Node temp = head;
//        Stack<Integer> st = new Stack<>();
//        while(temp != null) {
//            st.push(temp.data);
//            temp = temp.next;
//        }
//
//        temp = head;
//        while(temp != null || !st.isEmpty()) {
//            temp.data = st.pop();
//            temp = temp.next;
//        }
//
//        return head;

        Node prev = null;
        Node temp = head;
        Node front;

        while(temp != null) {
            front = temp.next;
            temp.next = prev;
            prev = temp;
            temp = front;
        }
        return prev;

        //RECURSIVE :-
//        if(head == null || head.next == null) return head;
//        ListNode newHead = reverse(head.next);
//        ListNode front = head.next;
//        front.next = head;
//        head.next = null;
//        return newHead;
    }

    public static void display(Node head) {
        Node temp = head;
        while(temp != null) {
            System.out.print(temp.data+ "-->");
            temp = temp.next;
        }
        System.out.println("null");
    }

    public static void main(String[] args) {
        Node head = new Node(1);
        head.next = new Node(2);
        head.next.next = new Node(10);
        head.next.next.next = new Node(4);
        head.next.next.next.next = new Node(5);
        display(head);
        Node newHead = reverse(head);
        display(newHead);
    }
}