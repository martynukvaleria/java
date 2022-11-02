public class Number implements Comparable<Number>{
    int number;
    public Number(int number) {
        this.number = number;
    }

    public int compareTo(Number number_) {
        if (number != number_.number) {
            return number - number_.number;
        }
        return 0;
    }

    public String toString() {
        return "number : " + number;
    }
}
