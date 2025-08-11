package Stacks;

public class Impl_Queue_Using_Arr {
    static int[] arr;
    static int start, end, size, currSize;

    public Impl_Queue_Using_Arr(int size) {
        arr = new int[size];
        start = end = -1;
        this.size = size;
        currSize = 0;
    }

    public boolean isEmpty() {
        return currSize == 0;
    }

    public void push(int data) {
        if(currSize >= size) {
            System.out.println("Queue is full");
            return;
        }
        if(end == -1) {
           start = 0;
           end = 0;
        }else
            end = (end+1)%size;
        arr[end] = data;
        currSize++;
    }

    public int pop() {
        if(currSize == 0) {
            System.out.println("Queue is empty");
            return -1;
        }
        int val = arr[start];
        if(currSize == 1) {
            start = -1;
            end = -1;
        } else
            start = (start + 1) % size;
        currSize--;
        return val;
    }

    public int peek() {
        if(currSize == 0) {
            System.out.println("Queue is empty");
            return -1;
        }
        return arr[start];
    }

    public int getSize() {
        return currSize;
    }

    public static void main(String[] args) {
        Impl_Queue_Using_Arr q = new Impl_Queue_Using_Arr(4);
        q.push(1);
        q.push(2);
        q.push(3);
        q.pop();
        q.push(4);
        q.push(5);
        System.out.println(currSize);
        while(!q.isEmpty()) {
            System.out.print(q.pop()+" ");
        }
    }
}