package Stacks;

public class Impl_Stack_Using_Arr {
    static int[] arr;
    static int size;
    static int top = -1;

    public Impl_Stack_Using_Arr(int size) {
        this.size = size;
        arr = new int[size];
    }

    public void push(int data) {
        if(top >= size-1) {
            System.out.println("Stack Overflow");
            return;
        }
        arr[++top] = data;
    }

    public int pop() {
        if(top == -1) {
            System.out.println("Stack Underflow");
            return -1;
        }
        return arr[top--];
    }

    public int peek() {
        if(top == -1) {
            System.out.println("No element present in stack");
            return -1;
        }
        return arr[top];
    }

    public int size() {
        return top+1;
    }
    public static void main(String[] args) {
        Impl_Stack_Using_Arr st = new Impl_Stack_Using_Arr(5);
        st.push(1);
        st.push(2);
        st.push(3);
        st.push(4);
        st.push(5);
//        st.push(6);
        System.out.println(st.peek());
        st.pop();
        System.out.println(st.peek());
    }
}
