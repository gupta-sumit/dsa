package algo.array;

import algo.utils.ArrayUtils;
import algo.utils.ConsolePrinter;

public class SquaresOfSortedArray {

    public static void main(String[] args) {
        int[] nums = ArrayUtils.intArray(-4,-2, -1, 0, 1, 2, 3);
        ConsolePrinter.out(squares(nums));
    }


    public static int [] squares(int nums[]) {
        int left = 0;
        int right = nums.length - 1;
        int [] result = new int[nums.length];
        int k = nums.length - 1;
        while(left < right && k >= 0) {
            if(Math.abs(nums[left]) < Math.abs(nums[right]) ) {
                result[k--] = (int)Math.pow(nums[right],2);
                right--;
            } else {
                result[k--] = (int)Math.pow(nums[left],2);
                left++;
            }
        }
        return result;
    }

}
