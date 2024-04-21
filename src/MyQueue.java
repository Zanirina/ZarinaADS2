public class MyQueue<T extends Comparable<T>> {
    MyArrayList<T> queue = new MyArrayList<>();

    public MyQueue() {

    }

    public T peek() {
        return queue.get(0);
    }

    public T dequeue() {
        T item = queue.get(0);
        queue.remove(0);
        return item;
    }

    public void enqueue(T item) {
        queue.add(item);
    }

    public boolean empty() {
        return queue.size() == 0;
    }

    public int Size() {
        return queue.size();
    }



}
