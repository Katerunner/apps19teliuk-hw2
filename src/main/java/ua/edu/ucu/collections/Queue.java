package ua.edu.ucu.collections;

import ua.edu.ucu.collections.immutable.ImmutableLinkedList;

public class Queue {

    private ImmutableLinkedList list;

    public Queue() {
        this.list = new ImmutableLinkedList();
    }

    public void enqueue(Object i) {
        list = list.addLast(i);
    }

    public Object peek() {
        return list.getFirst();
    }

    public Object dequeue() {
        Object item = list.getFirst();
        list = list.removeFirst();
        return item;
    }

    public boolean isEmpty() {
        return list.size() == 0;
    }
}
