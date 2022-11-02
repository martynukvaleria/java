import java.io.File;
import java.io.IOException;

public class Main {
    public static void main(String[] args) {
        try {
            Series series;
            series = new Linear(1, 2, 20);
            File linearSeriesOutput = new File("../j5/s_1.txt");
            series.save(linearSeriesOutput);

            series = new Exponential(1, 2, 20);
            File exponentialSeriesOutput = new File("../j5/s_2.txt");
            series.save(exponentialSeriesOutput);
        } catch (IOException ioException) {
            System.out.println("File not found");
        } catch (IllegalArgumentException illegalArgumentException) {
            System.out.println("Illegal amount of elements");
        }

    }
}
