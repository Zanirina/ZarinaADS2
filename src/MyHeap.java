public class MyHeap<T extends Comparable<T>> {

    MyArrayList<T> heap = new MyArrayList<>();

    public MyHeap() {

    }
    public void empty() {
        heap.clear();
    }
    public int Size() {
        return heap.size();
    }

    public T getMax() {
        return heap.get(0);
    }
    public T extractMax() {
        T max = heap.get(0);
        swap(0, heap.size() - 1);
        heap.remove(heap.size() - 1);
        heapify(0);
        return max;
    }
    public void insert(T item) {
        heap.add(item);
        int i = heap.size() - 1;
        heapify(i);
    }

    private void heapify(int i) {
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
    private void traverse(int i) {
        if (i < heap.size()) {
            System.out.println(heap.get(i));
            traverse(leftChildOf(i));
            traverse(rightChildOf(i));
        }
    }

    private int leftChildOf(int i) {
        return 2 * i;
    }

    private int rightChildOf(int i) {
        return 2 * i + 1;
    }

    private int parentOf(int i) {
        return i / 2;
    }

    private void swap(int i, int j) {
        T temp = heap.get(i);
        heap.set(j, temp);
    }

    

   

   
    
}