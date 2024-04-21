public class MyQueue<T extends Comparable<T>> {
    MyArrayList<T> queue = new MyArrayList<>();

    public MyQueue() {

    }

    public T peek() {    // Return the front element of the queue without removing it
        return queue.get(0);
    }

    public T dequeue() {    // Remove and return the front element of the queue
        T item = queue.get(0);
        queue.remove(0);
        return item;
    }

    public void enqueue(T item) {    // Add an element to the rear of the queue
        queue.add(item);
    }

    public boolean empty() {    // Check if the queue is empty
        return queue.size() == 0;
    }

    public int Size() {    // Get the current size of the queue
        return queue.size();
    }



}
