package com.example.challenges.stack;

public class Stack {
    private long arr[];
    private int index = 0;

    public Stack() {
        arr = new long[10];
    }

    public void push(Long i) {
        if (index < 10) {
            arr[index] = i;
            index++;
        } else {
            System.out.println("Stack is full, Cannot push!");
        }
    }

    public Long pop() {
        if(index > 0) {
            index--;
            return arr[index];
        }
        return null;
    }

    public static void main(String[] args) {
        Stack stack = new Stack();
        stack.push(1L);
        stack.push(2L);
        System.out.println(stack.pop());
        System.out.println(stack.pop());
        System.out.println(stack.pop());

        stack.push(1L);
        stack.push(2L);
        stack.push(3L);
        stack.push(4L);
        stack.push(5L);
        stack.push(6L);
        stack.push(7L);
        stack.push(8L);
        stack.push(9L);
        stack.push(10L);
        stack.push(11L); // should print it wasn't pushed
        System.out.println(stack.pop());
        stack.push(10L);
        stack.push(11L); // should print it wasn't pushed
    }
}
