import java.util.Iterator;

public class MyLinkedList<T extends Comparable<T>> implements MyList<T>{

    private class MyNode<T> {
        T data;
        MyNode<T> next;
        MyNode<T> prev;

        public MyNode(T data) {
            this.data = data;
            next = null;
            prev = null;
        }
    }
    private MyNode<T> head;
    private MyNode<T> tail;
    private int size;

    public MyLinkedList(){
        head = null;
        tail = null;
        size = 0;
    }

    @Override
    public Iterator<T> iterator(){
        return new MyIterator();
    }

    private class MyIterator implements Iterator<T>{
        MyNode<T> cursor = head;
        @Override
        public boolean hasNext(){
            return cursor.next != null;
        }
        @Override
        public T next(){
            T nextItem = cursor.data;
            cursor = cursor.next;
            return nextItem;
        }
    }

    @Override
    public void set(int index, T item) {
        checkIndex(index);
        if (index == 0) {
            head.data = (T) item;
        }
        else {
            MyNode<T> currentNode = head;
            for (int i = 0; i < index; i++) {
                currentNode = currentNode.next;
            }
            currentNode.data = (T) item;
        }
    }

    public void add(T item){
        MyNode<T> newNode = new MyNode<>(item);
        if(head == null){
            head = newNode;
            tail = newNode;
        }
        else{
            tail.next = newNode;
            newNode.prev=tail;
            tail= newNode;

        }
        size++;
    }

    private void checkIndex(int index) {
        if (index < 0 || index >= size)
            throw new IndexOutOfBoundsException("index not correct");
    }

    @Override
    public void add(int index, T item){
        MyNode<T> newNode= new MyNode<>(item);
        checkIndex(index);
        if (index == 0){
            addFirst(item);
        } else {
            MyNode<T> currentNode = head;
            for (int i = 0; i < index; i++) {
                if (i==index-1) {
                    MyNode<T> temp = currentNode.next;
                    currentNode.next = newNode;
                    newNode.prev = currentNode;
                    newNode.next = temp;
                    temp.prev = newNode;
                    size++;
                    return;
                }
                currentNode = currentNode.next;
            }
        }
    }

    @Override
    public void addFirst(T item){
        MyNode<T> newNode = new MyNode<>(item);
        if(head == null){
            head = newNode;
            tail = newNode;
        }
        newNode.next=head;
        head.prev = newNode;
        head=newNode;
        size++;
    }

    @Override
    public void addLast(T item){
        add(item);
    }

    @Override
    public T get(int index){
        checkIndex(index);
        MyNode<T> currentNode = head;
        for (int i = 0; i < index; i++) {
            currentNode = currentNode.next;
        }
        return currentNode.data;
    }

    @Override
    public T getFirst(){
        checkIndex(0);
        return head.data;
    }

    @Override
    public T getLast(){
        checkIndex(0);
        return tail.data;
    }

    @Override
    public void remove(int index){
        checkIndex(index);
        if(index == 0){
            removeFirst();
            return;
        }
        MyNode<T> currentNode = head;
        for (int i = 0; i < index-1; i++) {
            currentNode = currentNode.next;
        }
        currentNode.next = currentNode.next.next;
        currentNode.next.prev =currentNode;
        size--;
    }

    public void removeFirst(){
        checkIndex(0);
        head=head.next;
        head.prev=null;
        size--;
    }

    public void removeLast(){
        checkIndex(0);
        tail=tail.prev;
        tail.next = null;
        size--;
    }

    public void sort(){
        MyNode<T> currentNode = tail;
        while(currentNode != null){
            MyNode<T> currentNode1 = currentNode;
            while(currentNode1 != null){
                if(currentNode1.data.compareTo(currentNode.data) > 0 ) {
                    T temp = currentNode.data;
                    currentNode.data = currentNode1.data;
                    currentNode1.data = temp;
                }
                currentNode1=currentNode1.prev;
            }
            currentNode = currentNode.prev;
        }
    }

    @Override
    public int indexOf(Object object) {
        MyNode<T> currentNode = head;
        int index = 0;
        while(currentNode != null){
            if(currentNode.data.compareTo( (T) object) == 0) {
                return index;
            }
            index++;
            currentNode = currentNode.next;
        }
        return -1;
    }

    @Override
    public int lastIndexOf(Object object) {
        MyNode<T> currentNode = tail;
        int index = size -1;
        while(currentNode !=null){
            if(currentNode.data.compareTo( (T) object) == 0) {
                return index;
            }
            index--;
            currentNode = currentNode.prev;
        }
        return -1;
    }

    @Override
    public boolean exists(Object object) {
        return lastIndexOf(object) != -1;
    }

    @Override
    public T[] toArray() {
        T[] newArr = (T[]) new Comparable[size];
        MyNode<T> currentNode = head;
        int index = 0;
        while(currentNode!=null){
            newArr[index]= currentNode.data;
            index++;
            currentNode = currentNode.next;
        }
        return newArr;
    }

    @Override
    public void clear() {
        head = null;
        tail = null;
        size = 0;
    }

    @Override
    public int size() {
        return size;
    }

    @Override
    public void print(){
        MyNode<T> currentNode = head;
        while(currentNode.next != null){
            System.out.print(currentNode.data + " ");
            currentNode = currentNode.next;
        }
        System.out.print(currentNode.data + "\n");
    }
}
