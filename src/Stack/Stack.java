package Stack;

import java.util.NoSuchElementException;

public class Stack {

    private Node top;
    private static int size = 0;

    public static class Node {
        int data;
        Node next;
        public Node(int data) {
            this.data = data;
        }
    }

    public Stack() {
        this.top = null;
    }

    public void push(int data) {
        Node newNode = new Node(data);
        newNode.next = top;
        top = newNode;
        size++;
        System.out.println("new node " + data + " is added to the stack");
        System.out.println("new size of the stack is, " + size);
    }

    public void pop() {
        if (this.isEmpty()) {
            throw new NoSuchElementException("Stack is empty");
        }
        int data = top.data;
        top = top.next;
        size--;
        System.out.println(data + " is removed");
        System.out.println("new size of the stack is, " + size);
    }

    public void showTop() {
        if (this.isEmpty()) {
            throw new NoSuchElementException("Stack is empty");
        }
        System.out.println("top element of the stack is, " + top.data);
    }

    public boolean isEmpty() {
        if(top==null)
            return true;
        return false;
    }

    public void print(){
        Node iterator = top;
        while (iterator!=null){
            System.out.print(iterator.data + " ");
            iterator = iterator.next;
        }
        System.out.println();
    }

        public void reverse() {
            Stack reversedStack = new Stack();
            while (!this.isEmpty()) {
                reversedStack.push(this.top.data);
                this.pop();
            }
            this.top = reversedStack.top;
            System.out.println("the stack is reversed");
        }


    public static void main(String[] args) {
        Stack stack = new Stack();


        stack.push(5);
        stack.push(1);
        stack.push(8);
        stack.push(2);
        stack.push(3);
        stack.push(9);

        stack.showTop();

        stack.print();

        stack.pop();
        stack.print();

        stack.reverse();
        stack.print();

    }
}
