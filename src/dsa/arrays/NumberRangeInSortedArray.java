package algo.array;

import algo.numbers.Range;
import algo.utils.ArrayUtils;
import algo.utils.ConsolePrinter;

public class NumberRangeInSortedArray {

    public static void main(String[] args) {
        int[] ints = ArrayUtils.intArray(1, 3, 8, 10,10,10,10,10, 15,15,15,15,15,15,16);
        int key = 16;
        int index = binarySearch(ints, key);
        if(index != -1) {
            int startIndex = findStartIndex(ints, key, 0, index - 1);
            int endIndex = findEndIndex(ints, key, index+1, ints.length-1);
            if(startIndex == -1) {
                startIndex = index;
            }
            if(endIndex == -1) {
                endIndex = index;
            }
            ConsolePrinter.out("Key Range " + startIndex + "  " + endIndex);
        } else {
            ConsolePrinter.out("Key not found in array");
        }
    }

    public static int binarySearch(int nums[], int key) {
        int start = 0;
        int end = nums.length -1;
        while(start <= end) {
            int mid = start + (end - start)/2;
            if(nums[mid] == key) {
                return mid;
            }
            if(key < nums[mid]) {
                end = mid - 1;
            } else {
                start = mid + 1;
            }
        }
        return -1;
    }

    public static int findStartIndex(int nums[], int key, int start, int end) {
        int index = -1;
        while(start <= end) {
            int mid = start + (end - start)/2;
            if(nums[mid] == key) {
                index = mid;
                end = mid-1;
            }
            if(key > nums[mid]) {
                start  = mid + 1;
            }
        }
        return index;
    }

    public static int findEndIndex(int nums[], int key, int start, int end) {
        int index = -1;
        while(start <= end) {
            int mid = start + (end - start)/2;
            if(nums[mid] == key) {
                index = mid;
                start = mid + 1;
            }
            if(key < nums[mid]) {
                end= mid - 1;
            }
        }
        return index;
    }

}
