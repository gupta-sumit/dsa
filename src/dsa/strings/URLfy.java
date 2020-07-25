package algo.strings;

import java.util.Arrays;

public class URLfy {

    public static void main(String[] args) {
        String str = "Mr. John Smith\0\0\0";
        String out = "Mr.%20John%20Smith";
        // "Mr. John Smith"     "
        //
        char[] chars = str.toCharArray();
        replaceSpace(chars);
        System.out.println(Arrays.toString(chars));
    }

    private static void replaceSpace(char c []) {
        int i = 0;
        int lastCharIndex = getLastCharIndex(c);
        while(i < c.length) {
            if(c[i] == ' ') {
                int k = lastCharIndex;
                if(k + 2 < c.length) {
                    while (k > i) {
                        c[k + 2] = c[k];
                        k--;
                    }
                    c[i++] = '%';
                    c[i++] = '2';
                    c[i++] = '0';
                    lastCharIndex = lastCharIndex + 2;
                } else {
                    break;
                }
            } else {
                i++;
            }
        }
    }


    private static int getLastCharIndex(char[] c) {
        int i = c.length-1;
        while(i >= 0) {
            if(c[i] == '\0') {
                i--;
            } else {
                break;
            }
        }
        return i;
    }

}
