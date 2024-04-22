public class MyArrayList<T> {
    private T[] arr;
    private int size;

    public MyArrayList() {
        arr = (T[]) new Object[5];
        size = 0;
    }

    public void set(int index, T item){
        checkIndex(index);
        arr[index] = item;
    }
    public void add(T element) {
        if(size>=arr.length)
            increaseBuffer();
        arr[size++] = element;
    }

    public void add(T element, int index) {
        if(size>=arr.length)
            increaseBuffer();
        checkIndex(index);
        arr[index] = element;
    }

    void addFirst(T item){
        if(size>=arr.length+1)
            increaseBuffer();


    }
    void addLast(T item);

    private void increaseBuffer() {
        T[] newArr = (T[]) new Object[arr.length*2];
        for (int i = 0; i < arr.length; i++) {
            newArr[i] = arr[i];  //copy each element from old to new
        }
        arr = newArr; //change reference of arr from old memory location to new
    }

    public T getElement(int index){
        checkIndex(index);
        return arr[index];
    }

    private void checkIndex(int index) {
        if(index < 0 || index >= size)
            throw new IndexOutOfBoundsException("index not correct");
    }

    public int getSize(){
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

    public void clear() {
        arr =  (T[]) new Object[5];
        size = 0;
    }
}
