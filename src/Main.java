import java.util.ArrayList;

public class Main {
    public static void main(String[] args) {
        //ArrayList<String> myList= new ArrayList<>();

        MyArrayList<Integer> myList = new MyArrayList<>();

        myList.add(1);
        myList.add(2);
        myList.add(3);
        myList.add(4);
        myList.add(5);
        myList.add(6);
        myList.add(7);

        myList.add(3,20);
        myList.addFirst(99);

        myList.addLast(101);
        for (int i = 0; i<myList.size();i++){
            System.out.println(myList.get(i));
        }

    }
}