package implementations;

import interfaces.AbstractQueue;

import java.util.Iterator;

public class Queue<E> implements AbstractQueue<E> {

    private Node<E> head;
    private int size;

    private static class Node<E> {
        private E element;
        private Node<E> next;

        Node(E value) {
            this.element = value;
        }
    }

    public Queue() {
        this.head = null;
        this.size = 0;
    }

    @Override
    public void offer(E element) {
        Node<E> insert = new Node<>(element);
        if (isEmpty()) {
            this.head = insert;
            this.size++;
            return;
        }

        Node<E> current = this.head;
        while (current.next != null) {
            current = current.next;
        }

        current.next = insert;
        this.size++;
    }

    @Override
    public E poll() {
        ensureNotEmpty();
        Node<E> first = this.head;
        this.head = first.next;

        this.size--;
        return first.element;
    }

    @Override
    public E peek() {
        ensureNotEmpty();

        return this.head.element;
    }

    @Override
    public int size() {
        return this.size;
    }

    @Override
    public boolean isEmpty() {
        return this.size == 0;
    }

    @Override
    public Iterator<E> iterator() {

        return new Iterator<E>() {

            private Node<E> current = head;

            @Override
            public boolean hasNext() {
                return current != null;
            }

            @Override
            public E next() {

                E value = this.current.element;

                this.current = this.current.next;

                return value;
            }
        };
    }

    private void ensureNotEmpty() {
        if (isEmpty()) {
            throw new IllegalStateException();
        }
    }
}
