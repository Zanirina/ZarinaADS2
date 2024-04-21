
public class MyStack<T> {
    private MyLinkedList<T> stack = new MyLinkedList<>();

    public MyStack() {

    }

    public T peek() {
        return (T) stack.getLast();
    }

    public T pop() {
        T item = stack.getLast();
        stack.removeLast();
        return item;
    }

    public void push(T item) {
        stack.addLast(item);
    }

    public boolean empty() {
        return stack.size() == 0;
    }

    public int Size() {
        return stack.size();
    }

}
