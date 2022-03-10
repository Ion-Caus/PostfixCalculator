package DataStructures;

import Exceptions.EmptyListException;

public class LinkedList<T> implements List<T> {
    private Node<T> head;
    private int size;

    public LinkedList() {
        this.head = null;
        this.size = 0;
    }

    @Override
    public boolean isEmpty() {
        return head == null;
    }

    @Override
    public int size() {
        return this.size;
    }

    @Override
    public void addToFront(T data) {
        Node<T> newNode = new Node<>(data);
        newNode.setNext(head);
        head = newNode;
        size++;
    }

    @Override
    public T removeFirst() throws EmptyListException {
        if (this.size() == 0)
            throw new EmptyListException("The list is empty.");

        Node<T> first = head;
        head = head.getNext();
        size--;
        return first.getData();
    }
}
