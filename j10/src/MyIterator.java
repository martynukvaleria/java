public class MyIterator<T> implements Iterator<T> {
    private final Deque<T> deque;
    private int current;

    MyIterator(Deque<T> deque) {
        this.deque = deque;
        current = 0;
    }


    @Override
    public void first() {
        current = 0;
    }

    @Override
    public void last() {
        current = deque.size() - 1;
    }

    @Override
    public void next() {
        current++;
    }

    @Override
    public void previous() {
        current--;
    }

    @Override
    public boolean isDoneFirst() {
        return current < 0;
    }

    @Override
    public boolean isDoneLast() {
        return current >= deque.size();
    }
    @Override
    public T currentItem() throws IndexOutOfBoundsException {
        if (isDoneLast() || isDoneFirst()) {
            throw new IndexOutOfBoundsException();
        }
        return deque.get(current);
    }

}
