import java.util.ArrayList;
import java.util.EmptyStackException;

public class GenericStack<E> {
    private ArrayList<E> elements;
    public GenericStack() {
        elements = new ArrayList<>();
    }
    public void push(E item) {
        elements.add(item);
    }
    public E pop() {
        if(isEmpty()) throw new EmptyStackException();
        return elements.remove(elements.size()-1);
    }
    public E peek() {
        if(isEmpty()) throw new EmptyStackException();
        return elements.get(elements.size()-1);
    }
    public boolean isEmpty(){
        return elements.isEmpty();
    }
    public int size(){
        return elements.size();
    }

}
