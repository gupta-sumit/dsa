package algo.sort;

import algo.utils.ArrayUtils;

import java.util.Arrays;

public class HeapSort {

    public static void main(String[] args) {
        HeapSort heapSort = new HeapSort();
        int a [] = new int[] {5,4,1,2,3,10,11,12,34,0,11,34,44,21};
        heapSort.heapSort(a);
        System.out.println(Arrays.toString(a));
    }

    private  int leftChild(int i) {
        return 2*i + 1;
    }
    private  int rightChild(int i) {
        return 2*i + 2;
    }

    public void heapify(int a[],int i, int size) {
        int  left=leftChild(i);
        int right = rightChild(i);
        int max = i;
        if(left < size && a[left] > a[max]) {
            max = left;
        }
        if(right < size && a[right] > a[max]) {
            max = right;
        }
        if(i != max) {
            ArrayUtils.swap(a,i,max);
            heapify(a, max,size);
        }
    }

    public void buildHeap(int a[]) {
        for(int i=(a.length/2)-1; i >= 0; i--) {
            heapify(a,i,a.length);
        }
    }


    public void heapSort(int a[]) {
        buildHeap(a);
        //System.out.println(Arrays.toString(a));
        int  size = a.length - 1;
        while(size >=0){
            ArrayUtils.swap(a, 0, size);
            size--;
            heapify(a, 0,size + 1);
        }
    }

}
