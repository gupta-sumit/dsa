package dsa.maths;

public class PrimeTesing {

    public boolean isPrime(int number) {
        for(int i = 2; i*i <= number; i++ ) {
            if(number%i == 0) {
                return false;
            }
        }
        return true;
    }

    public static void main(String[] args) {
        PrimeTesing primeTesing = new PrimeTesing();
        System.out.println(primeTesing.isPrime(33));
    }

}