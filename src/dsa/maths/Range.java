package algo.numbers;

public class Range {

    public final int start;
    public final int end;

    public Range(int start, int end) {
        if(start < 0 || start > end) {
            throw new IllegalArgumentException("Invalid range");
        }
        this.start = start;
        this.end = end;
    }

    @Override
    public String toString() {
        return "Range{" +
                "start=" + start +
                ", end=" + end +
                '}';
    }
}
