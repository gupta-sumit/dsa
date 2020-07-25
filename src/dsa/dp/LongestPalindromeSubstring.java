package algo.dp;

import algo.utils.ArrayUtils;
import algo.utils.ConsolePrinter;

import java.util.Arrays;

public class LongestPalindromeSubstring {

    public static void main(String[] args) {
        System.out.println(longestPalindrome("aaaa"));
    }

    public static String longestPalindrome(String s) {
        if(s == null || s.isEmpty()) {
            return "";
        }
        int [][] memo = new int[s.length()][s.length()];
        for(int i=0; i < s.length(); i++) {
            memo[i][i] = 1;
        }

        int maxLen = 1;
        String max = s.substring(0,1);

        for(int i=0; i < s.length()-1; i++) {
            if(s.charAt(i) == s.charAt(i+1)) {
                memo[i][i + 1] = 2;
            }
            if(memo[i][i+1] > maxLen) {
                maxLen = memo[i][i+1];
                max = s.substring(i,i+2);
            }
        }

        ArrayUtils.printMatrix(memo);
        ConsolePrinter.out("======");

        for(int j=2; j < s.length(); j++) {
            for(int i=0; i < j-1; i++) {
                ArrayUtils.printMatrix(memo);
                ConsolePrinter.out("======");
                if(s.charAt(i) == s.charAt(j) && memo[i+1][j-1] != 0) {
                    memo[i][j] = memo[i+1][j-1] + 2;
                } else {
                    memo[i][j] = 0;
                }
                if(memo[i][j] > maxLen) {
                    maxLen = memo[i][j];
                    max = s.substring(i,j+1);
                }
            }
        }
        ArrayUtils.printMatrix(memo);

        ConsolePrinter.out(maxLen);
        return max;
    }
}
