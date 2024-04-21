import java.util.Iterator;
import java.util.NoSuchElementException;

public class MyLinkedList<T> implements MyList<T> {

    class MyNode<E> {
        E element;
        MyNode next;
        MyNode prev;

        public MyNode() {
            element = null;
            next = null;
            prev = null;
        }

        public MyNode(E element) {
            this.element = element;
            next = null;
            prev = null;
        }
    }

    private MyNode head;
    private MyNode tail;
    private int size;

    public MyLinkedList() {
        head = null;
        tail = null;
        size = 0;
    }

    private void checkCapacity(int index) {
        if (index < 0 || index >= size) {
            throw new IndexOutOfBoundsException("Index: " + index + ", Size:" + size);
        }
    }


    @Override     // Add an element to the end of the linked list
    public void add(T item) {
        MyNode newNode = new MyNode(item);
        if (head == null) {
            head = newNode;
            tail = newNode;
        } else {
            tail.next = newNode;
            newNode.prev = tail;
            tail = newNode;
        }
        size++;

    }

    @Override
    public void set(int index, T item) {    // Set an element at a specific index
        checkCapacity(index);
        MyNode current = head;
        for (int i = 0; i < index; i++) {
            current = current.next;
        }
        current.element = item;

    }

    @Override
    public void add(int index, T item) {    // Add an element at a specific index
        checkCapacity(index);
        MyNode newNode = new MyNode(item);
        if (index == 0) {
            newNode.next = head;
            head.prev = newNode;
            head = newNode;
        } else if (index == size) {
            tail.next = newNode;
            newNode.prev = tail;
            tail = newNode;
        } else {
            MyNode current = head;
            for (int i = 0; i < index - 1; i++) {
                current = current.next;
            }
            newNode.next = current.next;
            newNode.prev = current;
            current.next.prev = newNode;
            current.next = newNode;
        }
        size++;
    }

    @Override
    public void addFirst(T item) {    // Add an element at the beginning of the linked list
        add(0, item);
    }

    @Override
    public void addLast(T item) {    // Add an element at the end of the linked list
        add(item);
    }

    @Override
    public T get(int index) {    // Get an element at a specific index
        checkCapacity(index);
        MyNode current = head;
        for (int i = 0; i < index; i++) {
            current = current.next;
        }
        return (T) current.element;
    }

    @Override
    public T getFirst() {    // Get the first element of the linked list
        return (T) head.element;
    }

    @Override
    public T getLast() {     // Get the last element of the linked list
        return (T) tail.element;
    }

    @Override
    public void remove(int index) {    // Remove an element at a specific index
        checkCapacity((index));
        if (index == 0) {
            head = head.prev;
            head.prev = null;
        } else if (index == size - 1) {
            tail = tail.prev;
            tail.next = null;
        } else {
            MyNode current = head;
            for (int i = 0; i < index; i++) {
                current = current.next;
            }
            current.prev.next = current.next;
            current.next.prev = current.prev;
        }
        size--;
    }

    @Override
    public void removeFirst() {       // Remove the first element of the linked list
        remove(0);
    }

    @Override
    public void removeLast() {    // Remove the last element of the linked list
        remove(size - 1);
    }

    @Override
    public void sort() {    // Sort the linked list using bubble sort
        for (MyNode i = head; i != null; i = i.next) {
            for (MyNode j = i.next; j != null; j = j.next) {
                if (((Comparable) j.element).compareTo(i.element) < 0) {
                    Object current = i.element;
                    i.element = j.element;
                    j.element = current;
                }
            }
        }

    }

    @Override
    public int indexOf(Object object) {    // Find the index of the first occurrence of an object
        MyNode current = head;

        for (int i = 0; i < size; i++) {
            if (current.element.equals(object)) {
                return i;
            }
            current = current.next;
        }
        return -1;
    }

    @Override
    public int lastIndexOf(Object object) {    // Find the index of the last occurrence of an object
        MyNode current = tail;
        for (int i = size - 1; i >= 0; i--) {
            if (current.element.equals(object)) {
                return i;
            }
            current = current.prev;
        }
        return -1;

    }

    @Override
    public boolean exists(Object object) {    // Check if an object exists in the linked list
        return indexOf(object) != -1;
    }

    @Override
    public Object[] toArray() {     // Convert the linked list to an Object array
        Object[] arr = new Object[size];
        MyNode current = head;
        for (int i = 0; i < size; i++) {
            arr[i] = current.element;
            current = current.next;
        }
        return arr;
    }

    @Override
    public void clear() {    // Clear the linked list
        head = null;
        tail = null;
        size = 0;

    }

    @Override
    public int size() {    // Get the current size of the linked list
        return size;
    }

    @Override
    public Iterator<T> iterator() {// Return an iterator for the linked list
        return new MyIterator();
    }

    public class MyIterator implements Iterator<T> {        // Inner class for iterator implementation
        private MyNode current = head;
        private int index = 0;

        @Override
        public boolean hasNext() {        // Check if there is a next element
            return index < size;
        }

        @Override
        public T next() {        // Get the next element
            if (hasNext() != true) {
                throw new NoSuchElementException();
            }
            T element = (T) current.element;
            current = current.next;
            index++;
            return element;
        }
    }

}
