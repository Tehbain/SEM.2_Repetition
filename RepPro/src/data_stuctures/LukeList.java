package data_stuctures;

import java.util.Iterator;
import java.util.NoSuchElementException;

public class LukeList<E extends Comparable> implements ADTList<E> {
    private final Node<E> head = new Node<>(null); //Indeholder ikke noget og er bare
    private final Node<E> tail = new Node<>(null);//til for at pege frem og tilbage
    private int size = 0;

    public LukeList() {
        head.next = tail;
        tail.prev = head;
    }

    @Override
    public void add(E e) {
        Node<E> newNode = new Node<>(e);
            //Indsætter newNode mellem tail.prev og tail
        newNode.prev = tail.prev;
        newNode.next = tail;
        tail.prev.next = newNode;
        tail.prev = newNode;
        size++;
    }

    @Override
    public boolean remove(E e) {
        return true;
    }

    @Override
    public boolean contains(E e) {
        boolean isFound = false;

        Node current = head.next;
        if (current == head || current == tail) {
            return isFound = false;
        }

        for (int i = 0; i < size; i++) {
            if (current.element == e) {
                isFound = true;
            } else {
                current = current.next;
            }
        }
        return isFound;
    }

    @Override
    public void clear() {
        head.next = tail;
        tail.prev = head;
    }

    @Override
    public int size() {
        return size;
    }

    @Override
    public boolean isEmpty() {
        return head.next == tail;
    }

    // Alt med index kan også løses rekursivt med Divide & Conquer.
    @Override
    public E get(int index) {

        if (index > size) throw new IndexOutOfBoundsException();

        E toGet = null;
        Node current = head.next;
        for (int i = 0; i < index; i++) {
            if (i < index) current = current.next;
            else toGet = (E) current.element;
        }
        return toGet;
    }

    @Override
    public void add(int index, E e) {

        if (index > size) throw new IndexOutOfBoundsException();

        Node toAdd = new Node<>(e);
        Node current = head.next;

        for (int i = 0; i < index; i++) {
            if (i < index) {
                current = current.next;
                current.prev.next = current;
            }
            else {
                Node prev = current.prev;
                Node next = current.next;


            }
        }

    }

    @Override
    public E remove(int index) {
        return null;
    }

    @Override
    public int indexOf(E e) {
        return 0;
    }

    @Override
    public Iterator<E> iterator() {
        return new ListIterator();
    }

    private static class Node<T> {
        private final T element;
        private Node<T> next;
        private Node<T> prev;

        public Node(T element) {
            this.element = element;
            this.next = null;
            this.prev = null;
        }
    }

    private class ListIterator implements Iterator<E> {
        private Node<E> current = head.next; // Første element
        private int index = 0;

        @Override
        public boolean hasNext() {
            return current != tail.prev;
        }

        @Override
        public E next() {
            if (!hasNext()) {
                throw new NoSuchElementException();
            }
            E element = current.element;
            current = current.next;
            index++;
            return element;
        }

        @Override
        public void remove() {
            if (current == head || current == tail) {
                throw new IllegalStateException("Illegal attempt to remove head or tail.");
            }
            //Nye henvisninger forbi current
            Node<E> prev = current.prev;
            Node<E> next = current.next;
            //Lapper hullet
            prev.next = next;
            next.prev = prev;
            //Glemmer current
            current.prev = null;
            current.next = null;
            current = next;

            index--;
            size--;
        }

        public int getIndex() {
            return this.index;
        }
    }
}


