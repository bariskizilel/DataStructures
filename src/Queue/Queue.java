package Queue;

import Stack.Stack;

public class Queue {

    static class Node {
        int value;
        Node next;
        public Node(int value) {
            this.value = value;
        }
    }

    Node front, rear;
    void enqueue(int data) {
        Node temp = new Node(data);

        if(this.rear == null) {
            this.front = this.rear = temp;
            return;
        }
        this.rear.next = temp;
        this.rear = temp;
    }

    void dequeue() {
        if (front==null){
            System.out.println("there is no element in the queue");
        }  else if (front.next == null){
            System.out.println("first element " + front.value + " is removed from the queue");
            front = null;
        } else {
            System.out.println("first element " + front.value + " is removed from the queue");
            front = front.next;
        }
    }

    void reverse() {
        Stack stack = new Stack();
        while (front != null) {
            stack.push(front.value);
            front = front.next;
        }
        rear = null;

        while (!stack.isEmpty()) {
            this.enqueue(stack.top.data);
            stack.pop();
        }
    }

    void print(){
        Node iterator = front;

        if(iterator == null){
            System.out.println("there is no element in the queue");
            return;
        }
        while (iterator!=null){
            System.out.print(iterator.value + " ");
            iterator = iterator.next;
        }
        System.out.println();
    }

    public static void main(String[] args) {
        Queue queue = new Queue();

        queue.enqueue(9);
        queue.enqueue(3);
        queue.enqueue(2);
        queue.enqueue(1);
        queue.enqueue(8);

        queue.print();

        queue.dequeue();
        queue.dequeue();

        queue.print();
        queue.reverse();
        queue.print();
    }

}
