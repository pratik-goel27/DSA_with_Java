package LinkedLists;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

public class Main2 {

    static class Node {
        int data;
        Node next;

        public Node(int data) {
            this.data = data;
            this.next = null;
        }
    }

    public static Node head;
    public static Node tail;
    public static int size;

    public static void addFirst(int data) {
        Node newNode = new Node(data);
        size++;
        if(head == null) {
            head = tail = newNode;
            return;
        }
        newNode.next = head;
        head = newNode;
    }

    public static void addLast(int data) {
        size++;
        Node newNode = new Node(data);
        if(head == null) {
            head = tail = newNode;
            return;
        }
        tail.next = newNode;
        tail = newNode;
    }

    public static void addAtIdx(int idx, int data) {
        Node newNode = new Node(data);
        size++;
        if(head == null) {
            head = tail = newNode;
            return;
        }
        int i = 0;
        Node temp = head;
        while(i < idx-1) {
            temp = temp.next;
            i++;
        }
        newNode.next = temp.next;
        temp.next = newNode;
    }

    public static int removeFirst() {
        if(size == 0) {
            System.out.println("LL is empty");
            return -1;
        }else if(size == 1) {
            int val = head.data;
            head = tail = null;
            size = 0;
            return val;
        }
        int val = head.data;
        head = head.next;
        size--;
        return val;
    }

    public static int removeLast() {
        if(size == 0) {
            System.out.println("LL is empty");
            return -1;
        }else if(size == 1) {
            int val = head.data;
            head = tail = null;
            size = 0;
            return val;
        }
        Node temp = head;
        while(temp.next.next != null) {
            temp = temp.next;
        }
        int val = temp.next.data;
        temp.next = null;
        tail = temp;
        size--;
        return val;
    }

    public static void deleteNthNode(int n) {

    }

    public static void deleteNthNodeFromEnd(int n) {
        if (size == 0) {
            System.out.println("LL is empty");
            return;
        }else if(size == 1) {
            head = tail = null;
            return;
        }else if(size == n) {
            head = head.next;
            return;
        }
        Node temp = head;
        int i = 0;
        int idx = size-n+1;
        while(i < idx-2) {
            temp = temp.next;
            i++;
        }
        temp.next = temp.next.next;
    }

    public static int itrSearch(int data) {
        Node temp = head;
        int i = 0;
        while(temp != null) {
            if(temp.data == data) {
                return i;
            }
            temp = temp.next;
            i++;
        }
        return -1;
    }

    public static int recSearch(int data) {
        return helper(head,data);
    }
    public static int helper(Node head, int data) {
        if(head == null) {
            return -1;
        }
        if(head.data == data) {
            return 0;
        }
        int idx = helper(head.next, data);
        if(idx == -1) {
            return -1;
        }
        return idx+1;
    }

    public static void reverse() {
        //BRUTE FORCE:-
//        Node temp = top;
//        Stack<Integer> st = new Stack<>();
//        while(temp != null) {
//            st.push(temp.data);
//            temp = temp.next;
//        }
//        temp = top;
//        while(!st.isEmpty()) {
//            temp.data = st.pop();
//            temp = temp.next;
//        }

        //OPTIMAL(ITERATIVE):-
//        Node prev = null;
//        Node curr = tail = top;
//        Node next;
//
//        while(curr != null) {
//            next = curr.next;
//            curr.next = prev;
//            prev = curr;
//            curr = next;
//        }
//        top = prev;

        //OPTIMAL(RECURSIVE):-
//        if(top == null || top.next == null) {
//            return top;
//        }
//        Node newHead = reverse(top.next);
//        Node front = top.next;
//        front.next = top;
//        top.next = null;
//        return newHead;
    }

    public static Node findMid(Node head) {
        Node slow = head;
        Node fast = head;
        while(fast != null && fast.next != null) {
            slow = slow.next;
            fast = fast.next.next;
        }
        return slow;
    }

    public static boolean checkIfPalindrome() {
        if(head == null || head.next == null) {
            return true;
        }
        //find the mid:-
        Node midNode = findMid(head);

        //reverse the LL from 2nd half:-
        Node prev = null;
        Node curr = midNode;
        Node next;
        while(curr != null) {
            next = curr.next;
            curr.next = prev;
            prev = curr;
            curr = next;
        }

        //Check the left and right halfs:-
        Node left = head;
        Node right = prev;
        while(right != null) {
            if(left.data != right.data) {
                return false;
            }
            left = left.next;
            right = right.next;
        }
        return true;
    }

    public static void display() {
        Node temp = head;
        while(temp != null) {
            System.out.print(temp.data+"->");
            temp = temp.next;
        }
        System.out.println("null");
    }
    public static void deleteMiddle() {
        int size2 = 0;
        Node temp = head;
        while(temp != null) {
            size2++;
            temp = temp.next;
        }
        int midIdx = size2/2;
        int i = 0;
        temp = head;
        while(i < midIdx-1) {
            temp = temp.next;
            i++;
        }
        temp.next = temp.next.next;
//        return top
    }

    public static boolean isCycle() {
        Node slow = head;
        Node fast = head;
        while(fast != null && fast.next != null) {
            slow = slow.next;
            fast = fast.next.next;
            if(slow == fast) {
                return true;
            }
        }
        return false;
    }

    public static void main(String[] args) {
        addFirst(1);
        addLast(2);
        addLast(4);
        addAtIdx(2,3);
        addLast(5);
        addLast(6);
        display();
        List<Integer> list = new ArrayList<>();
    }
}