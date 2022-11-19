import java.util.ArrayList;
import java.util.Objects;

public class Stack<T> implements Iterable<T> {
    private final ArrayList<T> arrayList;

    public Stack(ArrayList<T> arrayList) {
        this.arrayList = arrayList;
    }

    public int size() {
        return arrayList.size();
    }

    public boolean isEmpty() {
        return arrayList.isEmpty();
    }

    public String toString() {
        return "Stack{" +
                "arrayList=" + arrayList +
                '}';
    }

    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Stack<?> stack = (Stack<?>) o;
        return Objects.equals(arrayList, stack.arrayList);
    }

    interface Iterator<T>{
        T currentIcon();
        boolean isDone();
        void next();// for deck + previous
    }
}
