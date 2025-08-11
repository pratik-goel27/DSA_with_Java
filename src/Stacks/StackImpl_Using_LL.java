package Stacks;

public class StackImpl_Using_LL {

    static class Node {
        int data;
        Node next;

        public Node(int data) {
            this.data = data;
            this.next = null;
        }
    }
    static int size;
    public static Node top = null;

    public void push(int data) {
        Node newNode = new Node(data);
        size++;
        if(top == null) {
            top = newNode;
            return;
        }
        newNode.next = top;
        top = newNode;
    }

    public int pop() {
        if(top == null) {
            System.out.println("Stack is empty");
            return -1;
        }
        int val = top.data;
        top = top.next;
        size--;
        return val;
    }

    public int peek() {
        if(top == null) {
            System.out.println("Stack is empty");
            return -1;
        }
        return top.data;
    }

    public static void main(String[] args) {
        StackImpl_Using_LL st = new StackImpl_Using_LL();
        st.push(1);
        st.push(2);
        st.pop();
        System.out.println(size);
    }
}