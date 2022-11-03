import java.awt.*;
import java.util.*;
import java.util.List;
public class MyLine {
    private List<Integer> xList;
    private List<Integer> yList;
    private Color color;

    public List<Integer> getXList() {
        return xList;
    }

    public void setXList(List<Integer> xList) {
        this.xList = xList;
    }

    public List<Integer> getYList() {
        return yList;
    }

    public void setYList(List<Integer> yList) {
        this.yList = yList;
    }

    public Color getColor() {
        return color;
    }

    public void setColor(Color color) {
        this.color = color;
    }

    public MyLine(Color c) {
        xList = new ArrayList<>();
        yList = new ArrayList<>();
        color = c;
    }

    public void addPoint(int x, int y) {
        xList.add(x);
        yList.add(y);
    }

    public void draw(Graphics g) {
        for (int i = 0; i < xList.size() - 1; i++) {
            g.setColor(color);
            g.drawLine(xList.get(i), yList.get(i), xList.get(i + 1), yList.get(i + 1));
        }
    }
}