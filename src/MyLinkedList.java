import javax.naming.directory.NoSuchAttributeException;
import java.util.Iterator;

public class MyLinkedList<T extends Comparable<T>> implements MyList<T>{
    @Override
    public Iterator<T> iterator() {
        return null;
    }

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

    public void set(int index, T item){
        MyNode<T> newNode = new MyNode<>(item);
        checkIndex(index);
        if (index == 0) {
            newNode.next = head.next;
            if(head==tail) tail = newNode;
            head = newNode;
        }
        else {
            MyNode<T> currentNode = head;
            for (int i = 0; i < index; i++) {
                if (i==index-1) {
                    MyNode<T> temp = currentNode.next.next;
                    currentNode.next = newNode;
                    newNode.prev=currentNode;
                    newNode.next = temp;
                    temp.prev=currentNode;
                    return;
                }
                currentNode = currentNode.next;
            }
        }
    }

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

    public void addFirst(T item){
        MyNode<T> newNode = new MyNode<>(item);
        if(head == null){
            head = newNode;
            tail = newNode;
        }
        newNode.next=head;
        head.prev = newNode;
        head=newNode;
    }

    public void addLast(T item){
        MyNode<T> newNode = new MyNode<>(item);
        if(head == null){
            head = newNode;
            tail = newNode;
        }
        tail.next = newNode;
        newNode.prev = tail;
        tail = newNode;
    }

    public T get(int index){
        checkIndex(index);
        MyNode<T> currentNode = head;
        for (int i = 0; i < index; i++) {
            currentNode = currentNode.next;
        }
        return currentNode.data;
    }

    public T getFirst(){
        checkIndex(0);
        return head.data;
    }

    public T getLast(){
        checkIndex(0);
        return tail.data;
    }

    public void remove(int index){
        checkIndex(index);
        MyNode<T> currentNode = head;
        for (int i = 0; i < index; i++) {
            currentNode = currentNode.next;
        }
        currentNode.prev.next=currentNode.next;
    }

    public void removeFirst(){
        checkIndex(0);
        head.next.prev=null;
        head=head.next;
    }

    public void removeLast(){
        checkIndex(0);
        tail.prev.next=null;
        tail=tail.prev;
    }

    public void sort(){
        MyNode<T> currentNode = tail;
        while(currentNode.prev!=null){
            MyNode<T> currentNode1 = currentNode;
            while(currentNode1.prev != null){
                if( currentNode1.data.compareTo(currentNode.data) > 0 ) {
                    T temp = currentNode.data;
                    currentNode.data = currentNode1.data;
                    currentNode1.data = temp;
                }
                currentNode1=currentNode1.prev;
            }
        }
    }

    @Override
    public int indexOf(Object object) {
        MyNode<T> currentNode = head;
        int index = size -1;
        while(currentNode.next!=null){
            if(object == currentNode.data) {
                return index;
            }
            index--;
            currentNode = currentNode.next;
        }
        return -1;
    }

    @Override
    public int lastIndexOf(Object object) {
        MyNode<T> currentNode = tail;
        int index = size -1;
        while(currentNode.prev!=null){
            if(object == currentNode.data) {
                return index;
            }
            index--;
            currentNode = currentNode.prev;
        }
        return -1;
    }

    @Override
    public boolean exists(Object object) {
        if(lastIndexOf(object)==-1) return false;
        else return true;
    }

    @Override
    public Object[] toArray() {
        T[] newArr = (T[]) new Object[size-1];
        MyNode<T> currentNode = head;
        int index = 0;
        while(currentNode.next!=null){
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
    }

    @Override
    public int size() {
        return size;
    }
}
