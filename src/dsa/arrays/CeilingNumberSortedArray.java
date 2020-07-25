package algo.array;

import algo.utils.ArrayUtils;
import algo.utils.ConsolePrinter;

public class CeilingNumberSortedArray {

    public static void main(String[] args) {
        int[] ints = ArrayUtils.intArray(1, 3, 8, 10, 15);
        ConsolePrinter.out(ceilingNumber(ints,0));

    }

    public static int ceilingNumber(int [] nums, int key) {
        int start = 0;
        int end = nums.length - 1;
        int ceiling = -1;
        while(start <= end) {
            int mid = start + (end - start)/2;
            if(nums[mid] == key) {
                return nums[mid];
            }
            if(key < nums[mid]) {
                ceiling = nums[mid];
                end = mid-1;
            } else {
                start = mid + 1;
            }
        }
        return ceiling;
    }


}
