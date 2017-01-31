package week1;

/**
 * Created by Tim H on 31/1/2017.
 */
public class SinglyLinkedList<E> {
    private Node head = null;

    public void addFront(E data) {
        Node newNode = new Node<E>(data);
        newNode.setNext(head);
        head = newNode;
    }

    /**
     * Appends new data to the end of the list by updating the last node his pointer
     * @param data
     */
    public void append(E data) {
        Node newNode = new Node<E>(data);
        newNode.setNext(null);
        if (head == null) {
            this.head = newNode;
        } else {
            Node current = head;
            while (current.getNext() != null) {
                current = current.getNext();
            }
            current.setNext(newNode);
        }
    }

    public String toString() {

        String result = "";

        for (Node current = head; current != null; current = current.next) {
            result = result + current.toString() + "";
        }
        return result;
    }

    private class Node<T> {
        private T data;
        private Node next;

        public Node(T data) {
            this.data = data;
        }

        public Node getNext() {
            return next;
        }

        public void setNext(Node next) {
            this.next = next;
        }

        public String toString() {
            {
                return data + "";
            }
        }
    }
}