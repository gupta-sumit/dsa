package algo.utils;

public class ArrayUtils {

    public static void swap(int  [] a, int i, int j) {
        int temp = a[i];
        a[i] = a[j];
        a[j] = temp;
    }

    public static int [] intArray(int... a) {
        return a;
    }

    public static void printMatrix(int [][] val) {
        for(int i=0; i < val.length; i++) {
            for(int j = 0; j < val[0].length; j++) {
                System.out.print(val[i][j] + "  ");
            }
            System.out.println();
        }
    }

    public static void printArrayWithIndex(char [] arr) {
        for(int i=0; i < arr.length; i++) {
            System.out.print(arr[i] + ":" + i + " ");
        }
        System.out.println();
    }
}
