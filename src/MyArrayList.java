import java.util.Iterator;
import java.util.NoSuchElementException;

public class MyArrayList<T extends Comparable<T>> implements MyList<T>{
    private T[] arr;
    private int size;

    public MyArrayList() {
        arr = (T[]) new Object[5];
        size = 0;
    }

    public void set(int index, Object item){
        checkIndex(index);
        arr[index] = (T) item;
    }

    public void add(T element) {
        if(size>=arr.length)
            increaseBuffer();
        arr[size++] = (T) element;
    }

    @Override
    public void set(int index, T item) {

    }

    public void add(int index, T element) {
        if(size>=arr.length)
            increaseBuffer();
        checkIndex(index);
        arr[index] = element;
    }

    @Override
    public void addFirst(T item) {

    }

    public void addFirst(Object item){
        if(size>=arr.length)
            increaseBuffer();
        for(int i = size; i >= 0; i--){
            arr[i] = arr[i-1];
        }
        arr[0] = (T) item;
        size++;
    }
    public void addLast(T item){
        add(item);
    }

    private void increaseBuffer() {
        T[] newArr = (T[]) new Object[arr.length*2];
        for (int i = 0; i < arr.length; i++) {
            newArr[i] = arr[i];  //copy each element from old to new
        }
        arr = newArr; //change reference of arr from old memory location to new
    }

    public T get(int index){
        checkIndex(index);
        return arr[index];
    }

    public T getFirst(){
        return arr[0];
    }

    public T getLast(){
        return arr[size-1];
    }

    private void checkIndex(int index) {
        if(index < 0 || index >= size)
            throw new IndexOutOfBoundsException("index not correct");
    }

    public int size(){
        return size;
    }

    public void printArr(){
        for (int i = 0; i < size; i++) {
            System.out.print(arr[i] + " ");
        }
    }

    public void remove(int index) {
        checkIndex(index);
        for (int i = index + 1; i < size; i++) {
            arr[i-1] = arr[i];
        }
        size--;
    }

    public void removeFirst(){
        remove(0);
    }

    public void removeLast(){
        remove(size-1);
    }

    public void sort(){
        for (int i = size-1; i>=0; i--){
            for (int j=i; j>=0; j--){
                if(arr[j].compareTo(arr[i]) > 0){
                    T temp = arr[j];
                    arr[j]=arr[i];
                    arr[i]=temp;
                    break;
                }
            }
        }
    }

    public int indexOf(Object item){
        for(int i=0; i < size; i++)
            if(arr[i]==item) return i;
        throw new NoSuchElementException("there is no such object");
    }

    public int lastIndexOf(Object item){
        int result = -1;
        for(int i=0; i < size; i++)
            if(arr[i]==item) result = i;
        if(result==-1) throw new NoSuchElementException("there is no such object");
        return result;
    }

    public boolean exists(Object item){
        for(int i=0; i < size; i++)
            if(arr[i]==item) return true;
        return false;
    }

    public Object[] toArray(){
        return (T[]) arr;
    }

    public void clear() {
        arr =  (T[]) new Object[5];
        size = 0;
    }

    @Override
    public Iterator<T> iterator() {
        return null;
    }
}
