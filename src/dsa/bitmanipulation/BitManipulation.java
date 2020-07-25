package dsa.bitmanipulation;

public class BitManipulation {

    public void rightShift(int number, int count) {
        while(count > 0) {
            number = number >> 1;
            count--;
        }
        System.out.println(number);
    }


    // 00001010
    // 00001000
    public boolean getBit(int num, int i) {
        return (num & (1 << i)) != 0;
    }

    // 
    public int setBit(int num, int i) {
        return num | (1 << i);
    }

    public int clearBit(int num, int i) {
        return num & ~(1 << i);
    }

    public int insertBits(int num1, int num2, int i, int j) {
        int mask = ((~(1 << (j + 1))) << i);
        return num1 | (num2 & mask);
    }

    public int countBits(int num1, int num2) {
        int n = num1 ^ num2;
        int count = 0;
        while(n > 0) {
            if((n & 1) == 1) {
                count++;
            }
            n = n >> 1;
        }
        return count;
    }


     // 01100101
     // 00010011
     // 00100011
    //  00001100
     // 00000011

     // 
    // 1000 1101
    // 00001010
    // 00000101

    public int swapBits(int num) {
        int mask = 3;
        int out = 0;
        int count = 0;
        while(num > 0) {
            int n = mask & num;
            if(n == mask) {
                out = mask << count;
            } else if(n != 0) {
                out = out | (((mask ^ num)  & mask) << count);
            }
            count = count + 2;
            num = num >> 2;
        }
        return out;
    }





    public static void main(String[] args) {
        BitManipulation bitManipulation = new BitManipulation();
        bitManipulation.rightShift(-10, 10);
        System.out.println(bitManipulation.getBit(11, 1));
        System.out.println(bitManipulation.setBit(11, 2));
        System.out.println(bitManipulation.clearBit(15, 2));

        System.out.println(bitManipulation.countBits(29,  15));

        
        System.out.println(bitManipulation.swapBits(10));
    }
    
}