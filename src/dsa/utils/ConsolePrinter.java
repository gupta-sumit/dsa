package algo.utils;

import java.util.Arrays;

public class ConsolePrinter {

    public static void out(Object message) {
        System.out.println(message);
    }

    public static void out(int [] arr) {
        System.out.println(Arrays.toString(arr));
    }

    public static void out(int [] arr, int len) {
        StringBuilder builder = new StringBuilder();
        builder.append("[");
        for(int i=0; i < len; i++) {
            builder.append(arr[i]);
            if(i < len-1) {
                builder.append(", ");
            }
        }
        builder.append("]");
        System.out.println(builder.toString());
    }

}
