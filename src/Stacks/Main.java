package Stacks;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Stack;

class MyQueue {
    Stack<Integer> q;
    int size;

    public MyQueue() {
        q = new Stack<>();
        size = 0;
    }

    public void push(int x) {
        q.push(x);
        size++;
    }

    public int pop() {
        if(size == 0) return -1;
        else if(size == 1) return q.pop();

        Stack<Integer> st = new Stack<>();
        for(int i = 1; i <= size-1; i++) {
            st.push(q.pop());
        }
        int val = q.pop();
        while(!st.isEmpty()) {
            q.push(st.pop());
        }
        return val;
    }

    public int peek() {
        if(size == 0) return -1;
        else if(size == 1) return q.peek();

        Stack<Integer> st = new Stack<>();
        for(int i = 1; i <= size-1; i++) {
            st.push(q.pop());
        }
        int val = q.peek();
        while(!st.isEmpty()) {
            q.push(st.pop());
        }
        return val;
    }

    public boolean empty() {
        return size == 0;
    }
}
