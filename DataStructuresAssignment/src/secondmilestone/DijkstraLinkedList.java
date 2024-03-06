package secondmilestone;

import java.util.*;

public class DijkstraLinkedList<T> {
    private Node<T> head;
    private Node<T> tail;

    public void add(T element) {
        Node<T> newNode = new Node<>(element);
        if (head == null) {
            head = newNode;
            tail = newNode;
        } else {
            tail.setNext(newNode);
            tail = newNode;
        }
    }

    public boolean isEmpty() {
        return head == null;
    }

    public T removeFirst() {
        if (head == null) {
            throw new NoSuchElementException("Linked list is empty.");
        }
        Node<T> firstNode = head;
        head = head.getNext();
        if (head == null) {
            tail = null;
        }
        return firstNode.getData();
    }

    private static class Node<T> {
        private T data;
        private Node<T> next;

        public Node(T data) {
            this.data = data;
        }

        public T getData() {
            return data;
        }

        public Node<T> getNext() {
            return next;
        }

        public void setNext(Node<T> next) {
            this.next = next;
        }
    }
}
