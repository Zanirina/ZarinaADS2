import java.util.ArrayList;
import java.util.LinkedList;

public class Main {
    public static void main(String[] args) {
        MyArrayList<Integer> myList = new MyArrayList<>();
        MyLinkedList<Integer> myLink = new MyLinkedList<>();

    // for MyArraylist
        myList.add(1);
        myList.add(2);
        myList.add(3);
        printArray(myList);

        myList.set(1, 20);
        printArray(myList);

        myList.add(1, 10);
        printArray(myList);

        myList.addFirst(0);
        printArray(myList);

        myList.addLast(4);
        printArray(myList);


        System.out.println(myList.get(2));


        System.out.println(myList.getFirst());


        System.out.println(myList.getLast());


        myList.remove(2);
        printArray(myList);


        myList.removeFirst();
        printArray(myList);


        myList.removeLast();
        printArray(myList);


        System.out.println("Check sort");
        myList.sort();
        printArray(myList);


        System.out.println(myList.indexOf(20));


        System.out.println(myList.lastIndexOf(20));


        System.out.println(myList.exists(20));


        myList.clear();
        printArray(myList);

    // for MyLinkedList

        System.out.println(myList.size());
        myLink.add(1);
        myLink.add(2);
        myLink.add(3);
        printList(myLink);

        myLink.set(1, 20);
        printList(myLink);

        myLink.add(1, 10);
        printList(myLink);

        myLink.addFirst(0);
        printList(myLink);

        myLink.addLast(4);
        printList(myLink);

        System.out.println(myLink.get(2));

        System.out.println(myLink.getFirst());

        System.out.println(myLink.getLast());

        myLink.remove(2);
        printList(myLink);

        myLink.removeFirst();
        printList(myLink);

        myLink.removeLast();
        printList(myLink);

        System.out.println("Check sort");
        myLink.sort();
        printList(myLink);

        System.out.println(myLink.indexOf(20));

        System.out.println(myLink.lastIndexOf(20));

        System.out.println(myLink.exists(20));

        myLink.clear();
        printList(myLink);

        System.out.println(myLink.size());

    }

    public static void printArray(Iterable<Integer> arr) {
        for (Object object : arr) {
            System.out.print(object + " ");
        }
        System.out.println();
    }

    public static void printList(Iterable<Integer> list) {
        for (Object object : list) {
            System.out.print(object + " ");
        }
        System.out.println();
    }
}