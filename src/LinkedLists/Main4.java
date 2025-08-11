package LinkedLists;

import java.util.Arrays;

public class Main4 {

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
//        int[] arr = {6,3,5,4,2};
//        for(int i = 0; i < arr.length-1; i++) {
//            for(int j = 0; j < arr.length-i-1; j++) {
//                if(arr[j] > arr[j+1]) {
//                    int temp = arr[j];
//                    arr[j] = arr[j+1];
//                    arr[j+1] = temp;
//                }
//            }
//        }
//        System.out.println(Arrays.toString(arr));
        addLast(6);
        addLast(3);
        addLast(5);
        addLast(4);
        addLast(2);
        display();
        System.out.println(head.data);
        Node curr;
        for(int i = 0; i < size-1; i++) {
            curr = head;
            for(int j = 0; j < size-i-1; j++) {
                if(curr.data > curr.next.data) {
                    int temp = curr.data;
                    curr.data = curr.next.data;
                    curr.next.data = temp;


                }
                curr = curr.next;
            }
        }
        display();
    }
}