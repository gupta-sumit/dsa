package dsa.strings;

import java.util.Arrays;

public class KMPStringMatching {

    // ababda
    // 00123

    public MatchResult isSubstring(String text, String pattern) {
        MatchResult matchResult = new MatchResult();
        int [] prefix = createPrefixArray(pattern);
        System.out.println(Arrays.toString(prefix));
        int m = 0; // matched charachers
        int i=0;
        while(i < text.length()) {
            while(pattern.charAt(m) != text.charAt(i)) {
                if(m - 1 < 0) {
                    break;
                } else {
                    m = prefix[m-1];
                }
            }
            if(pattern.charAt(m) == text.charAt(i)) {
                m++;
            }
            if(m == pattern.length()) {
                matchResult.setMatch(true);
                System.out.println(" i " + i + " m " + m);
                matchResult.getMatchIndexes().add(i - m + 1);
                if(m - 1 < 0) {
                    m = 0;
                } else {
                    m = prefix[m-1];
                }
            }
            i++;
        }
        return matchResult;
    }

    private int [] createPrefixArray(String pattern) {
        int [] prefix = new int[pattern.length()];
        prefix[0] = 0;
        int k = 0;
        int i = 1;
        while(i < pattern.length()) {
            while(k > 0 && pattern.charAt(i) != pattern.charAt(k)) {
                k = prefix[k];
            }
            if(pattern.charAt(i) == pattern.charAt(k)) {
                k = k + 1;
                prefix[i] = k;
            }
            i++;
        }
        return prefix;
    }

    public static void main(String[] args) {
        KMPStringMatching kmpStringMatching = new KMPStringMatching();
        System.out.println(kmpStringMatching.isSubstring("abacdabamdabda","abda"));
    }
}
