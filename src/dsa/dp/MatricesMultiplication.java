package dsa.dp;

import java.util.HashMap;
import java.util.Map;

public class MatricesMultiplication {
    
    // A1A2A3A4A5A6

    // 

    public void getMinMultiplicationCost(int [] matricesSizes) {

        Map<String,Cost> memo = new HashMap<>();
        Cost cost = minCost(matricesSizes, 1, matricesSizes.length-1,memo);
        System.out.println(cost.min);
        System.out.println(printParenthesis(matricesSizes,memo,1,matricesSizes.length-1));
    }

    String printParenthesis(int [] p,  Map<String,Cost> memo, int i, int j) {
        if(i == j) {
         return "A" + i; 
        }
        String key = i + "_" + j;
        String m1 = printParenthesis(p, memo,i,memo.get(key).cutIndex);
        String m2 = printParenthesis(p, memo,memo.get(key).cutIndex + 1,j);
        return "(" + m1 + m2 + ")";
       
    
    }

    private Cost minCost(int [] p, int i, int j, Map<String, Cost> memo) {
        String key = i + "_" + j;
        if(memo.containsKey(key)) {
            return memo.get(key);
        }
        if(i >= j) {
            return new Cost(0,i);
        }
        int min = Integer.MAX_VALUE;
        int index = -1;
        for(int k = i; k < j; k++) {
             int c = minCost(p, i, k, memo).min + minCost(p, k+1, j, memo).min + p[i-1]*p[k]*p[j];
             if(c < min) {
                 min = c;
                 index = k;
             }

        }
        Cost c = new Cost(min, index);
        memo.put(key, c);
        return c;
    }

    private static class Cost {
        int min;
        int cutIndex;

        public Cost(int min, int index) {
            this.min = min;
            this.cutIndex = index;
        }
    }


    public static void main(String[] args) {
        int p [] = new int[]{10, 20,30, 40, 30};
        MatricesMultiplication matricesMultiplication = new MatricesMultiplication();
        matricesMultiplication.getMinMultiplicationCost(p);

        p = new int[]{40, 20, 30, 10, 30};

        matricesMultiplication.getMinMultiplicationCost(p);
    }
}