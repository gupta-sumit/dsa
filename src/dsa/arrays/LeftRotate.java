package algo.array;

import java.util.Arrays;

public class LeftRotate {

    public static void main(String[] args) {
        // 1 2 3 | 4 5
        // 4 5 3 1 2
        // k - (end - start + k
        // k - (end - k
        //
        int a [] = new int[] {1,2,3,4,5,6,7,8};
        rotate(a,0, a.length-1, 6);
        System.out.println(Arrays.toString(a));
    }

    public static void rotate(int a [], int  start, int end, int k) {
        if(k <= 0) {
            return;
        }
        System.out.println("Start " + start + " end " + end + " k " + k + " array " + Arrays.toString(a)) ;
        if(start > end) {
            return;
        }

        int  len = end - start + 1;
        if(k % len == 0) {
            return;
        }
        k = k % len;
        if(start + 2*k - 1 < len) {
            exchange(a,start, start + k-1, start + k, start + 2*k - 1);
            System.out.println(Arrays.toString(a));
            rotate(a,start + k, end, k);

        } else {
            exchange(a,start,start + len - k-1, start + k, end);
            System.out.println(Arrays.toString(a));
            rotate(a,start + len - k ,end, 2*k - len);
            // Start = 2
            // End = 4
            // 2, 5, 4, 4
            //
        }
    }

    private static void exchange(int[] a, int s1, int e1, int s2, int e2) {
        while(s1 <= e1 && s2  <= e2) {
            int temp = a[s1];
            a[s1] = a[s2];
            a[s2] = temp;
            s1++;
            s2++;
        }
    }


}
