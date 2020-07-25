package algo.sort;

import java.util.Arrays;

public class QuickSort {

    public static void main(String[] args) {
        QuickSort  quickSort = new QuickSort();
        int a [] = new int[] {3,2,1};
        quickSort.quickSort(a,0,a.length-1);
        System.out.println(Arrays.toString(a));
    }

    // 1 4 5 3 2
    // 1 2 5 3 4

    //
    public void quickSort(int [] a, int start, int end) {
        if(start < end) {
            int pivot = partition(a,start,end);
            quickSort(a, start, pivot-1);
            quickSort(a,pivot+1,end);
        }
    }

    public int partition(int a[], int start, int end) {
        int pivot = end;
        int  j = start;
        for(int i=start; i < end; i++) {
            if(a[i] <= a[pivot]) {
                if(i != j) {
                    swap(a,i,j);
                }
                j++;
            }
        }
        swap(a,j,pivot);
        return j;
    }

    private void swap(int a[], int i, int j) {
        int temp = a[i];
        a[i] = a[j];
        a[j] = temp;
    }

}
