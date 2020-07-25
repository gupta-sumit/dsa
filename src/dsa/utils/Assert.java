package algo.utils;

import java.util.function.Supplier;

public class Assert {

    public static void compare(String s1, String s2) {
        if(s1.length() != s2.length()) {
            throw new AssertionError("Length not equal");
        } else {
            int i=0,j=0;
            while(i < s1.length() && j < s2.length() && s1.charAt(i) == s2.charAt(j)) {
                i++;j++;
            }

            if( i < s1.length() && j < s2.length()) {
                throw new AssertionError("Does not match at " + s1.substring(i));
            }
        }
    }

    public static boolean equals(int v1, int v2) {
        if(v1 != v2) {
            throw new AssertionError("Does not match " + v1  + " " + v2);
        }
        return true;
    }

    public static void expect(Runnable runnable, Class<? extends Throwable> exceptionClass) {
        try {
            runnable.run();
            throw new AssertionError("No expected exception thrown " + exceptionClass.getName());
        } catch(Throwable e) {
            if(e instanceof AssertionError) {
                throw e;
            }
            if(!e.getClass().equals(exceptionClass)) {
                throw new AssertionError("Does not match " + exceptionClass  + " " + e.getClass());
            }
        }
    }
}
