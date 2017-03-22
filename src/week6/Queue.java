package week6;

import java.util.ArrayList;

/**
 * Created by Tim H on 22-3-2017.
 * A simple FIFO Queue built upon a private ArrayList
 */
public class Queue<E> {
    private ArrayList<E> q;

    public Queue() {
        q = new ArrayList<E>();
    }

    //Adds an element to the queue at the back
    public void enqueue(E element) {
        q.add(element);
    }

    //Passes element and removes it from the queue
    public E dequeue() {
        return (q.isEmpty()) ? null : q.remove(0);
    }

    //Passes element and keeps it enqueued
    public E getFront() {
        return q.get(0);
    }

    public boolean isEmpty() {
        return q.isEmpty();
    }
}
