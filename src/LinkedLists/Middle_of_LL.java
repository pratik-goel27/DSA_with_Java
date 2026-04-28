package LinkedLists;

public class Middle_of_LL {
    static class Node {
        int data;
        Node next;

        Node(int data, Node next) {
            this.data = data;
            this.next = next;
        }

        Node(int data) {
            this.data = data;
            this.next = null;
        }
    }

    public static Node findMid(Node head) {
        //BRUTE FORCE METHOD :-
//        Node temp = head;
//        //Finding the no of nodes :-
//        int cnt = 0;
//        while(temp != null) {
//            cnt++;
//            temp = temp.next;
//        }
//
//        //Finding the mid :-
//        temp = head;
//        int mid = (cnt / 2) + 1;
//        while(temp != null) {
//            mid--;
//            if(mid == 0) break;
//            temp = temp.next;
//        }
//        return temp;

        //OPTIMAL (TORTOISE AND HARE) :-
        Node slow = head;
        Node fast = head;
        while(fast != null && fast.next != null) {
            slow = slow.next;
            fast = fast.next.next;
        }
        return slow;
    }

    public static void main(String[] args) {
        Node head = new Node(1);
        head.next = new Node(2);
        head.next.next = new Node(10);
        head.next.next.next = new Node(4);
        head.next.next.next.next = new Node(5);
        Node mid = findMid(head);
        System.out.println(mid.data);
    }
}