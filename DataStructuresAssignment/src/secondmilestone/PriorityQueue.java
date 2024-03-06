package secondmilestone;

import java.util.*;

public class PriorityQueue<T extends Comparable<T>> {
    private List<T> elements;

    // constructor to initialize the priority queue as an empty list
    public PriorityQueue() {
        elements = new LinkedList<>();
    }

    // method to add an element to the priority queue
    public void add(T element) {
        elements.add(element);
        elements.sort(null); // sorting the elements to maintain the priority order
    }

    // method to retrieve and remove the highest-priority element from the queue
    public T poll() {
        if (elements.isEmpty()) {
            throw new NoSuchElementException("Priority queue is empty.");
        }
        return elements.remove(0); // removing and returning the highest-priority element
    }

    // method to check if the priority queue is empty
    public boolean isEmpty() {
        return elements.isEmpty();
    }
}
