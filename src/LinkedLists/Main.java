package LinkedLists;

public class Main {

    public static ListNode head;
    public static ListNode tail;
    public static int size;

    public static void addFirst(int data) {
        ListNode newNode = new ListNode(data);
        size++;
        if(head == null) {
            head = tail = newNode;
            return;
        }
        newNode.next = head;
        head = newNode;
    }

    public static void addLast(int data) {
        ListNode newNode = new ListNode(data);
        size++;
        if(head == null) {
            head = tail = newNode;
            return;
        }
        tail.next = newNode;
        tail = newNode;
    }

    public static void addAtIdx(int data, int idx) {
        ListNode newNode = new ListNode(data);
        size++;
        if(head == null) {
            head = tail = newNode;
            return;
        }
        ListNode temp = head;
        int i = 0;
        while(i < idx-1) {
            temp = temp.next;
            i++;
        }
        newNode.next = temp.next;
        temp.next = newNode;
    }

    public static int removeFirst() {
        if(size == 0) {
            System.out.println("LL is empty.");
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
            System.out.println("LL is empty.");
            return -1;
        }else if(size == 1) {
            int val = head.data;
            head = tail = null;
            size = 0;
            return val;
        }

        ListNode temp = head;
        while(temp.next.next != null) {
            temp = temp.next;
        }
        int val = temp.data;
        temp.next = null;
        tail = temp;
        size--;
        return val;
    }

    public static void deleteNthNodeFromEnd(int n) {
        if(n == size) {
            head = head.next;
            return;
        }
        int i = 0;
        ListNode temp = head;
        while(i <= (size-n-1)) {
            temp = temp.next;
            i++;
        }
        temp.next = temp.next.next;
    }

    public static int itrSearch(int key) {
        ListNode temp = head;
        int i = 0;
        while(temp != null) {
            if(temp.data == key) {
                return i;
            }
            i++;
            temp = temp.next;
        }
        return -1;
    }

    public static int recSearch(int key) {
        return helper(head,key);
    }
    public static int helper(ListNode head, int key) {
        if(head == null) {
            return -1;
        }
        if(head.data == key) {
            return 0;
        }
        int idx = helper(head.next,key);
        if(idx == -1) {
            return -1;
        }
        return idx+1;
    }

    public static void reverse() {
        ListNode prev = null;
        ListNode curr = tail = head;
        ListNode next;

        while(curr != null) {
            next = curr.next;
            curr.next = prev;
            prev = curr;
            curr = next;
        }
        head = prev;
    }

    public static void display() {
        ListNode temp = head;
        while(temp != null) {
            System.out.print(temp.data+"->");
            temp = temp.next;
        }
        System.out.println("null");
    }

    public static void main(String[] args) {
        addFirst(1);
        addLast(2);
        addLast(3);
        addLast(4);
        addLast(5);
//        addLast(6);
//        addAtIdx(4,3);
//        display();
//        removeFirst();
//        System.out.println(itrSearch(1));
//        System.out.println(recSearch(3));
//        display();
//        reverse();
        display();
        deleteNthNodeFromEnd(2);
        display();

    }
}