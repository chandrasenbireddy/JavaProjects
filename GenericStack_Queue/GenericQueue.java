import java.util.EmptyStackException;
import java.util.LinkedList;
import java.util.NoSuchElementException;

public class GenericQueue<T> {
    private LinkedList<T> elements;

    public GenericQueue() {
        elements = new LinkedList<>();
    }
    public void enqueue(T item){
        elements.addLast(item);
    }
    public T dequeue(){
        if (isEmpty()) throw new NoSuchElementException();
        return elements.removeFirst();
    }
    public T peek() {
        if (isEmpty()) throw new NoSuchElementException();
        return elements.getFirst();
    }
    public boolean isEmpty(){
        return elements.isEmpty();
    }
    public int size(){
        return elements.size();
    }
    @Override
    public String toString(){
        String queue = "[ ";
        for (T e:
             elements) {
                  queue += e + " ";
        }
        queue += "]";
        return queue;
    }
}
