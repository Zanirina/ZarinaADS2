import java.util.Iterator;

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


    @Override
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
    public void set(int index, T item) {
        checkCapacity(index);
        MyNode current = head;
        for (int i = 0; i < index; i++) {
            current = current.next;
        }
        current.element = item;

    }

    @Override
    public void add(int index, T item) {
        checkCapacity(index);
        MyNode newNode = new MyNode(item);
        if (index == 0){
            newNode.next = head;
            head.prev = newNode;
            head = newNode;
        }
        else if(index == size){
            tail.next = newNode;
            newNode.prev = tail;
            tail = newNode;
        }
        else {
            MyNode current = head;
            for(int i = 0; i<index-1; i++){
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
    public void addFirst(T item) {
        add(0, item);
    }

    @Override
    public void addLast(T item) {
        add(item);
    }

    @Override
    public T get(int index) {
        checkCapacity();
        MyNode current = head;
        for (int i = 0; i<index; i++){
            current = current.next;
        }
        return (T) current.element;
    }

    @Override
    public T getFirst() {
        return (T) head.element;
    }

    @Override
    public T getLast() {
        return (T) tail.element;
    }

    @Override
    public void remove(int index) {
        checkCapacity((index));
        if(index == 0){
            head = head.prev;
            head.prev = null;
        }
        else if(index == size-1){
            tail = tail.prev;
            tail.next = null;
        }
        else {
            MyNode current = head;
            for(int i =0; i< index; i++){
                current.prev.next =current.next;
                current.next.prev =current.prev;
            }
        }
        size;
        }
    }

    @Override
    public void removeFirst() {
        remove(0);
        size--;
    }

    @Override
    public void removeLast() {
        remove(size - 1);
        size--;
    }

    @Override
    public void sort() {
        for (MyNode i = head; i != null; i = i.next) {
            for (MyNode j = i.next; j != null; j = j.next) {
                if (((Comparable)j.element).compareTo(i.element) < 0) {
                    Object current = i.element;
                    i.element = j.element;
                    j.element = current;
                }
            }
        }

    }

    @Override
    public int indexOf(Object object) {
        return 0;
    }

    @Override
    public int lastIndexOf(Object object) {
        return 0;
    }

    @Override
    public boolean exists(Object object) {
        return false;
    }

    @Override
    public Object[] toArray() {
        return new Object[0];
    }

    @Override
    public void clear() {

    }

    @Override
    public int size() {
        return size;
    }

    @Override
    public Iterator<T> iterator() {
        return null;
    }
}
