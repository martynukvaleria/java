
public interface Iterator<T> {
    void first();
    void last();

    void next();
    void previous();

    boolean isDoneFirst();
    boolean isDoneLast();

    T currentItem() throws IndexOutOfBoundsException;

}
