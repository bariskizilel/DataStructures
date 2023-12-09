package Lists;



class DoublyLinkedList {


    private static Node head;
    private static Node tail;
    private static int size = 0;

    public static class Node {

        int value;
        Node next;
        Node prev;

        Node(int value) {
            this.value = value;
        }
    }



    public static void add(int value) {
        Node newNode = new Node(value);
        newNode.value = value;

        if (head == null) {
            head = newNode;
            tail = newNode;
        } else {
            tail.next = newNode;
            newNode.prev = tail;
            tail = newNode;
        }
        size++;
        System.out.println("Element " + value + " is added");
        System.out.println("new size of the linked list: " + size);
    }

    public static void remove(int data){
        Node iterator = head;

        while (iterator != null && iterator.value != data) {
            iterator = iterator.next;
        }

        if (iterator == null) {
            System.out.println("Element " + data +"is not found");
            return;
        }

        if (iterator == head) {
            head = head.next;
            if (head != null) {
                head.prev = null;
            } else {
                tail = null;
            }
        }

        else if (iterator == tail) {
            tail = tail.prev;
            if (tail != null) {
                tail.next = null;
            }
        }

        else {
            iterator.prev.next = iterator.next;
            if (iterator.next != null) {
                iterator.next.prev = iterator.prev;
            }
        }
        size--;

        System.out.println("Element " + data + " is removed");
        System.out.println("new size of the linked list: " + size);


    }



    public static void print(){
        Node iterator = head;
        while (iterator != null) {
            System.out.print(iterator.value + " ");
            iterator = iterator.next;
        }
        System.out.println();

    }

    public static void reverse() {
        Node temp = null;
        Node iterator = head;

        while (iterator != null) {
            temp = iterator.prev;
            iterator.prev = iterator.next;
            iterator.next = temp;
            iterator = iterator.prev;
        }

        if (temp != null) {
            head = temp.prev;
        }

        System.out.println("the list is reversed");
    }

    public static void main(String[] args) {


        DoublyLinkedList.add(5);
        DoublyLinkedList.add(7);
        DoublyLinkedList.add(6);
        DoublyLinkedList.add(3);
        DoublyLinkedList.add(1);
        DoublyLinkedList.add(4);
        DoublyLinkedList.add(2);

        DoublyLinkedList.print();

        DoublyLinkedList.remove(6);

        DoublyLinkedList.print();

        DoublyLinkedList.reverse();

        DoublyLinkedList.print();



    }
}


