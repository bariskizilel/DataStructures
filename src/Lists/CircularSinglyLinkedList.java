package Lists;

public class CircularSinglyLinkedList {

    private static Node head;
    private static int size = 0;

    public static class Node {
        int value;
        Node next;

        Node(int value) {
            this.value = value;
        }
    }

    public static void add(int value) {
        Node newNode = new Node(value);
        if (head == null) {
            head = newNode;
            newNode.next = head;
        } else {
            Node iterator = head;
            while (iterator.next != head) {
                iterator = iterator.next;
            }
            iterator.next = newNode;
            newNode.next = head;
        }
        size++;
        System.out.println("Element " + value + " is added");
        System.out.println("new size of the circular linked list: " + size);
    }

    public static void remove(int data) {
        if (head == null) {
            System.out.println("List is empty");
            return;
        }

        Node iterator = head;

        if (head.value == data) {
            // Special case: removing head
            if (head.next == head) {
                // Only one element
                head = null;
            } else {
                // More than one element
                while (iterator.next != head) {
                    iterator = iterator.next;
                }
                head = head.next;
                iterator.next = head;
            }
            System.out.println("Element " + data + " is removed");
            size--;
            System.out.println("new size of the circular linked list: " + size);
            return;
        }

        do {
            Node nextNode = iterator.next;

            if (nextNode.value == data) {
                iterator.next = nextNode.next;
                System.out.println("Element " + data + " is removed");
                size--;
                System.out.println("new size of the circular linked list: " + size);
                return;
            }

            iterator = nextNode;
        } while (iterator != head);


        System.out.println("Element " + data + " is not found");
    }
    public static void print(){
        Node iterator = head;

        while (iterator.next != head) {
            System.out.print(iterator.value + " ");
            iterator = iterator.next;
        }
        System.out.println();

    }

    public static void main(String[] args) {
        CircularSinglyLinkedList.add(5);
        CircularSinglyLinkedList.add(2);
        CircularSinglyLinkedList.add(3);
        CircularSinglyLinkedList.add(7);
        CircularSinglyLinkedList.add(6);

        CircularSinglyLinkedList.print();

        CircularSinglyLinkedList.remove(3);

        CircularSinglyLinkedList.print();



    }
}

