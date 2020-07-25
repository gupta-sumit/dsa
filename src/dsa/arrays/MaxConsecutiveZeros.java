package algo.array;

public class MaxConsecutiveZeros {

    public static void main(String[] args) {
        int a [] = new int [] {1,0,0,0,1,1,1,0,1,0};
        System.out.println(maxConsecutiveOne(1775));
    }

    public static int maxConsecutiveOne(int n) {
        System.out.println(" " + Integer.toBinaryString(n));
        if(n == 0) {
            return 1;
        }
        int lastOneCount = 0;
        int count = 0;
        int max = 0;
        while(n > 0) {
            if((int)(n & 1) ==  1) {
                count++;
            } else {
                if(lastOneCount != 0) {
                    count = count - lastOneCount;
                    lastOneCount = count + 1;
                } else {
                    lastOneCount = count;
                }
                count++;
            }
            if(max < count) {
                max = count;
            }
            n =  n >> 1;
        }
        return max;
    }


    public static int maxConsecutiveOnes(int a []) {

        // 01 1 0 1 1 0 1 1 0 1 1 1 1 1
        int max = 0;
        int consecutiveOnesBeforeLastZero = 0;
        int currentOnes = 0;

        for(int i=0; i < a.length; i++) {
            if(a[i] == 0 ) {
                if(consecutiveOnesBeforeLastZero != 0) {
                    currentOnes = currentOnes - consecutiveOnesBeforeLastZero;
                    consecutiveOnesBeforeLastZero = currentOnes + 1;
                } else {
                    consecutiveOnesBeforeLastZero = 1;
                }
                currentOnes = currentOnes + 1;
            } else {
                currentOnes++;
            }

            if(currentOnes > max) {
                max = currentOnes;
            }
        }
        return max;
    }
}
