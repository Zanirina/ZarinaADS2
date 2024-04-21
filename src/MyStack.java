
public class MyStack<T> {
    private MyLinkedList<T> stack = new MyLinkedList<>();

    public MyStack() {

    }

    public T peek() {    // Return the top element of the stack without removing it
        return (T) stack.getLast();
    }

    public T pop() {    // Remove and return the top element of the stack
        T item = stack.getLast();
        stack.removeLast();
        return item;
    }

    public void push(T item) {    // Add an element to the top of the stack
        stack.addLast(item);
    }

    public boolean empty() {    // Check if the stack is empty
        return stack.size() == 0;
    }

    public int Size() {    // Get the current size of the stack
        return stack.size();
    }

}
