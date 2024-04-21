import java.util.Iterator;

public class MyArrayList<T extends Comparable<T>> implements MyList<T> {


    private static Object[] arr;
    private int length = 0;
    private static final int DEFAULT_CAPACITY = 10;

    public MyArrayList(int initialCapacity) {
        arr = new Object[initialCapacity];
    }

    public MyArrayList() {
        this(DEFAULT_CAPACITY);
        length = 0;

    }

    public static void increaseCapacity() {
        Object[] temp = new Object[arr.length * 2];

        for (int i = 0; i < arr.length; i++) {
            temp[i] = arr[i];
        }
        arr = temp;


    }

    private void checkCapacity(int index) {    // Method to increase the capacity of the array
        if (index < 0 || index >= length) {
            throw new IndexOutOfBoundsException(index);
        }
    }

    @Override
    public void add(T item) {// Add an element to the end of the array
        if (length == arr.length) {
            increaseCapacity();
        }

        Object[] temp = new Object[length + 1];
        for (int i = 0; i < length; i++) {
            temp[i] = arr[i];
        }
        temp[length] = item;
        length++;
        arr = temp;

    }

    @Override
    public void set(int index, T item) { // Set an element at a specific index
        checkCapacity(index);
        arr[index] = item;

    }

    @Override
    public void add(int index, T item) {// Add an element at a specific index
        checkCapacity(index);
        if (length == arr.length) {
            increaseCapacity();
        }

        Object[] temp = new Object[length + 1];
        for (int i = 0; i < index; i++) {
            temp[i] = arr[i];
        }


        temp[index] = item;
        for (int i = index + 1; i < length + 1; i++) {
            temp[i] = arr[i - 1];
        }
        length++;
        arr = temp;

    }

    @Override
    public void addFirst(T item) {// Add an element at the beginning of the array
        add(0, item);

    }

    @Override
    public void addLast(T item) {    // Add an element at the end of the array
        add(item);

    }

    @Override
    public T get(int index) {// Get an element at a specific index
        checkCapacity(index);
        return (T) arr[index];
    }

    @Override // Get the first element of the array
    public T getFirst() {
        return get(0);
    }

    @Override   // Get the last element of the array
    public T getLast() {
        return get(length - 1);
    }

    @Override
    public void remove(int index) {// Remove an element at a specific index
        checkCapacity(index);
        Object[] temp = new Object[length - 1];
        for (int i = 0; i < index; i++) {
            temp[i] = arr[i];

        }
        for (int i = index; i < length - 1; i++) {
            temp[i] = arr[i + 1];
        }
        length--;
        arr = temp;

    }

    @Override
    // Remove the first element of the array
    public void removeFirst() {
        remove(0);
    }

    @Override
    // Remove the last element of the array
    public void removeLast() {
        remove(length - 1);
    }

    @Override
    public void sort() {    // Sort the array using bubble sort
        for (int i = 0; i < length; i++) {
            for (int j = i + 1; j < length - 1 - i; j++)
                if (((Comparable) arr[j]).compareTo(arr[j + 1]) > 0) {
                    Object temp = arr[j + 1];
                    arr[j + 1] = arr[j];
                    arr[j] = temp;
                }
        }

    }

    @Override
    public int indexOf(Object object) {     // Find the index of the first occurrence of an object
        for (int i = 0; i < length; i++) {
            if (arr[i].equals(object)) {
                return i;
            }
        }
        return -1;
    }

    @Override
    public int lastIndexOf(Object object) {// Find the index of the last occurrence of an object
        for (int i = length - 1; i >= 0; i--) {
            if (arr[i].equals(object)) {
                return i;
            }
        }
        return -1;
    }

    @Override
    public boolean exists(Object object) {// Check if an object exists in the array
        if (indexOf(object) != -1) {
            return true;
        }
        return false;
    }
    // Convert the array to an Object array
    @Override
    public Object[] toArray() {
        return arr;
    }

    // Clear the array by resetting its size to default
    @Override
    public void clear() {
        Object[] temp = new Object[DEFAULT_CAPACITY];
        arr = temp;

    }

    // Get the current size of the array
    @Override
    public int size() {
        return length;
    }

    @Override    // Return an iterator for the array
    public Iterator<T> iterator() {
        return new MYIterator();
    }
    // Inner class for iterator implementation
    public class MYIterator implements Iterator<T> {
        private int index = 0;

        @Override  // Check if there is a next element
        public boolean hasNext() {
            return index < length;
        }

        @Override // Get the next element
        public T next() {
            return (T) arr[index++];
        }
    }
}