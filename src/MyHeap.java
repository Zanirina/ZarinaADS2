public class MyHeap<T extends Comparable<T>> {

    MyArrayList<T> heap = new MyArrayList<>();
    public MyHeap(){

    }

    public void empty(){
        heap.clear();
    }

    public int size(){
        return heap.size();
    }

    public T getMax(){
        return heap.get(0);
    }







}

