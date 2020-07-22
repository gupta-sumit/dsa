package dsa.maths;


public class UglyNumber {


    public int divide(int n, int d) {
        while(n%d == 0) {
            n = n/d;
        }
        return n;
    }

    public boolean isUglyNumber(int n) {
        n = divide(n, 2);
        n = divide(n, 3);
        n = divide(n, 5);
        return n == 1;
    }

    public int getNthUglyNumberBruteForce(int n) {
        if(n == 1) {
            return 1;
        }
        int k = 2;
        int count = 1;
        while(count < n) {
            if(isUglyNumber(k)) {
                count++;
            }
            k++;
        }
        return k-1;
    }

    public int min(int a, int b, int c) {
        if(a <= b) {
            if(a <= c) {
                return a;
            } else {
                return c;
            }
        } else if(b <= c) {
            return b;
        } else {
            return c;
        }
    }


    public int getNthUglyNumber(int n) {
        int uglyNumbers [] = new int[n];
        uglyNumbers[0] = 1;
        int k = 1;
        int i2 = 0;
        int i3 = 0;
        int i5 = 0;
        int nextMultipleOf2 = 2;
        int nextMultipleOf3 = 3;
        int nextMultipleOf5 = 5;

        while(k < n) {
            int nextMultiple = min(nextMultipleOf2, nextMultipleOf3,nextMultipleOf5);

            uglyNumbers[k] = nextMultiple;

            if(nextMultiple == nextMultipleOf2) {
                i2 = i2 + 1;
                nextMultipleOf2 = uglyNumbers[i2]*2;
            }
            
            if(nextMultiple == nextMultipleOf3) {
                
                i3 = i3 + 1;
                nextMultipleOf3 = uglyNumbers[i3]*3;
            } 
            
            if(nextMultiple == nextMultipleOf5) {
                i5 = i5 + 1;
                nextMultipleOf5 = uglyNumbers[i5]*5;
            }
            k++;
            //System.out.println(Arrays.toString(uglyNumbers));
        }
        return uglyNumbers[n-1];
    }

    public static void main(String[] args) {
        UglyNumber uglyNumber = new UglyNumber();
        int n = 1500;
        System.out.println(n + "th Ugly Number is " + uglyNumber.getNthUglyNumber(n));
    }
    
}