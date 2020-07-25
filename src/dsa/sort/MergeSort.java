package algo.sort;

import java.util.Arrays;

public class MergeSort {

    public static void main(String[] args) {
        MergeSort ms = new MergeSort();
        int a [] = new int[] {5,4,1,2,3};
        ms.mergeSort(a,0, a.length-1);
        System.out.println(Arrays.toString(a));
    }

    public void mergeSort(int a [], int start, int end) {
        if(start < end) {
           int mid = start + (end - start)/2;
           //System.out.println("s " + start + " mid "  + mid + " end " + end);
           mergeSort(a,start, mid);
           mergeSort(a, mid+1, end);
           merge(a, start, mid, end);
        }
    }

    // 1 2 3 4 5
    //

    private void merge(int[] a, int start, int mid, int end) {
        int left[]  = new int[mid-start + 1];
        int p = 0;
        for(int i=start; i <= mid; i++) {
            left[p++] = a[i];
        }
        p = 0;
        int right [] = new int[end - mid];
        for(int i=mid+1; i <=end; i++) {
            right[p++] = a[i];
        }
        int i = 0;
        int j = 0;
        int k = start;
        while(i < left.length && j < right.length) {
            if(left[i] <= right[j]) {
                a[k++] = left[i++];
            } else {
                a[k++] = right[j++];
            }
        }
        while(i < left.length) {
            a[k++] = left[i++];
        }
        while(j < right.length) {
            a[k++] = right[j++];
        }
    }
}
