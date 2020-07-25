package algo.array;

import java.util.Arrays;

public class NextPermutation {

    public static void main(String[] args) {
        int a [] = new int[] {1,2,3};
        while(nextPermutation(a));
    }

    private static boolean nextPermutation(int a []) {
        int i = a.length - 2;
        while(i > 0 && a[i] >= a[i+1]) {
            i--;
        }
        int k = i+1;
        int max = -1;
        while(k < a.length && a[k] > a[i]) {
            if(max == -1 || a[k] < a[max]) {
                max = k;
            }
            k++;
        }
        if(max != -1) {
            swap(a,i,k-1);
            reverse(a,i+1,a.length-1);
            System.out.println(Arrays.toString(a));
            return true;
        } else {
            reverse(a,0, a.length-1);
            System.out.println(Arrays.toString(a));
            return false;
        }
    }

    private static void reverse(int[] a, int i, int j) {
        while(i < j) {
            swap(a,i,j);
            i++;
            j--;
        }
    }

    private static void swap(int a [], int i, int  j) {
        int temp = a[i];
        a[i] = a[j];
        a[j] = temp;
    }
}
