package dsa.maths;

public class SuperUglyNumber {


    // 1 2 3 4

    // 

    public int getNthSuperUglyNumber(int n, int [] primeNumbers) {
        int [] ugly = new int[n];
        ugly[0] = 1;
        int [][] multipleAndIndexes = new int[primeNumbers.length][3];
        for(int i=0; i < primeNumbers.length; i++) {
            multipleAndIndexes[i][0] = 0;
            multipleAndIndexes[i][1] = primeNumbers[i];
            multipleAndIndexes[i][2] = primeNumbers[i];

        }
        int k = 1;
        while(k < n) {
            int nextMultiple = min(multipleAndIndexes);
            ugly[k] = nextMultiple;
            for(int i=0; i < multipleAndIndexes.length; i++) {
                if(nextMultiple == multipleAndIndexes[i][1]) {
                    multipleAndIndexes[i][0] = multipleAndIndexes[i][0] + 1;
                    multipleAndIndexes[i][1] = ugly[multipleAndIndexes[i][0]]*multipleAndIndexes[i][2];
                }
            }
            k++;
        }
        return ugly[n-1];
    }

    public int min(int [][] multipleAndIndexes) {
        int min = multipleAndIndexes[0][1];
        for(int i=1; i < multipleAndIndexes.length; i++) {
            if(min > multipleAndIndexes[i][1]) {
                min = multipleAndIndexes[i][1];
            }
        }
        return min;
    }


    public static void main(String[] args) {
        SuperUglyNumber superUglyNumber = new SuperUglyNumber();
        System.out.println(superUglyNumber.getNthSuperUglyNumber(10, new int[]{2,3,5,11,13}));       
    }
    
}