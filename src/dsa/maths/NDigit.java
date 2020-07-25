package algo.numbers;

public class NDigit {

    public static void main(String[] args) {
        // 153 // 3*10  + 5 + 35*10 + 1 : 351
        int k = 300;
        int n = k;
        int factor = 1;
        int dg = 1;
        int num = 0;
        int digitCount = 0;
        while(true) {
            int p = n - factor*9*dg;
            if(p <= 0) {
                break;
            } else {
                num = num + factor*9;
                digitCount = digitCount + factor*9*dg;
                n = p;
                factor *= 10;
                dg++;
            }
        }
        int remainingNum = (int)Math.ceil((double)n/dg);
        int actualNum = num + remainingNum;
        int totalDigitsTillNow = digitCount + remainingNum*dg;
        int start = totalDigitsTillNow - dg + 1;
        int index = k - start;
        System.out.println(String.valueOf(actualNum).charAt(index));
    }


}
