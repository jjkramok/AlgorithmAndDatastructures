package week1;

/**
 * Created by Tim H on 31/1/2017.
 */
public class SinglyLinkedList<E> {
    private Node head = null;

    public void addFront(E data) {
        Node newNode = new Node(data);
        newNode.setNext(head);
        head = newNode;
    }

    /**
     * Appends new data to the end of the list by updating the last node his pointer
     * @param data
     */
    public void append(E data) {
        Node newNode = new Node(data);
        newNode.setNext(null);
        Node last = head;
        while(last != null) {
            if (last.getNext() == null) {
                last.setNext(newNode);
                break;
            }
        }
    }

    public String toString() {

        String result = "";

        for (Node current = head; current != null; current = current.next) {
            result = result + current.toString() + "";
        }
        return result;
    }

    private class Node<E> {
        private E data;
        private Node next;

        public Node(E data) {
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