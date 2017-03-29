package exam;

import week1.Stack;

/**
 * Created by Tim H on 31/1/2017.
 */
public class SinglyLinkedList<Integer> {
    private Node head = null;

    public void addFront(int data) {
        Node newNode = new Node(data);
        newNode.setNext(head);
        head = newNode;
    }

    /**
     * Appends new data to the end of the list by updating the last node his pointer
     * @param data
     */
    public void append(int data) {
        Node newNode = new Node(data);
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

    public void removeLast() {
        if (head == null) {
            return;
        }
        Node current = head;
        while (current.getNext().getNext() != null) {
            current = current.getNext();
        }
        current.setNext(null);
    }

    public void removeEven() {
        int index = 1;
        Node node = head;
        Node prevUneven = head;
        while (node != null) {
            Node originalDest = node.getNext();
            if (index % 2 == 0) {
                //Data is even
                System.out.println("Even node");
                node = null;
            } else {
                prevUneven.setNext(node);
                prevUneven = node;
            }
            index++;
            node = originalDest;
        }
    }

    public void add(int index, int data) {
        Node newNode = new Node(data);
        if (head == null) {
            this.head = newNode;
            return;
        }

        Node current = head;
        for (int i = 0; i < index; i++) {
            if (i + 1 == index) {
                Node temp = current.getNext();
                current.setNext(newNode);
                newNode.setNext(temp);
                break;
            }

            if (current.getNext() == null) {
                current.setNext(newNode);
                break;
            }

            current = current.getNext();
        }
    }

    public void reverse() {
        //Empty and single node lists are useless for this operation
        if (head == null || head.getNext() == null)
            return;

        Stack<Node> reverse = new Stack<Node>();
        Node current = head;
        while(current != null) {
            System.out.print(current.data);
            reverse.push(current);
            if (current.getNext() == null)
                break;
            current = current.getNext();
        }
        System.out.println(" <-- in stack");
        this.head = reverse.pop();
        current = head;
        Node currentPop = reverse.pop();
        while(currentPop != null) {
            current.setNext(new Node(currentPop.data));     //Set last pop as new SLL node
            current = current.getNext();                    //Go to the new last node of the SLL structure (to insert new node in the next iteration)
            currentPop = reverse.pop();                     //Take the TOS for this iteration
        }
    }

    public String toString() {

        String result = "";

        for (Node current = head; current != null; current = current.next) {
            result = result + current.toString() + " ";
        }
        return result;
    }

    private class Node {
        private int data;
        private Node next;

        public Node(int data) {
            this.data = data;
        }

        public Node getNext() {
            return next;
        }

        public void setNext(Node next) {
            this.next = next;
        }

        public String toString() {
                return data + "";
        }
    }
}