public class Linear extends Series {
    public Linear(double f, double d, int n) {
        super(f, d, n);
        if (n < 0) {
            throw new IllegalArgumentException();
        }
    }

    @Override
    public double getElement(int i) {
        return (firstElement + (i - 1) * de);
    }
}
