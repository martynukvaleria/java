import javax.swing.*;
import java.util.ArrayList;
import java.util.Objects;

public class Deque<T> implements Iterable<T> {
    private final ArrayList<T> data;

    public static <T> Deque<T> create() {
        return new Deque<>();
    }

    Deque() {
        data = new ArrayList<>();
    }

    public int size() {
        return data.size();
    }

    public boolean isEmpty() {
        return data.isEmpty();
    }

    public void clear() {
        data.clear();
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Deque<?> deque = (Deque<?>) o;
        for (Object element : deque.data) {
            if (!data.contains(element)) {
                return false;
            }
        }
        return true;
    }

    @Override
    public int hashCode() {
        return Objects.hash(data);
    }

    @Override
    public String toString() {
        return "Deque{" +
                data +
                '}';
    }
    public boolean add(T element) {
        if (!data.contains(element)) {
            data.add(element);
            return true;
        }
        return false;
    }

    public ListModel<T> getListModel() {
        DefaultListModel<T> model = new DefaultListModel<>();
        for (T element : data) {
            model.addElement(element);
        }
        return model;
    }

    public T front() {
        MyIterator<T> iterator = new MyIterator<>(this);
        if (data.isEmpty()) {
            throw new IndexOutOfBoundsException("your deque doesn't have first element");
        }
        iterator.last();
        while (iterator.isDoneFirst()){
            iterator.previous();
        }
        return iterator.currentItem();
    }

    public T back() {
        MyIterator<T> iterator = new MyIterator<>(this);
        if (data.isEmpty()) {
            throw new IndexOutOfBoundsException("your deque doesn't have last element");
        }
        while (iterator.isDoneLast()){
            iterator.next();
        }
        return iterator.currentItem();
    }

    public void pushFront(T element) {
        try {
            data.add(0, element);
        } catch (NumberFormatException exception) {
            throw new NumberFormatException("Input String cannot be parsed to Integer");
        }
    }

    public void pushBack(T element) {
        try {
            data.add(data.size() , element);
        } catch (NumberFormatException exception) {
            throw new NumberFormatException("Input String cannot be parsed to Integer");
        }
    }

    public void popFront() {
        if (data.isEmpty()) {
            throw new IndexOutOfBoundsException("your deque doesn't have first element");
        }
        data.remove(0);
    }

    public void popBack() {
        if (data.isEmpty()) {
            throw new IndexOutOfBoundsException("your deque doesn't have last element");
        }
        data.remove(data.size() - 1);
    }

    public T get(int index) {
        return data.get(index);
    }

    @Override
    public Iterator<T> createIterator() {
        return new MyIterator<>(this);
    }
}
