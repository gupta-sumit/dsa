package algo.dp;

import algo.utils.ConsolePrinter;

public class LongestCommonSubstring {

    public static void main(String[] args) {
    // hihowareyou
    // warey
        ConsolePrinter.out(longestCommonSubstring("hihowareyou", "ware"));
    }

    public static String longestCommonSubstring(String s1,String s2) {
        if(null == s1 || s2 == null) {
            return "";
        }
        if(s1.isEmpty() || s2.isEmpty()) {
            return "";
        }
        int dp [][] = new int[s1.length()][s2.length()];

        IndexPair [][] indexes = new IndexPair[s1.length()][s2.length()];
        int maxLen = 0;
        String max = "";
        int m = -1;
        int n = -1;
        for(int i=0; i < s1.length(); i++) {
            for(int j=0; j < s2.length(); j++) {
                if(s1.charAt(i) == s2.charAt(j)) {
                    if(i-1 >= 0 && j-1 >= 0) {
                        dp[i][j] = dp[i-1][j-1] + 1;
                        if(dp[i-1][j-1] != 0) {
                            indexes[i][j] = new IndexPair(indexes[i-1][j-1].i,i);
                        } else {
                            indexes[i][j] = new IndexPair(i,i);
                        }
                    } else {
                        dp[i][j] = 1;
                        indexes[i][j] = new IndexPair(i,i);
                    }

                } else {
                    dp[i][j] = 0;
                }
                if(dp[i][j] > maxLen) {
                    maxLen = dp[i][j];
                    m = i;
                    n = j;
                }
            }
        }
        if(maxLen > 0) {
            ConsolePrinter.out("Max Length " + maxLen);
            return s1.substring(indexes[m][n].i,indexes[m][n].j+1);
        }
        return "";
    }

    public static class IndexPair {
        public final int i;
        public final int j;

        public IndexPair(int i, int j) {
            this.i = i;
            this.j = j;
        }
    }
}
