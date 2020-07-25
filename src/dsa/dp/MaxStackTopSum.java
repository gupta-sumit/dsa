package algo.dp;

import java.util.HashMap;
import java.util.Map;

public class MaxStackTopSum {

    public static void main(String[] args) {
        int [][] stacks = new int[][] {{2,23,4,5},{1,10,15,10},{1,10,15,100}};
        System.out.println(maxSum(stacks,5,0,new HashMap<>()));
    }

    private static int maxSum(int  [][] stacks, int n, int i, Map<Integer,Integer> memo) {
        if(n == 0) {
            int sum = 0;
            for(int k=i; k < stacks.length; k++) {
                sum = sum + stacks[k][0];
            }
            return sum;
        }
        if(i >= stacks.length) {
            return 0;
        }
        if(i == stacks.length-1) {
            if(n >= stacks[i].length) {
                return 0;
            } else {
                return stacks[i][n];
            }
        }
        int max = Integer.MIN_VALUE;
        for(int k=0; k<= n; k++) {
            int top = 0;
            if(k <= stacks[i].length-1) {
                top = stacks[i][k];
            }
            int v = top + maxSum(stacks, n-k,i+1,memo);
            if(v > max) {
               max = v;
            }
        }
        memo.put(i,max);
        return max;
    }

}
