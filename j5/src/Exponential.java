public class Exponential extends Series {
    public Exponential(double f, double d, int n) {
        super(f, d, n);
        if (n < 0) {
            throw new IllegalArgumentException();
        }
    }

    @Override
    public double getElement(int i) {
        return (firstElement * Math.pow(de, (i - 1)));
    }
}
