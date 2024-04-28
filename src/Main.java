public class Main {
    public static void main(String[] args) {
        MyMinHeap<Integer> myMinHeap = new MyMinHeap<>();

        myMinHeap.insert(136345);
        myMinHeap.insert(111);
        myMinHeap.insert(3);
        myMinHeap.insert(4);
        myMinHeap.insert(5);
        myMinHeap.insert(1);
        myMinHeap.insert(7);

        myMinHeap.print();
        myMinHeap.set(1,164);
        myMinHeap.print();
        myMinHeap.heapify(1     );
        myMinHeap.print();

//       System.out.print( myLinkedList.exists(-2));
//        Object[] arr = myArrayList.toArray()
//
//        myArrayList.print();
//        myArrayList.clear();
//        myArrayList.print();
//        myArrayList.add(1);
//        myArrayList.add(2);
//        myArrayList.add(3);
//        myArrayList.print();
//        myArrayList.add(4);
//        myArrayList.add(5);

//        System.out.println("Value of index 3: " + myArrayList.get(3));
//        System.out.println("Size of an list: " + myArrayList.size());
//        System.out.println("Value of index 0 before remove: " + myArrayList.get(0));
//        myArrayList.print();
//        myArrayList.removeFirst();
//        System.out.println("Vaule of index 0 after remove: " + myArrayList.get(0));
//        myArrayList.print();
//        System.out.println("Size of an list: " + myArrayList.size());
//        System.out.println("Vaule of index 2 before remove: " + myArrayList.get(2));
//        myArrayList.print();
//        myArrayList.remove(2);
//        System.out.println("Vaule of index 2 after remove: " + myArrayList.get(2));
//        myArrayList.print();
//        System.out.println("Size of an list: " + myArrayList.size());
//        myArrayList.print();
//        myArrayList.removeLast();
//        myArrayList.print();
    }
}