package LinkedLists;

import java.util.ArrayList;
import java.util.LinkedList;

public class Main3 {

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

    public static void addLast(int data) {
        Node newNode = new Node(data);
        size++;
        if(head == null) {
            head = tail = newNode;
            return;
        }
        tail.next = newNode;
        tail = newNode;
    }

    public static void display() {
        Node temp = head;
        while(temp != null) {
            System.out.print(temp.data+"->");
            temp = temp.next;
        }
        System.out.println("null");
    }

    public static void main(String[] args) {
        addLast(1);
        addLast(2);
        addLast(3);
        addLast(4);
        addLast(5);
        ArrayList<Integer> al = new ArrayList<>();
        Node temp = head;
//        while(temp != null) {
//            al.add(temp.data);
//            if (temp.next != null) {
//                temp = temp.next.next;
//            }else {
//                break;
//            }
//        }
        while(temp != null && temp.next != null) {
            al.add(temp.data);
            temp = temp.next.next;
        }
        if(temp != null) {
            al.add(temp.data);
        }

        temp = head.next;
        while(temp != null) {
            al.add(temp.data);
            if (temp.next != null) {
                temp = temp.next.next;
            }else {
                break;
            }
        }

        temp = head;
        while(!al.isEmpty()) {
            temp.data = al.removeFirst();
            temp = temp.next;
        }
        display();
    }
}
