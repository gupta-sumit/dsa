package algo.strings;

import algo.map.MinimumMap;

import java.util.HashMap;
import java.util.Map;

public class WindowString {

    public static void main(String[] args) {
        //"ADOBECODEBANC"
        //"ABC"
        System.out.println(minWindow("ADOBECODEBANC","ABC"));
    }

    public static String minWindow(String str, String text) {

        if(text.length() > str.length()) {
            return "";
        }

        char[] s = str.toCharArray();
        int requiredChar = text.length();
        Map<Character,Count> requiredCount = new HashMap<>();
        for(int i=0; i < text.length(); i++) {
            if(requiredCount.containsKey(text.charAt(i))) {
                requiredCount.get(text.charAt(i)).rc = requiredCount.get(text.charAt(i)).rc + 1;
            } else {
                requiredCount.put(text.charAt(i), new Count(1));
            }
        }


        int left = -1;
        int right = 0;

        int min = Integer.MAX_VALUE;
        String minStr = "";
        int matchedChars= 0;
        boolean matched = false;
        while(right < str.length()) {
            if(requiredCount.containsKey(s[right])) {
                System.out.println(right);
                Count c = requiredCount.get(s[right]);
                c.cc = c.cc + 1;
                if(c.cc <= c.rc) {
                    matchedChars = matchedChars + 1;
                }
                if(left == -1) {
                    left = right;
                }
                if(requiredChar == matchedChars) {
                    System.out.println(right + "  ffff");
                    if(right - left + 1 < min) {
                        min = right - left + 1;
                        minStr = str.substring(left,right+1);
                    }
                    matched = true;
                    requiredCount.get(s[left]).cc = requiredCount.get(s[left]).cc - 1;
                    matchedChars--;
                    left = left+1;
                }
                if(matched || (s[left] == s[right] && requiredCount.get(s[right]).cc > requiredCount.get(s[right]).rc)) {
                    int k = left;
                    boolean b = false;
                    while(k <= right ) {
                        if(requiredCount.containsKey(s[k])) {
                            if(b) {
                                break;
                            } else {
                                if(requiredCount.get(s[k]).cc <= requiredCount.get(s[k]).rc) {
                                    b = true;
                                } else {
                                    requiredCount.get(s[k]).cc = requiredCount.get(s[k]).cc - 1;
                                }


                            }
                        }
                        k++;
                    }
                    left = k;
                }



            }
            right++;

        }

        return minStr;

    }


    static class Count {
        int cc = 0;
        int rc;

        Count(int rc) {
            this.rc = rc;
        }


    }
}
