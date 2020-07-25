package algo.bitmanipulation;

public class BitManipulations {

    public static void main(String[] args) {
        System.out.println(leftShift(Integer.MIN_VALUE));
    }

    private static int leftShift(int n) {
        return n << 1;
    }
}
