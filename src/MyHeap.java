public class MyHeap<T extends Comparable<T>> {

    MyArrayList<T> heap = new MyArrayList<>();

    public MyHeap() {

    }
    public void empty() {    // Clear the heap
        heap.clear();
    }
    public int Size() {    // Get the current size of the heap
        return heap.size();
    }

    public T getMax() {    // Get the maximum element of the min heap (root element)
        return heap.get(0);
    }
    public T extractMax() {    // Extract the maximum element from the min heap (root element)
        T max = heap.get(0);
        swap(0, heap.size() - 1);
        heap.remove(heap.size() - 1);
        heapify(0);
        return max;
    }
    public void insert(T item) {    // Insert a new element into the min heap
        heap.add(item);
        int i = heap.size() - 1;
        heapify(i);
    }

    private void heapify(int i) {    // Heapify the heap starting from index i
        int left = leftChildOf(i);
        int right = rightChildOf(i);
        int theLargest = i;

        if (left < heap.size() && heap.get(left).compareTo(heap.get(theLargest)) < 0) {
            theLargest = left;
        }
        if (right < heap.size() && heap.get(right).compareTo(heap.get(theLargest)) < 0) {
            theLargest = right;
        }
        if (theLargest != i) {
            swap(i, theLargest);
            heapify(theLargest);
        }
    }
    private void traverse(int i) {    // Traverse the heap in pre-order
        if (i < heap.size()) {
            System.out.println(heap.get(i));
            traverse(leftChildOf(i));
            traverse(rightChildOf(i));
        }
    }

    private int leftChildOf(int i) {    // Calculate the index of the left child of node at index i
        return 2 * i;
    }

    private int rightChildOf(int i) {    // Calculate the index of the right child of node at index i
        return 2 * i + 1;
    }

    private int parentOf(int i) {    // Calculate the index of the parent of node at index i
        return i / 2;
    }

    private void swap(int i, int j) {    // Swap two elements in the heap
        T temp = heap.get(i);
        heap.set(j, temp);
    }

    

   

   
    
}