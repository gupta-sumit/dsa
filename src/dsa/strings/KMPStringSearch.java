package algo.strings;

import algo.utils.ArrayUtils;
import algo.utils.ConsolePrinter;

public class KMPStringSearch {

    public static void main(String[] args) {
        String text = "aabaababa";
        ArrayUtils.printArrayWithIndex(text.toCharArray());
        matchAllPattern(text,"aba");
    }

    // ababaca
    public static int [] computePrefix(String pattern) {
        int [] lp = new int[pattern.length()];
        int k=0;
        lp[0] = 0;
        for(int i=1; i < pattern.length(); i++) {
            while(k > 0 && pattern.charAt(k) != pattern.charAt(i)) {
                k = lp[k];
            }
            if(pattern.charAt(k) == pattern.charAt(i)) {
                k = k + 1;
            }
            lp[i] = k;
        }
        return lp;
    }

    public static void matchAllPattern(String text, String pattern) {
        int[] lp = computePrefix(pattern);
        ConsolePrinter.out(lp);
        int k = 0;
        for(int i=0; i < text.length(); i++) {
            while(pattern.charAt(k) != text.charAt(i)) {
                if(k-1 < 0) {
                    break;
                }
                k = lp[k-1];
                if(k == 0) {
                    break;
                }
            }
            if(pattern.charAt(k) == text.charAt(i)) {
                k = k + 1;
            }
            if(k == pattern.length()) {
                ConsolePrinter.out("Pattern Occured at " + (i-pattern.length()+1));
                if(k-1 >= 0) {
                    k = lp[k-1];
                }
            }
        }

    }



}
