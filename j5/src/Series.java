import java.io.File;
import java.io.FileWriter;
import java.io.IOException;

public abstract class Series {
    protected double firstElement;
    protected double de;
    protected double numOfElements;

    Series(double f, double d, int n) {
        firstElement = f;
        de = d;
        numOfElements = n;
    }

    public abstract double getElement(int i);

    public double sum() {
        double sum = 0;
        for (int i = 1; i <= numOfElements; i++) {
            sum += getElement(i);
        }
        return sum;
    }

    public String toString() {
        StringBuilder s = new StringBuilder();
        for (int i = 1; i <= numOfElements; i++) {
            s.append(getElement(i));
            s.append(" ");
        }
        return s.toString();
    }

    public void save(File file) throws IOException {
        FileWriter fw = new FileWriter(file);
        String s = toString();
        fw.write(s, 0, s.length());
        fw.write('\n');
        fw.write("Sum is " + sum());
        fw.close();
    }
}