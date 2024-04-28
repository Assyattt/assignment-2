import java.util.NoSuchElementException;

public class Stack<T extends Comparable<T>> extends MyLinkedList<T> {
    public Stack(){
        super();
    }
    public boolean empty(){
        return iterator().hasNext();
    }
    public T peek(){
        if(!empty()) return getLast();
        throw new NoSuchElementException("Queue is empty");
    }
    public T push(T item){
        add(item);
        return item;
    }
    public T pop(){
        T frontItem = peek();
        removeLast();
        return frontItem;
    }
}
