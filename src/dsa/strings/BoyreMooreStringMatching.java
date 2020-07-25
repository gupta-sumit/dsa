package algo.strings;

import algo.numbers.Range;

import java.util.HashMap;
import java.util.Map;

public class BoyreMooreStringMatching implements StringMatcher {
    @Override
    public Range findFirstMatch(String text, String pattern) {
        if(pattern.length() > text.length()) {
            // Not found
            return null;
        }
        Map<Character, Integer> positionMap = new HashMap<>();
        int k = 0;
        while(k < pattern.length()) {
            positionMap.put(pattern.charAt(k), k);
            k++;
        }
        int m = pattern.length()-1;
        int n = pattern.length()-1;
        while(m < text.length()) {
            int i = m;
            int j = n;
            while(j >= 0) {
                if(text.charAt(i) == pattern.charAt(j)) {
                    i--;
                    j--;
                } else {
                    break;
                }
            }

            if(j < 0) {
                return new Range(m-n, m);
            }
            if(positionMap.containsKey(text.charAt(i))) {
                Integer loc = positionMap.get(text.charAt(i));
                if(loc > j) {
                    m++;
                } else {
                    m = m + n - loc;
                }
            } else {
                m = m + n;
            }
        }
        return null;
    }
}
