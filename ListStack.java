import java.util.*;

public class ListStack <E> {
    private List<E> theData;

    public ListStack() {
        theData = new ArrayList<>();
    }

    public E push(E obj) {
        theData.add(obj);
        return obj;
    }

    public E peek() {
        if (isEmpty()) {
            throw new NoSuchElementException();
        }
        return theData.get(theData.size() - 1);
    }

    public E pop() {
        if (isEmpty()) {
            throw new NoSuchElementException();
        }
        return theData.remove(theData.size() - 1);
    }

    public boolean isEmpty() {
        return theData.isEmpty();
    }
}
