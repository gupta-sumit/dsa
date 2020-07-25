package dsa.dp;

public class RodCutting {


    /*

    length   | 1   2   3   4   5   6   7   8  
    --------------------------------------------
    price    | 1   5   8   9  10  17  17  20

    */

    public int cutRods(int [] prices, int size) {
        int dp [] = new int[prices.length + 1];
        dp[0] = 0;
        dp[1] = 1;
        for(int i = 2; i <= size; i++) {
            int max = Integer.MIN_VALUE;
            for(int j=1; j <= i; j++) {
                int val = prices[j-1] + dp[i-j];
                if(val > max) {
                    max = val;
                }
            }
            dp[i] = max;
        }
        return dp[size];
    }
    

    public static void main(String[] args) {
        int p [] = new int[] {1,5,8,9,10,17,17,20};
        RodCutting rodCutting = new RodCutting();
        System.out.println(rodCutting.cutRods(p,4));
    }
}