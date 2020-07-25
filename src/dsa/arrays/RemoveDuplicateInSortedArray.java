package algo.array;

import algo.utils.ArrayUtils;
import algo.utils.ConsolePrinter;

public class RemoveDuplicateInSortedArray {

    public static void main(String[] args) {
        int[] numbers = ArrayUtils.intArray(2,2,2,2,2,2);
        int i = removeDuplicateInSortedArray(numbers);
        ConsolePrinter.out(numbers,i);
    }

    public static int removeDuplicateInSortedArray(int nums[]) {
        if(nums.length <= 1) {
            return nums.length;
        }
        int d=1;
        int i=1;
        while(i < nums.length) {
            if(nums[i] != nums[d-1]) {
                swap(nums, i , d);
                i++;
                d++;
            } else {
                i++;
            }
        }
        return d;
    }

    private static void swap(int[] nums, int i, int d) {
        int temp = nums[i];
        nums[i] = nums[d];
        nums[d] = temp;
    }
}
