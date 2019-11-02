package ua.edu.ucu.collections;

import ua.edu.ucu.collections.immutable.ImmutableLinkedList;

public class Stack {

    private ImmutableLinkedList list;

    public Stack() {
        this.list = new ImmutableLinkedList();
    }

    public void push(Object i) {
        list = list.addFirst(i);
    }

    public Object peek() {
        return list.getFirst();
    }

    public Object pop() {
        Object item = list.getFirst();
        list = list.removeFirst();
        return item;
    }
    public boolean isEmpty(){
        return list.size() == 0;
    }
}
