package algo.numbers;

public class PowerOfTwo {

    public static void main(String[] args) {
        System.out.println(isPowerOfTwo(-64));
    }

    public static boolean isPowerOfTwo(int num) {
        if(num == 0) {
            return false;
        }
        return (num & (num-1)) == 0;
    }
}
