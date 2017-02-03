package week1;

/**
 * Created by Tim H on 31/1/2017.
 */
public class Stack<T> {
    private Node tos = null; //top of stack

    public void push(T data) {
        this.tos = new Node(data, this.tos);
    }

    public T pop() {
        T tosData = null;
        if (this.tos != null) {
            tosData = this.tos.data;
            this.tos = this.tos.next;
        }
        return tosData;
    }

    public T getTos() {
        return this.tos.data;
    }

    public boolean isEmpty() {
        if (tos == null) {
            return true;
        }
        return false;
    }

    public void print() {
        Node current = this.tos;
        while(current != null) {
            System.out.print(current.data);
            current = current.next;
        }
        System.out.println();
    }

    private class Node {
        private T data;
        private Node next;

        public Node(T data, Node next) {
            this.data = data;
            this.next = next;
        }
    }
}
